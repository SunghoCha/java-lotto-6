package lotto.domain;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DrawingMachine {
    private final Lotto winnigLotto;
    private final BonusNumber bonusNumber;

    public DrawingMachine(List<Integer> winningNumbers, int number) {
        this.winnigLotto = new Lotto(winningNumbers);
        this.bonusNumber = new BonusNumber(number);
    }

    public Map<LottoRank, Integer> compare(Lottos lottos) {
        LinkedHashMap<LottoRank, Integer> rankMap = new LinkedHashMap<>();
        initiateRank(rankMap);
        for (Lotto lotto : lottos.getLottos()) {
            int count = lotto.compare(winnigLotto);
            boolean hasBonus = lotto.hasBonus(bonusNumber);
            LottoRank lottoRank =  LottoRank.from(count, hasBonus);
            rankMap.replace(lottoRank, rankMap.get(lottoRank) + 1);
        }
        return rankMap;
    }

    private static void initiateRank(LinkedHashMap<LottoRank, Integer> rankMap) {
        for (LottoRank lottoRank : LottoRank.values()) {
            rankMap.put(lottoRank, 0);
        }
    }
}

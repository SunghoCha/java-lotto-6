package lotto.domain;

import lotto.BonusNumber;
import lotto.Lotto;
import net.bytebuddy.build.BuildLogger;

import java.util.*;
import java.util.stream.Collectors;

public class Lottos {
    private final Lotto winningLotto;
    private final List<Lotto> lottos = new ArrayList<>();
    private final PurchaseAmount purchaseAmount;


    public Lottos(Lotto winningLotto, PurchaseAmount purchaseAmount) {
        this.winningLotto = winningLotto;
        this.purchaseAmount = purchaseAmount;
        initiate(purchaseAmount);
    }

    private void initiate(PurchaseAmount purchaseAmount) {
        for (int i = 0; i < purchaseAmount.getTryNumber(); i++) {
            lottos.add(LottoFactory.create());
        }
    }

    public Map<LottoStatus, Integer> compare(BonusNumber bonusNumber) {
        Map<LottoStatus, Integer> statusMap = new EnumMap<>(LottoStatus.class);
        for (LottoStatus lottoStatus : LottoStatus.values()) {
            statusMap.put(lottoStatus, 0);
        }
        for (Lotto lotto : lottos) {
            if (lotto.count(winningLotto) == 5) {
                if (lotto.hasBonus(bonusNumber)) {
                    statusMap.replace(LottoStatus.SECOND, statusMap.get(LottoStatus.SECOND) + 1);
                    continue;
                }
                statusMap.replace(LottoStatus.THIRD, statusMap.get(LottoStatus.THIRD) + 1);
            }
        }

//        lottos.stream()
//                .filter(lotto -> lotto.count(winningLotto) == 5)
//                .filter(lotto -> lotto.hasBonus(bonusNumber))
//                .forEach(lotto ->
//                    statusMap.replace(LottoStatus.SECOND, statusMap.get(LottoStatus.SECOND) + 1));

        lottos.stream()
                .map(lotto -> lotto.count(winningLotto))
                .filter(count -> count != 5)
                .forEach(count -> {
                    LottoStatus status = LottoStatus.getStatus(count);
                    statusMap.replace(status, statusMap.get(status) + 1);
                });
        return statusMap;
    }

}

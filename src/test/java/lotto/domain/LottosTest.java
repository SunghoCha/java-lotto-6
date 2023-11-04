package lotto.domain;

import lotto.BonusNumber;
import lotto.Lotto;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LottosTest {

    @Test
    void sdf() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lottos lottos = new Lottos(winningLotto, new PurchaseAmount(8000));
        Map<LottoStatus, Integer> compare = lottos.compare(new BonusNumber(6));
        for (Map.Entry<LottoStatus, Integer> entry : compare.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }
}
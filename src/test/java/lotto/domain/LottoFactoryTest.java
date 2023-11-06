package lotto.domain;

import lotto.Lotto;
import org.junit.jupiter.api.Test;

public class LottoFactoryTest {

    @Test
    void Lotto생성() {
        Lotto lotto = LottoFactory.create();
    }
}

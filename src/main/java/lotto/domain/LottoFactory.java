package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoFactory {

    public static Lotto create() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}

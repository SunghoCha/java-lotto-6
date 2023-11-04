package lotto.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum LottoStatus {

    FIRST(6, BonusStatus.NONE),
    SECOND(5,BonusStatus.BONUS),
    THIRD(11, BonusStatus.NONE),
    FOURTH(4, BonusStatus.NONE),
    FIFTH(3, BonusStatus.NONE),
    TWO(2, BonusStatus.NONE),
    ONE(1, BonusStatus.NONE),
    ZERO(0, BonusStatus.NONE);

    private int count;
    private BonusStatus bonusStatus;

    LottoStatus(int count, BonusStatus bonusStatus) {
        this.count = count;
        this.bonusStatus = bonusStatus;
    }

    public static LottoStatus getStatus(int count) {
        Map<Integer, LottoStatus> statusMap = Arrays.stream(values())
                .collect(Collectors.toMap(LottoStatus::getCount, status -> status));
        return statusMap.get(count);
    }

    public int getCount() {
        return count;
    }
}

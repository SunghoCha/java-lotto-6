package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public enum LottoRank {
    FIRST(1, "3개 일치 (5,000원) - "),
    SECOND(2, "4개 일치 (50,000원) - "),
    THIRD(3, "5개 일치 (1,500,000원) - "),
    FOURTH(4, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIFTH(5, "6개 일치 (2,000,000,000원) -");


    private int rank;
    private String coment;

    LottoRank(int rank, String coment) {
        this.rank = rank;
    }

}

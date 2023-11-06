package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6,2000000000, "6개 일치 (2,000,000,000원) - "),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(5, 1500000, "5개 일치 (1,500,000원) - "),
    FOURTH(4, 50000, "4개 일치 (50,000원) - "),
    FIFTH(3, 5000, "3개 일치 (5,000원) - "),
    LOSE(0, 0, "");

    private final int lottoCount;
    private final int price;
    private final String coment;

    LottoRank(int count, int price, String coment) {
        this.lottoCount = count;
        this.price = price;
        this.coment = coment;
    }

    public static LottoRank from(int count, boolean hasBonus) {
        if (count < 3) {
            return LOSE;
        }
        if (count == 5 && hasBonus) {
            return SECOND;
        }
        return Arrays.stream(values())
                .filter(lottoRank -> !isSECOND(lottoRank) && lottoRank.isMatch(count))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException());
    }

    private static boolean isSECOND(LottoRank lottoRank) {
        return lottoRank == SECOND;
    }

    private boolean isMatch(int count) {
        return lottoCount == count;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public int getPrice() {
        return price;
    }

    public String getComent() {
        return coment;
    }
}

package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoRankTest {

    @ParameterizedTest
    @CsvSource({"first,6", "fifth,3"})
    void Bonus번호없을때_count숫자에따른_일반등수확인(String rank, int count) {
        LottoRank lottoRank = LottoRank.from(count, false);
        assertThat(lottoRank).isEqualTo(LottoRank.FIRST);
    }

    @ParameterizedTest
    @CsvSource({"first,6", "fifth,3"})
    void Bonus번호있을때_count숫자에따른_일반등수확인(String rank, int count) {
        LottoRank lottoRank = LottoRank.from(count, true);
        assertThat(lottoRank).isEqualTo(LottoRank.FIRST);
    }

    @Test
    void count숫자가_5일때_Bonus숫자여부에_따라_2등_3등반환() {
        LottoRank second = LottoRank.from(5, true);
        LottoRank third = LottoRank.from(5, false);
        assertThat(second).isEqualTo(LottoRank.SECOND);
        assertThat(third).isEqualTo(LottoRank.THIRD);
    }

    @Test
    void count숫자가_3미만일떄_LOSE반환() {
        LottoRank lose = LottoRank.from(2, false);
        LottoRank loseWithBonus = LottoRank.from(0, true);
        assertThat(lose).isEqualTo(LottoRank.LOSE);
        assertThat(loseWithBonus).isEqualTo(LottoRank.LOSE);
    }
}
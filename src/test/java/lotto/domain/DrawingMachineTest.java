package lotto.domain;

import lotto.Lotto;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DrawingMachineTest {

    @Test
    void 생성테스트() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Lotto> lottos = Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))
                , new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))
                , new Lotto(Arrays.asList(1, 2, 3, 4, 45, 6))
                , new Lotto(Arrays.asList(1, 2, 3, 14, 15, 6)));
        DrawingMachine drawingMachine = new DrawingMachine(winningNumbers, new BonusNumber(7));
        Map<LottoRank, Integer> result = drawingMachine.compare(lottos);
        assertThat(result.get(LottoRank.FIRST)).isEqualTo(2);
        assertThat(result.get(LottoRank.THIRD)).isEqualTo(1);
        assertThat(result.get(LottoRank.FOURTH)).isEqualTo(1);
    }
}
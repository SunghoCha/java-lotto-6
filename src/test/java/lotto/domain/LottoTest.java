package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @Test
    void 로또_비교해서_일치하는_숫자개수_반환() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 15));
        int count = winningLotto.compare(lotto);
        assertThat(count).isEqualTo(5);
    }

    @Test
    void 로또가_특정숫자를_포함하면_true반환() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 15));
        assertThat(lotto.contains(15)).isTrue();
    }

    @Test
    void 로또가_특정숫자를_포함하지_않으면_false반환() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 15));
        assertThat(lotto.contains(19)).isFalse();
    }
}
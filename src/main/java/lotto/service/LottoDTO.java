package lotto.service;

import lotto.Lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoDTO {
    private List<String> numbers;

    private LottoDTO(Lotto lotto) {
        this.numbers = lotto.getNumbers()
                .stream()
                .map(Integer -> String.valueOf(Integer))
                .collect(Collectors.toList());
    }

    public static LottoDTO from(Lotto lotto) {
        return new LottoDTO(lotto);
    }

    public List<String> getNumbers() {
        return numbers;
    }
}

package lotto;

import lotto.domain.BonusNumber;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public int compare(Lotto winnigLotto) {
        int count = 0;
        for (Integer number : numbers) {
            if (winnigLotto.isContain(number)) {
                count++;
            }
        }
        return count;
    }

    private boolean isContain(Integer number) {
        return numbers.contains(number);
    }

    public boolean hasBonus(BonusNumber bonusNumber) {
       return numbers.contains(bonusNumber.getNumber());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }


    // TODO: 추가 기능 구현
}

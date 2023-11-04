package lotto;

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

    public int count(Lotto lotto) {
        int count = 0;
        for (Integer number : numbers) {
            if (isContains(lotto, number)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isContains(Lotto lotto, Integer number) {
        return lotto.getNumbers().contains(number);
    }

    public boolean hasBonus(BonusNumber bonusNumber) {
        return numbers.contains(bonusNumber.getBonusNumber());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}

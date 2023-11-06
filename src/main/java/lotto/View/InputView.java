package lotto.View;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {
    private static Pattern NUMBER_PATTERN = Pattern.compile("^[\\d]*$");
    private static Pattern LOTTOS_PATTERN = Pattern.compile("^([\\d],){5}+([\\d]){1}$");

    public static int takeInputPrice() {
        try {
            return getInputNumber();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 금액은 숫자로 입력해주세요.");
            return takeInputPrice();
        }
    }

    private static int getInputNumber() {
        System.out.println("구입금액을 입력해 주세요.");
        String price = Console.readLine();
        if (!NUMBER_PATTERN.matcher(price).matches()) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(price);
    }

    public static List<Integer> takeInputWinningNumbers() {
        try {
            return getInputWinningNumbers();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 올바른 입력이 아닙니다.");
            return takeInputWinningNumbers();
        }
    }

    private static List<Integer> getInputWinningNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String numbers = Console.readLine();
        if (!LOTTOS_PATTERN.matcher(numbers).matches()) {
            throw new IllegalArgumentException();
        }
        return Arrays.stream(numbers.split(",")).map(Integer::parseInt).collect(Collectors.toList());
    }

    public static int takeBonusNumber() {
        try {
            return getBonusNumber();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 올바른 입력이 아닙니다.");
            return takeBonusNumber();
        }
    }

    private static int getBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        String number = Console.readLine();
        if (!NUMBER_PATTERN.matcher(number).matches()) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(number);
    }
}

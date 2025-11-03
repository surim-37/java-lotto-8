package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Input {

    public void validateMoney(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("1000원 단위로 입력해야 합니다.");
        }
    }

    public int inputMoney() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            String input = Console.readLine();

            int money;
            try {
                money = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자만 입력해야 합니다.");
                continue;
            }

            if (money % 1000 != 0) {
                System.out.println("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
                continue;
            }

            return money;
        }
    }

    public List<Integer> inputWinningNumbers() {
        while (true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            String input = Console.readLine().trim();

            if (!input.matches("[\\d,\\s]+")) {
                System.out.println("[ERROR] 숫자만 입력해야 합니다.");
                continue;
            }

            if (!input.matches(".*\\d.*")) {
                System.out.println("[ERROR] 숫자만 입력해야 합니다.");
                continue;
            }

            if (!input.contains(",")) {
                if (input.matches("\\d+")) {
                    System.out.println("[ERROR] 번호는 쉼표(,)로 구분해서 입력해야 합니다.");
                }
                continue;
            }

            String[] parts = input.split(",");
            if (parts.length != 6) {
                System.out.println("[ERROR] 당첨 번호는 6개여야 합니다.");
                continue;
            }

            List<Integer> numbers = new ArrayList<>();
            boolean valid = true;

            for (String part : parts) {
                String token = part.trim();

                if (token.isEmpty()) {
                    System.out.println("[ERROR] 숫자만 입력해야 합니다.");
                    valid = false;
                    break;
                }

                int number = Integer.parseInt(token);

                if (number < 1 || number > 45) {
                    System.out.println("[ERROR] 번호는 1에서 45 사이의 숫자만 입력할 수 있습니다.");
                    valid = false;
                    break;
                }

                if (numbers.contains(number)) {
                    System.out.println("[ERROR] 중복된 번호는 입력할 수 없습니다.");
                    valid = false;
                    break;
                }

                numbers.add(number);
            }

            if (!valid) {
                continue;
            }

            return numbers;
        }
    }


    public int inputBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            System.out.println("보너스 번호를 입력해 주세요.");
            String input = Console.readLine().trim();

            int bonusNumber;
            try {
                bonusNumber = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자만 입력해야 합니다.");
                continue;
            }

            if (bonusNumber < 1 || bonusNumber > 45) {
                System.out.println("[ERROR] 보너스 번호는 1~45 사이의 숫자만 입력할 수 있습니다.");
                continue;
            }

            if (winningNumbers.contains(bonusNumber)) {
                System.out.println("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
                continue;
            }

            return bonusNumber;
        }
    }
}
<<<<<<< HEAD

=======
>>>>>>> 176c73aaada6fcc3e14835aaad8f887854de8ef6

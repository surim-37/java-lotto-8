package lotto.View;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int money = Integer.parseInt(input);

        validateMoney(money);
        return money;
    }

    public void validateMoney(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
    }

    public String inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요. (쉼표로 구분 없이 그냥 숫자 나열)");

        String input = Console.readLine();

        if (input.length() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 정확히 6자리여야 합니다.");
        }

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c < '0' || c > '9') {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
            }
        }

        return input;
    }

    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        int bonusNumber = Integer.parseInt(input);

        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이여야 합니다.");
        }

        return bonusNumber;
    }
}
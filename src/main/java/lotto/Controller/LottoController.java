package lotto.Controller;

import lotto.Model.*;
import lotto.View.*;
import java.util.List;

public class LottoController {

    private final Input input = new Input();
    private final Output output = new Output();
    private final LottoMachine machine = new LottoMachine();

    public void run() {

        int money = input.inputMoney();
        List<Lotto> lottos = machine.generateLottos(money);
        output.printLottos(lottos);
        List<Integer> winning = input.inputWinningNumbers();

        int bonus = input.inputBonusNumber(winning);
        LottoResult result = new LottoResult();

        for (Lotto lotto : lottos) {
            int match = machine.compare(lotto, winning);
            boolean bonusMatch = lotto.getNumbers().contains(bonus);
            Rank rank = Rank.getRank(match, bonusMatch);
            result.addResult(rank);
        }

        double profit = result.calculateProfit(money);

        output.printResult(result, profit);
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 176c73aaada6fcc3e14835aaad8f887854de8ef6

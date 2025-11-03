package lotto.Controller;

import lotto.Model.*;
import lotto.View.*;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
public class ControllerTest {

    @Test
    void 로또_한장_생성_및_비교() {
        LottoMachine machine = new LottoMachine();
        LottoResult result = new LottoResult();

        int money = 1000; // 로또 1장 구매
        List<Lotto> lottos = machine.generateLottos(money);

        List<Integer> winning = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        for (Lotto lotto : lottos) {
            int match = machine.compare(lotto, winning); // 당첨 개수 비교
            boolean bonusMatch = lotto.getNumbers().contains(bonus); // 보너스 일치 확인
            Rank rank = Rank.getRank(match, bonusMatch); // 등수
            result.addResult(rank); // 결과
        }

        double profit = result.calculateProfit(money);

        assertThat(profit).isGreaterThanOrEqualTo(0.0);
    }

    @Test
    void 여러장_구매시() {

        LottoMachine machine = new LottoMachine();
        LottoResult result = new LottoResult();

        int money = 5000;
        List<Lotto> lottos = machine.generateLottos(money);

        List<Integer> winning = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        for (Lotto lotto : lottos) {
            int match = machine.compare(lotto, winning);
            boolean bonusMatch = lotto.getNumbers().contains(bonus);
            Rank rank = Rank.getRank(match, bonusMatch);
            result.addResult(rank);
        }

        double profit = result.calculateProfit(money);

        assertThat(profit).isGreaterThanOrEqualTo(0.0);
    }
}


double profit = result.calculateProfit(money);

        assertThat(profit).isGreaterThanOrEqualTo(0.0);
    }
}
package lotto.Model;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @Test
    void 지급_돈만큼_로또_생성() {
        // given (준비)
        LottoMachine machine = new LottoMachine();
        int money = 3000; // 1000원 = 1장

        // when (실행)
        List<Lotto> lottos = machine.generateLottos(money);

        // then (검증)
        assertThat(lottos.size()).isEqualTo(3); // 3장 나와야 함
    }

    @Test
    void 로또_한장_무작위_번호_생성_6개() {
        // given
        LottoMachine machine = new LottoMachine();

        // when
        Lotto lotto = machine.generateLottos(1000).get(0);

        // then
        assertThat(lotto.getNumbers().size()).isEqualTo(6);
    }

    @Test
    void 로또_당첨번호_개수_맞춰보기() {
        // given
        LottoMachine machine = new LottoMachine();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(1, 2, 7, 8, 9, 10);

        // when
        int matchCount = machine.compare(lotto, winningNumbers);

        // then
        assertThat(matchCount).isEqualTo(2); // 1,2가 맞음
    }
}

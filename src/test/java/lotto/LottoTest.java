package lotto;

import lotto.Model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호_범위_벗어나면_예외발생() {
        try {
            new Lotto(List.of(0, 2, 3, 4, 5, 6)); // 0
            System.out.println("예외가 발생해야 하는데 발생하지 않았습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println("예외 발생 확인 (1보다 작음): " + e.getMessage());
        }

        try {
            new Lotto(List.of(1, 2, 3, 4, 5, 46)); // 46
            System.out.println("예외가 발생해야 하는데 발생하지 않았습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println("예외 발생 확인 (45보다 큼): " + e.getMessage());
        }
    }
}

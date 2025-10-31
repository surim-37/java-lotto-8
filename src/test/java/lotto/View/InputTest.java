package lotto.View;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class InputTest {@Test
void 구입금액_예외() {
    Input input = new Input();
    assertThatThrownBy(() -> input.validateMoney(1500))
            .isInstanceOf(IllegalArgumentException.class);
}
}


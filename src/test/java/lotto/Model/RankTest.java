package lotto.Model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class RankTest {

    @Test
    void 일치6개면_1등() {
        assertThat(Rank.getRank(6, false)).isEqualTo(Rank.First);
    }

    @Test
    void 일치5개_보너스일치면_2등() {
        assertThat(Rank.getRank(5, true)).isEqualTo(Rank.Second);
    }

    @Test
    void 일치5개면_3등() {
        assertThat(Rank.getRank(5, false)).isEqualTo(Rank.Third);
    }

    @Test
    void 일치4개면_4등() {
        assertThat(Rank.getRank(4, false)).isEqualTo(Rank.Fourth);
    }

    @Test
    void 일치3개면_5등() {
        assertThat(Rank.getRank(3, false)).isEqualTo(Rank.Fifth);
    }

    @Test
    void 나머지는_꽝() {
        assertThat(Rank.getRank(2, false)).isEqualTo(Rank.None);
    }
}

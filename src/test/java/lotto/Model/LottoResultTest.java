package lotto.Model;

import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.assertj.core.api.Assertions.*;

class LottoResultTest {

    @Test
    void 당첨등수() {
        LottoResult result = new LottoResult();
        result.addResult(Rank.First);
        result.addResult(Rank.Fifth);

        Map<Rank, Integer> resultMap = result.getResultMap();
        assertThat(resultMap.get(Rank.First)).isEqualTo(1);
        assertThat(resultMap.get(Rank.Fifth)).isEqualTo(1);
    }

    @Test
    void 수익률_계산_정확() {
        LottoResult result = new LottoResult();
        result.addResult(Rank.First); // 20억
        double rate = result.calculateProfit(100_000);
        assertThat(rate).isEqualTo(2_000_000.0);
    }
}

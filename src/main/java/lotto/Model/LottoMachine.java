package lotto.Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_MAX = 45;

    // 지급 돈만큼 로또 생성
    public List<Lotto> generateLottos(int money) {
        int count = money / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottos.add(createLotto());
        }
        return lottos;
    }

    // 로또 한 장 무작위 번호 생성 (✅ missionutils.Randoms 사용)
    private Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, LOTTO_MAX, LOTTO_SIZE);
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    // 로또 맞춰보기
    public int compare(Lotto lotto, List<Integer> winningNumbers) {
        int matchCount = 0;

        for (int num : lotto.getNumbers()) {
            if (winningNumbers.contains(num)) {
                matchCount++;
            }
        }
        return matchCount;
    }
}

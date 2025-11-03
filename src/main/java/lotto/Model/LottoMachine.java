package lotto.Model;


import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class LottoMachine {
    private static final int Lotto_price = 1000;
    private static final int Lotto_size = 6;
    private static final int Lotto_max = 45;

    //지급 돈만큼 로또 생성
    public List<Lotto> generateLottos(int money) {
        int count = money / Lotto_price;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottos.add(createLotto());
        }
        return lottos;
    }

    //로또 한장 무작위 번호 생성
    private Lotto createLotto() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < Lotto_size) {
            int num = (int) (Math.random() * Lotto_max) + 1;

            if (!numbers.contains(num)) {
                numbers.add(num);
            }
        }
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    //로또 맞춰보기
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


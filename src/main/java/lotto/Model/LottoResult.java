package lotto.Model;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    Map<Rank, Integer> resultMap = new HashMap<>();

    public LottoResult() {
        for (Rank rank : Rank.values()) {
            resultMap.put(rank, 0);
        }
    }

    public void addResult(Rank rank) {
        int count = resultMap.get(rank);
        count = count + 1;
        resultMap.put(rank, count);
    }

    public Map<Rank, Integer> getResultMap() {
        return resultMap;
    }

    public double calculateProfit(int totalMoney) {
        long totalPrize = 0;

        for (Rank rank : Rank.values()) {
            int count = resultMap.get(rank);
            long prize = rank.getPrize();

            totalPrize = totalPrize + (prize * count);
        }

        double profit = (double) totalPrize / totalMoney * 100;

        profit = Math.round(profit * 10) / 10.0;

        return profit;
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 176c73aaada6fcc3e14835aaad8f887854de8ef6

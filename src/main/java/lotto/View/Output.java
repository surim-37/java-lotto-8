package lotto.View;

import lotto.Model.Lotto;
import lotto.Model.LottoResult;
import lotto.Model.Rank;
import java.util.List;

public class Output {

    public void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printResult(LottoResult result, double profit) {
        System.out.println("\n당첨 통계\n---");
        for (Rank rank : Rank.values()) {
            if (rank == Rank.None) continue;
            String text = makeRankText(rank);
            System.out.println(text + " - " + result.getResultMap().get(rank) + "개");
        }
        System.out.println("총 수익률은 " + profit + "%입니다.");
    }

    private String makeRankText(Rank rank) {
        return switch (rank) {
            case First -> "6개 일치 (2,000,000,000원)";
            case Second -> "5개 일치, 보너스 볼 일치 (30,000,000원)";
            case Third -> "5개 일치 (1,500,000원)";
            case Fourth -> "4개 일치 (50,000원)";
            case Fifth -> "3개 일치 (5,000원)";
            default -> "";
        };
    }
}


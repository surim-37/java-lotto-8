package lotto.Model;

public enum Rank {
    First(6, false, 2_000_000_000),
    Second(5, true, 30_000_000),
    Third(5, false, 1_500_000),
    Fourth(4, false, 50_000),
    Fifth(3, false, 5_000),
    None(0, false, 0);

    private final int matchCount;   // 맞은 개수
    private final boolean bonus;    // 보너스 포함 여부
    private final int prize;        // 상금

    Rank(int matchCount, boolean bonus, int prize) {
        this.matchCount = matchCount;
        this.bonus = bonus;
        this.prize = prize;
    }

    // 일치 개수, 보너스로 등수 반환
    public static Rank getRank(int matchCount, boolean bonus) {
        if (matchCount == 6)
            return First;
        if (matchCount == 5 && bonus)
            return Second;
        if (matchCount == 5)
            return Third;
        if (matchCount == 4)
            return Fourth;
        if (matchCount == 3)
            return Fifth;
        return None;
    }

    public int getPrize() {
        return prize;
    }
}

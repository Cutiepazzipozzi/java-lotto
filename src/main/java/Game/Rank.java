package Game;

public enum Rank {
    one("6개 일치 (2,000,000,000원) - ", 2_000_000_000),
    two("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30_000_000),
    three("5개 일치 (1,500,000원) - ", 1_500_000),
    four("4개 일치 (50,000원) - ", 50_000),
    five("3개 일치 (5,000원) - ", 5_000);

    private final String announce;

    private final int award;

    private Rank(String announce, int award) {
        this.announce = announce;
        this.award = award;
    }

    public String getAnnounce() {
        return this.announce;
    }

    public int getAward() {
        return this.award;
    }
}

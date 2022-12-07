package View;

import Game.Rank;

import java.util.List;

public class Output {

    public void printLottos(int purchaseNum, List<List<Integer>> lottos) {
        System.out.println(purchaseNum+"개를 구매했습니다.");
        for(int i = 0; i < lottos.size(); i++) {
            System.out.println(lottos.get(i));
        }
    }

    public void printResult(List<Integer> rank) {
        System.out.println("당첨 통계 \n ---");
        System.out.println(Rank.five.getAnnounce() + rank.get(0) + "개");
        System.out.println(Rank.four.getAnnounce() + rank.get(1) + "개");
        System.out.println(Rank.three.getAnnounce() + rank.get(2) + "개");
        System.out.println(Rank.two.getAnnounce() + rank.get(3) + "개");
        System.out.println(Rank.one.getAnnounce() + rank.get(4) + "개");
    }

    public void printProfit(String profit) {
        System.out.println("총 수익률은 " + profit + "%입니다.");
    }
}

package Game;

import View.Input;
import View.Output;
import lotto.AnswerLotto;
import lotto.Lottos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Game.Rank.*;

public class GameController {

    private Lottos lottos;

    private AnswerLotto answerLotto;

    private final Input input = new Input();

    private final Output output = new Output();

    private final static Rank[] rankPrice = new Rank[]{one, two, three, four, five};

    private static final int unitPercent = 100;

    public void progressGame() {
        String price = input.inputPrice();
        this.generateLottos(Integer.parseInt(price));
        this.inputAnswer();
        this.handleOutput(this.handleWinning(), Integer.parseInt(price));;
    }

    public void generateLottos(int price) {
        this.lottos = new Lottos(price);
        output.printLottos(lottos.getPurchaseNumber(), lottos.getLottos());
    }

    public void inputAnswer() {
        String[] answer = input.inputAnswer();
        List<Integer> newAnswer = new ArrayList<>();
        for (String s : answer) {
            newAnswer.add(Integer.parseInt(s));
        }
        int bonus = Integer.parseInt(input.inputBonus(answer));
        this.answerLotto = new AnswerLotto(newAnswer, bonus);
    }

    public int countWinning(List<Integer> lotto, List<Integer> answer, int bonus) {
        int count = 0;
        for (Integer num : lotto) {
            if (answer.contains(num)) {
                count++;
            }
        }
        count = this.countBonus(count, lotto, bonus);
        return count;
    }

    public int countBonus(int count, List<Integer> lotto, int bonus) {
        if (count == 5 && lotto.contains(bonus)) {
            count = 7;
        }
        return count;
    }

    public void divideRank(int count, List<Integer> rank) {
        if (count == 7) {
            rank.set(3, rank.get(3) + 1);
            return;
        }
        if (count >= 3) {
            rank.set(count - 3, rank.get(count - 3) + 1);
        }
    }

    public List<Integer> handleWinning() {
        List<Integer> rank = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0)); // 3 4 5 5+보 6
        for (int i = 0; i < lottos.getLottos().size(); i++) {
            List<Integer> lotto = lottos.getLottos().get(i);
            int count = this.countWinning(lotto, answerLotto.getAnswer(), answerLotto.getBonusNum());
            this.divideRank(count, rank);
        }
        return rank;
    }

    public String calcProfit(List<Integer> rank, int price) {
        double profit = 0;
        for (int i = 0; i < rank.size(); i++) {
            profit += rankPrice[rank.size()-1-i].getAward() * rank.get(i);
        }
        return String.format("%.1f", (profit / price) * unitPercent);
    }

    public void handleOutput(List<Integer> rank, int price) {
        output.printResult(rank);
        output.printProfit(this.calcProfit(rank, price));
    }
}
        
  
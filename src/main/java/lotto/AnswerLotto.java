package lotto;

import java.util.ArrayList;
import java.util.List;

public class AnswerLotto {

    private final List<Integer> answer = new ArrayList<>();

    private final int bonusNum;

    public AnswerLotto(String[] answer, String bonus) {
        generateAnswer(answer);
        bonusNum = Integer.parseInt(bonus);
    }

    public void generateAnswer(String[] input) {
        for (String s : input) {
            answer.add(Integer.parseInt(s));
        }
    }

    public int countWinning(List<Integer> lotto) {
        int count = 0;
        for (Integer num : lotto) {
            if (answer.contains(num)) {
                count++;
            }
        }
        count = this.countBonus(count, lotto);
        return count;
    }

    public int countBonus(int count, List<Integer> lotto) {
        if (count == 5 && lotto.contains(bonusNum)) {
            count = 7;
        }
        return count;
    }
}

package lotto;

import java.util.ArrayList;
import java.util.List;

public class AnswerLotto {

    private final List<Integer> answer;

    private final int bonusNum;

    public AnswerLotto(List<Integer> answerNum, int bonus) {
        this.answer = answerNum;
        this.bonusNum = bonus;
    }

    public List<Integer> getAnswer() {
        return this.answer;
    }

    public int getBonusNum() {
        return this.bonusNum;
    }
}

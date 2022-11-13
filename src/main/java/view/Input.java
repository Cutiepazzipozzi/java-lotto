package view;

import camp.nextstep.edu.missionutils.Console;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Input {
    private int number;

    private final List<Integer> answer;

    private int bonus;

    private final static int unitPrice = 1000;

    public Input() {
        number = 0;
        answer = new ArrayList<>();
        bonus = 0;
    }

    public int getNumber() {
        return this.number;
    }

    public List<Integer> getAnswer() {
        return this.answer;
    }

    public int getBonus() {
        return this.bonus;
    }

    public String enterPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public void validatePrice(String price) {
        if (Valid.isNotNumber(price)) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 숫자입니다.");
        }
        if (Valid.isEnterValid(price)) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000으로 나누어 떨어져야 합니다.");
        }
    }

    public void returnPrice(String price) {
        validatePrice(price);
        int priceNum = Integer.parseInt(price);
        number = priceNum / unitPrice;
    }

    public String[] enterAnswer() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine().split(",");
    }

    public void validateAnswer(String[] enterAnswer) {
        if(Valid.checkValidAnswer(enterAnswer)) {
            throw new IllegalArgumentException("[ERROR] 1-45까지의 수 중 서로 다른 6개의 수를 골라 입력하세요.");
        }
    }

    public void returnAnswer(String[] enterAnswer) {
        validateAnswer(enterAnswer);
        int[] answerNumber= Arrays.stream(enterAnswer).mapToInt(Integer::parseInt).toArray();
        for (int i : answerNumber) {
                answer.add(i);
        }
    }

    public String enterBonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public void validateBonus(String bonusNum, String[] answer) {
        if(Valid.checkValidBonus(bonusNum, answer)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 정답 수 제외 1~45 수 중 하나의 숫자를 입력해 주세요.");
        }
    }

    public void returnBonus(String bonusNum, String[] answer) {
        validateBonus(bonusNum, answer);
        bonus = Integer.parseInt(bonusNum);
    }
}


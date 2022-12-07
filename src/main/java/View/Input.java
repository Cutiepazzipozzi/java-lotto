package View;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public String inputPrice() {
        System.out.println("구입 금액을 입력해 주세요.");
        String price = Console.readLine();

        validatePrice(price);

        return price;
    }

    public String[] inputAnswer() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String answer = Console.readLine();

        validateAnswer(answer);

        return answer.split(",");
    }

    public String inputBonus(String[] answer) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonus = Console.readLine();

        validateBonus(bonus, answer);

        return bonus;
    }

    private void validatePrice(String price) {
        if(Valid.checkEmpty(price)) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 필요합니다.");
        }
        if(Valid.checkPriceNumber(price)) {
            throw new IllegalArgumentException("[ERROR] 입력 값은 숫자만 입력해 주세요.");
        }
        if(Valid.checkPriceMultiple(price)) {
            throw new IllegalArgumentException("[ERROR] 입력 값은 1000의 배수를 입력해 주세요.");
        }
    }

    private void validateAnswer(String answer) {
        if(Valid.checkEmpty(answer)){
            throw new IllegalArgumentException("[ERROR] 정답 수를 입력해주세요.");
        }
        if(Valid.checkAnswerNumber(answer)){
            throw new IllegalArgumentException("[ERROR] 정답 수는 숫자만 입력해주세요.");
        }
        if(Valid.checkAnswerRepeat(answer) || Valid.checkAnswerNotInRange(answer)){
            throw new IllegalArgumentException("[ERROR] 정답 수는 중복 없이 1-45 사이 6개 숫자를 입력해주세요.");
        }
    }

    private void validateBonus(String bonus, String[] answer) {
        if (Valid.checkBonusMany(bonus) || Valid.checkBonusRepeat(bonus, answer) || Valid.checkBonusNotInRange(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 수는 정답 수와 중복되지 않는 하나의 수입니다.");
        }
    }
}

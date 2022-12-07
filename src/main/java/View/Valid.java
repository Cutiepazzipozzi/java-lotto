package View;

import java.util.Arrays;
import java.util.HashSet;

public class Valid {

    public static boolean checkPriceNumber(String price) {
        return !price.replaceAll("[0-9]", "").equals("");
    }

    public static boolean checkPriceMultiple(String price) {
        int priceInt = Integer.parseInt(price);
        return priceInt % 1000 != 0;
    }

    public static boolean checkEmpty(String answer) {
        return answer.equals("");
    }

    public static boolean checkAnswerNumber(String answer) {
        String[] splitArray = answer.split(",");
        return !String.join("", splitArray).replaceAll("[0-9]", "").equals((""));
    }
    public static boolean checkAnswerRepeat(String answer) {
        String[] numbers = answer.split(",");
        HashSet<String> hashSet = new HashSet<>(Arrays.asList(numbers));
        return !(numbers.length == hashSet.size());
    }

    public static boolean checkAnswerNotInRange(String answer) {
        String[] splitArray = answer.split(",");
        for (String s : splitArray) {
            if (!(Integer.parseInt(s) >= 1 && Integer.parseInt(s) <= 45)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkBonusMany(String bonus) {
        return !(bonus.length() == 1);
    }

    public static boolean checkBonusRepeat(String bonus, String[] answer) {
        return Arrays.stream(answer).anyMatch(bonus::equals);
    }

    public static boolean checkBonusNotInRange(String bonus) {
        int bonusNum = Integer.parseInt(bonus);
        return !(bonusNum >= 1 && bonusNum <= 45);
    }
}
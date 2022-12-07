package lotto;

import lotto.Lotto;
import lotto.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private int purchaseNumber = 0;

    private List<List<Integer>> lottos = new ArrayList<>();

    private Lotto lotto;

    private static final int unitPrice = 1000;

    public int getPurchaseNumber() {
        return this.purchaseNumber;
    }

    public List<List<Integer>> getLottos() {
        return this.lottos;
    }

    public Lottos(int price) {
        this.purchaseNumber = price / unitPrice;
        this.lottos = this.generate();
    }

    public List<List<Integer>> generate() {
        List<List<Integer>> numbers = new ArrayList<>();
        for(int i = 0; i < purchaseNumber; i++) {
            lotto = new Lotto(LottoNumberGenerator.generate());
            numbers.add(lotto.getNumbers());
        }
        return numbers;
    }

}

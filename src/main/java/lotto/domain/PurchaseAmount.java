package lotto.domain;

public class PurchaseAmount {
    private final int amount;

    public PurchaseAmount(int amount) {
        //예외 로직
        this.amount = amount;
    }

    public int getTryNumber() {
        //예외 로직
        return amount/1000;
    }
}

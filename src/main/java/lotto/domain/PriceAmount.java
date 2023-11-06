package lotto.domain;

public class PriceAmount {
    private final int amount;

    public PriceAmount(int amount) {
        this.amount = amount;
    }

    public int getTrynumber() {
        return amount/1000;
    }

    public int getAmount() {
        return amount;
    }
}

package lotto.domain;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> Lottos = new ArrayList<>();

    public Lottos(PriceAmount priceAmount) {
        for (int i = 0; i < priceAmount.getTrynumber(); i++) {
            Lottos.add(LottoFactory.create());
        }
    }

    public List<Lotto> getLottos() {
        return Lottos;
    }
}

package lotto.domain;

import lotto.Lotto;


import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;

public class DrawingMachine {
    private final Lotto winningLotto;
    private final PurchaseAmount purchaseAmount;
    private final Map<LottoStatus, Integer> resultMap = new EnumMap<>(LottoStatus.class);

    public DrawingMachine(Lotto winningLotto, PurchaseAmount purchaseAmount) {
        this.winningLotto = winningLotto;
        this.purchaseAmount = purchaseAmount;
    }

//    public void compare() {
//        int tryNumber = purchaseAmount.getTryNumber();
//
//        for (int i = 0; i < tryNumber; i++) {
//            Lotto lotto = LottoFactory.create();
//            int count = 0;
//            for (Integer number : winningLotto.getNumbers()) {
//
//                if (lotto.getNumbers().contains(number)) {
//                    count++;
//                }
//            }
//            resultMap.put(LottoStatus.getStatus(count), count);
//        }
//        if (resultMap.get(LottoStatus.FIVE)) {
//        }
//    }
}

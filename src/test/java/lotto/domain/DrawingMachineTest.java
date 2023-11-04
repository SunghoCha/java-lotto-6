package lotto.domain;

import lotto.Lotto;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class DrawingMachineTest {

    @Test
    void sdf() {

        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        PurchaseAmount purchaseAmount = new PurchaseAmount(8000);

        DrawingMachine drawingMachine = new DrawingMachine(lotto, purchaseAmount);
//        drawingMachine.compare();
    }

    @Test
    void sdfd() {
        for (int i = 0; i < 7; i++) {
            if (i % 2 == 0) {
                if (i % 3 == 0) {
                    System.out.println("3의 배수" + i);
                    continue;
                }
                System.out.println("2의 배수지만 3의 배수는 아닌" + i);
            }
        }
    }
}


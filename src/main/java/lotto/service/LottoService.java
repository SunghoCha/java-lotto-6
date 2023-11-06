package lotto.service;

import lotto.domain.DrawingMachine;
import lotto.domain.LottoRank;
import lotto.domain.Lottos;
import lotto.domain.PriceAmount;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoService {
    private final PriceAmount priceAmount;
    private final Lottos lottos;

    public LottoService(int number) {
        this.priceAmount = new PriceAmount(number);
        this.lottos = new Lottos(priceAmount);
    }

    public List<LottoDTO> getLottosDTO() {
        return lottos.getLottos().stream().map(lotto -> LottoDTO.from(lotto)).collect(Collectors.toList());
    }

    public Map<LottoRank, Integer> report(List<Integer> winningNumbers, int bonusNumber) {
        DrawingMachine drawingMachine = new DrawingMachine(winningNumbers, bonusNumber);
        return drawingMachine.compare(lottos);
    }

    public int getPriceDTO() {
        return priceAmount.getAmount();
    }
}

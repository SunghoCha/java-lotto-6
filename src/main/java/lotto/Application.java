package lotto;

import lotto.View.InputView;
import lotto.View.OutputView;
import lotto.domain.DrawingMachine;
import lotto.domain.LottoRank;
import lotto.service.LottoDTO;
import lotto.service.LottoService;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoService lottoService = new LottoService(InputView.takeInputPrice());
        List<LottoDTO> lottosDTO = lottoService.getLottosDTO();
        OutputView.printLotto(lottosDTO);

        Map<LottoRank, Integer> report =
                lottoService.report(InputView.takeInputWinningNumbers(), InputView.takeBonusNumber());
        int priceDTO = lottoService.getPriceDTO();
        OutputView.printResult(report, priceDTO);
    }
}

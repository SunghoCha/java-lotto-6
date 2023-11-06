package lotto.View;

import lotto.domain.LottoRank;
import lotto.service.LottoDTO;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    public static void printLotto(List<LottoDTO> lottosDTO) {
        System.out.println();
        System.out.println(String.format("%d개를 구매했습니다.", lottosDTO.size()));
        for (LottoDTO lottoDTO : lottosDTO) {
            String numbers = lottoDTO.getNumbers().stream().collect(Collectors.joining(", "));
            System.out.println(String.format("[%s]", numbers));
        }
    }

    public static void printResult(Map<LottoRank, Integer> report, int PriceDTO) {
        int sum = 0;
        report.remove(LottoRank.LOSE);
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Map.Entry<LottoRank, Integer> rankEntry : report.entrySet()) {
            System.out.println(String.format("%s%d개", rankEntry.getKey().getComent(), rankEntry.getValue()));
            sum += rankEntry.getKey().getPrice() * rankEntry.getValue();
        }
        double ratio = (double) sum * 100 / PriceDTO;
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", ratio));
        System.out.println("---");
    }
}

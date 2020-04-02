package provaQuintess;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class MainProcessaResultado {

	public static void main(String[] args) throws ParseException {

		// Inicio do método de calculo de processamento de tempo.
		long tempoInicial = System.currentTimeMillis();

		LeituraCsvOperacoes leituraCsvOperacoes = new LeituraCsvOperacoes();
		LeituraCsvDadosMercado leituraCsvDadosMercado = new LeituraCsvDadosMercado();
		CalcDiferencaDias cd = new CalcDiferencaDias();
		GenerateCsv geraCsv = new GenerateCsv();

		List<Operacoes> operacoes = leituraCsvOperacoes.buscar();
		List<DadosMercado> listaDadosMercado = leituraCsvDadosMercado.buscar();
		List<ResultadoSubproduto> carteiraSubproduto = new ArrayList<ResultadoSubproduto>();

		for (int i = 0; i < operacoes.size(); i++) {
			Operacoes operacao = operacoes.get(i);

			Date dataInicio = operacao.getDataInicio();
			Date dataFim = operacao.getDataFim();
			long diferencaDias = cd.calculaDiferencaDias(dataInicio, dataFim);

			BigDecimal resultado = BigDecimal.ZERO;

			for (int contador = 0; contador < listaDadosMercado.size(); contador++) {
				DadosMercado dadoMercado = listaDadosMercado.get(contador);
				if (diferencaDias == dadoMercado.getPrazoDiasCorridos()
						&& operacao.getIdPreco() == dadoMercado.getIdPreco()) {
					resultado = dadoMercado.getValorPreco().multiply(operacao.getQuantidade());
					break;
				}
			}

			ResultadoSubproduto rs = null;
			for (int contador = 0; contador < carteiraSubproduto.size(); contador++) {
				ResultadoSubproduto resultadosp = carteiraSubproduto.get(contador);
				if (operacao.getNmSubProduto().equals(resultadosp.getNmSubproduto())) {
					rs = resultadosp;
					break;
				}
			}

			if (rs == null) {
				carteiraSubproduto.add(new ResultadoSubproduto(operacao.getNmSubProduto(), resultado));
			} 
			else {
				BigDecimal resultadoAnterior = rs.getResultado();
				rs.setResultado(resultadoAnterior.add(resultado));
			}

		}
		geraCsv.generateCsvFile(carteiraSubproduto);

		long tempoFinal = System.currentTimeMillis();
		System.out.println("Tempo em millis: " + (tempoFinal - tempoInicial));
	}

}

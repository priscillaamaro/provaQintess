
package provaQuintess;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GenerateCsv {

	public void generateCsvFile(List<ResultadoSubproduto> resultados) {

		try {

			FileWriter writer = new FileWriter("Resultado.csv");

			writer.append("Subproduto");
			writer.append(';');
			writer.append("Resultado");
			writer.append('\n');

			for (int i = 0; i < resultados.size(); i++) {
				ResultadoSubproduto resultadoSubproduto = resultados.get(i);
				writer.append(resultadoSubproduto.getNmSubproduto());
				writer.append(';');
				writer.append(resultadoSubproduto.getResultado().toString());
				writer.append('\n');
			}
			writer.close();
		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}
}

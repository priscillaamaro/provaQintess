//Classe responsável por ler o arquivo CSV DadosMercado.

//Importacao de bibliotecas conforme necessidade e sugestao da IDE.
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import provaQuintess.DadosMercado;

public class LeituraCsvDadosMercado {
	
	public  List<DadosMercado> buscar() {
		
		//Nomeando o arquivo e definindo o Split (pesquisa Google)
		
		String arquivoCSV = "DadosMercado.csv";
	    BufferedReader br = null;
	    String linha = "";
	    String csvDivisor = ";";
	    
	    
	    try {

	        br = new BufferedReader(new FileReader(arquivoCSV));
	        
	        ArrayList<DadosMercado> dadosMercado = new ArrayList<DadosMercado>();
	        
	        boolean primeiraLinha = true;
	        
	        while ((linha = br.readLine()) != null) {
	        	
	        	//Condicao para ignorar a primeira linha do arquivo por se tratar de um cabecalho.
	        	if(primeiraLinha == true) {
	        		
	        	primeiraLinha = false;
	        	continue;
	        	
	        	}
	        	
	        	//Metodo "split" separa os dadaos das linhas do arquivo csv de acordo com o divisor definido em "csDivisor".
	            String[] dados = linha.split(csvDivisor);
	            long idPreco = Long.parseLong( dados[0]);
				int prazoDiasCorridos = Integer.parseInt(dados[1]);
				
				//Conversao de caractere "," por "." por java nao entender "," como separador decimal.
				String conversaochar = dados[2].replace(",", ".");
				BigDecimal valorPreco= new BigDecimal(conversaochar);
				
				//Instancia da classe para adicionar dados na lista.
				DadosMercado dm = new DadosMercado(idPreco, prazoDiasCorridos, valorPreco);
				dadosMercado.add(dm);

	        }
	        return dadosMercado;

	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	        return null;
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    } finally {
	        if (br != null) {
	            try {
	                br.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}

}

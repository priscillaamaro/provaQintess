package provaQuintess;


//Classe responsável por ler o arquivo.

	//Importacao de bibliotecas conforme necessidade e sugestao da IDE.
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class LeituraCsvOperacoes {
		
		public List<Operacoes> buscar() throws ParseException {
			
			//Nomeando o arquivo e definindo o Split (pesquisa Google em Stack OverFlow).
			
			String arquivoCSV = "Operacoes.csv";
		    BufferedReader br = null;
		    String linha = "";
		    String csvDivisor = ";";
		    
		    
		    try {

		        br = new BufferedReader(new FileReader(arquivoCSV));
		        
		        ArrayList<Operacoes> listaOperacoes = new ArrayList<Operacoes>();
		        
		        boolean primeiraLinha = true;
		        
		        while ((linha = br.readLine()) != null) {
		        	//Condicao para ignorar a primeira linha do arquivo por se tratar de um cabecalho.
		        	if(primeiraLinha == true) {
		        		
		        	primeiraLinha = false;
		        	continue;
		        	
		        	}
		        	
		        	//Metodo "split" separa os dadaos das linhas do arquivo csv de acordo com o divisor definido em "csDivisor".
		            String[] dados = linha.split(csvDivisor);
					
					String codOperacao = dados[0];
				    String nmSubProduto = dados[9];
				    
				    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				    Date dataInicio = formatter.parse(dados[1]);
				    Date dataFim = formatter.parse(dados[2]);
				    long idPreco = Long.parseLong(dados[13]);
				    
				  //Conversao de caractere "," por "." por java nao entender "," como separador decimal.
					String conversaochar = dados[12].replace(",", ".");
					BigDecimal quantidade = new BigDecimal(conversaochar);
					
					//Instancia da classe para adicionar dados na lista.
					Operacoes op = new Operacoes(codOperacao, nmSubProduto, dataInicio, dataFim, idPreco, quantidade);
					listaOperacoes.add(op);

		        }
		        return listaOperacoes; 

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



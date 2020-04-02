package provaQuintess;
//Importacao de bibliotecas conforme necessidade e sugestao da IDE.
import java.math.BigDecimal;

public class ResultadoSubproduto {
	
	private String nmSubproduto;
	private BigDecimal resultado;
	
	public ResultadoSubproduto(String nmSubproduto, BigDecimal resultado) {
		this.nmSubproduto = nmSubproduto;
		this.resultado = resultado;
		
	}

	public String getNmSubproduto() {
		return nmSubproduto;
	}

	public void setNmSubproduto(String nmSubproduto) {
		this.nmSubproduto = nmSubproduto;
	}

	public BigDecimal getResultado() {
		return resultado;
	}

	public void setResultado(BigDecimal resultado) {
		this.resultado = resultado;
	}
	
	

}

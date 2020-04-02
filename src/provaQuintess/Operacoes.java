package provaQuintess;


import java.math.BigDecimal;
import java.util.Date;

public class Operacoes {
	private String codOperacao;
	private String nmSubProduto;
	private Date dataInicio;
	private Date dataFim;
	private long idPreco;
	private BigDecimal quantidade;
	
	public Operacoes(String codOperacao, String nmSubProduto, Date dataInicio, Date dataFim, long idPreco, BigDecimal quantidade){
		this.codOperacao = codOperacao;
		this.nmSubProduto = nmSubProduto;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.idPreco = idPreco;
		this.quantidade = quantidade;
		
	}
	public String getCodOperacao() {
		return codOperacao;
	}

	public void setCodOperacao(String codOperacao) {
		this.codOperacao = codOperacao;
	}

	public String getNmSubProduto() {
		return nmSubProduto;
	}

	public void setNmSubProduto(String nmSubProduto) {
		this.nmSubProduto = nmSubProduto;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public long getIdPreco() {
		return idPreco;
	}

	public void setIdPreco(long idPreco) {
		this.idPreco = idPreco;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}
	

}

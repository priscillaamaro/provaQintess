package provaQuintess;

import java.math.BigDecimal;

public class DadosMercado {

	private long idPreco;
	private int prazoDiasCorridos;
	private BigDecimal valorPreco;
	
	public DadosMercado(long idPreco, int prazoDiasCorridos, BigDecimal valorPreco) {
		this.idPreco = idPreco;
		this.prazoDiasCorridos = prazoDiasCorridos;
		this.valorPreco = valorPreco;
		
	}
	
	public long getIdPreco() {
		return idPreco;
	}

	public void setIdPreco(long idPreco) {
		this.idPreco = idPreco;
	}

	public int getPrazoDiasCorridos() {
		return prazoDiasCorridos;
	}

	public void setPrazoDiasCorridos(int prazoDiasCorridos) {
		this.prazoDiasCorridos = prazoDiasCorridos;
	}

	public BigDecimal getValorPreco() {
		return valorPreco;
	}

	public void setValorPreco(BigDecimal valorPreco) {
		this.valorPreco = valorPreco;
	}

	
}

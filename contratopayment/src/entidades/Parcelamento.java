package entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Parcelamento {
	
	private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private LocalDate dataDeVencimento;
	private Double quantidade;
	
	
	public Parcelamento(LocalDate dataDeVencimento, Double quantidade) {;
		this.dataDeVencimento = dataDeVencimento;
		this.quantidade = quantidade;
	}


	public LocalDate getDataDeVencimento() {
		return dataDeVencimento;
	}


	public void setDataDeVencimento(LocalDate dataDeVencimento) {
		this.dataDeVencimento = dataDeVencimento;
	}


	public Double getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return dataDeVencimento.format(fmt) + " - " + String.format("%.2f", quantidade);
	}
	
}

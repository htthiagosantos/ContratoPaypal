package servicos;

import java.time.LocalDate;

import entidades.Contrato;
import entidades.Parcelamento;
import interfaces.PagamentoDeServicoOnline;

public class ContratoDeServico {

	private PagamentoDeServicoOnline pagamentoDeServicoOnline;

	public ContratoDeServico(PagamentoDeServicoOnline pagamentoDeServicoOnline) {
		this.pagamentoDeServicoOnline = pagamentoDeServicoOnline;
	}
	
	public void processoDeContrato(Contrato contrato, int meses) {
		double cotaBasica = contrato.getValorTotal() / meses;
		
		for(int i = 1; i <= meses; i++) {
			LocalDate dataDeVencimento = contrato.getData().plusMonths(i);
			
			double interesse = pagamentoDeServicoOnline.interesse(cotaBasica, i);
			double taxa = pagamentoDeServicoOnline.pagamentoTaxa(cotaBasica + interesse);
		
			double cota = cotaBasica + interesse + taxa;
			
			contrato.getParcelamentos().add(new Parcelamento(dataDeVencimento, cota));
			
		
		}
	}
	
	
}

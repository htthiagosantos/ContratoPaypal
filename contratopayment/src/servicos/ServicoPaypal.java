package servicos;

import interfaces.PagamentoDeServicoOnline;

public class ServicoPaypal implements PagamentoDeServicoOnline{

	@Override
	public double pagamentoTaxa(double quantidade) {
		return quantidade * 0.02;
	}

	@Override
	public double interesse(double quantidade, int meses) {
		return quantidade * 0.01 * meses;
	}

	
}

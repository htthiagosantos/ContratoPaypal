package interfaces;

public interface PagamentoDeServicoOnline {

	double pagamentoTaxa(double quantidade);
	double interesse(double quantidade, int meses);
}

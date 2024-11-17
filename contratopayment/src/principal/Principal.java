package principal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entidades.Contrato;
import entidades.Parcelamento;
import servicos.ContratoDeServico;
import servicos.ServicoPaypal;

public class Principal {
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Entre com os dados do contrato:");
		
		System.out.print("Numero: ");
		int numero = sc.nextInt();
		
		System.out.print("Data: (dd/MM/yyyy): ");
		LocalDate data = LocalDate.parse(sc.next(), fmt);
		
		System.out.print("Valor do contrato: ");
		double valorTotal= sc.nextDouble();
		
		Contrato contrato = new Contrato(numero, data, valorTotal);
		
		System.out.print("Entre com o numero de parcelas: ");
		int numeroParcelas = sc.nextInt();
		
		ContratoDeServico contratoDeServico = new ContratoDeServico(new ServicoPaypal());
		
		contratoDeServico.processoDeContrato(contrato, numeroParcelas);
		
		System.out.println("PARCELAS:");
		for(Parcelamento parcelamento : contrato.getParcelamentos()) {
			System.out.println(parcelamento);
		}
		
		
		
		sc.close();
	}
}

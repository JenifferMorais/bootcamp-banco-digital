package br.edu.ifg.bancoDigital;

import java.util.Scanner;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContaCorrente extends Conta {
	private static final int AGENCIA_PADRAO = 2;

	private double credito;
	private double maximoLimite;
	private double limite;

	public ContaCorrente(Cliente cliente) {
		super(cliente);
		super.agencia = AGENCIA_PADRAO;
		credito = 500;
		limite = 500;
		maximoLimite = 500;
	}

	public void diminuirLimite(double novoCredito) {
		if (novoCredito < 100) {
			System.out.println("Limite não ajustado, minimo é 100 reais");
		} else {
			this.limite = novoCredito;
			System.out.println("Seu limite foi ajustado, agora é :" + limite);
		}
	}

	public void aumentarLimite(double novoCredito) {
		if (novoCredito > maximoLimite) {
			System.out.println("Limite não ajustado, pois é maior que o credito da conta!");
			System.out.println("O valor de crédito da sua conta é: " + maximoLimite);
			System.out.println("Solicite aumento de crédito, caso necessario");
		} else {
			this.limite = novoCredito;
			System.out.println("Seu limite foi ajustado, agora é:" + limite);
		}
	}

	public void aumentoCredito(Cliente cliente) {
		if (cliente.getRenda() <= 1000) {
			System.out.println("Nao foi possivel aumentar o credito");
		} else if (cliente.getRenda() > 1000 && cliente.getRenda() < 2000) {
			this.credito += 500;
			maximoLimite = this.credito;

		} else if (cliente.getRenda() > 2000 && cliente.getRenda() < 5000) {
			this.credito += 1000;
			maximoLimite = this.credito;
			System.out.println("Novo crédito é:" + credito);
		} else if (cliente.getRenda() > 5000 && this.maximoLimite < 10000) {
			this.credito += 1500;
			maximoLimite = this.credito;
			System.out.println("Novo crédito é:" + credito);
		} else {
			System.out.println("Não é possivel aumentar mais o credito");
		}
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("*** Extrato Conta Corrente ***");
		super.imprimirExtrato();
		System.out.println("*** Credito ***");
		System.out.println(String.format("Credito atual: %.2f", this.credito));
		System.out.println(String.format("Credito disponível: %.2f", this.maximoLimite));
	}

	public void operacoes() {
		int i = 0;
		while (i == 0) {
			System.out.println("Operações: \n 1-Sacar \n 2-Depositar \n 3-ImprimirExtrato "
					+ "\n 4-Aumento de credito \n 5-Aumentar limite \n 6-Diminuir limite \n 7-Sair");
			int operacao1 = scanner.nextInt();
			switch (operacao1) {
			case 1:
				System.out.println("Digite o valor que deseja sacar:");
				sacar(scanner.nextDouble());
				break;
			case 2:
				System.out.println("Digite o valor que deseja depositar:");
				depositar(scanner.nextDouble());
				break;
			case 3:
				imprimirExtrato();
				break;
			case 4:
				System.out.println("Digite o valor que deseja depositar:");
				depositar(scanner.nextDouble());
				break;
			case 5:
				System.out.println("Digite o valor que deseja depositar:");
				depositar(scanner.nextDouble());
				break;
			case 6:
				System.out.println("Digite o valor que deseja depositar:");
				depositar(scanner.nextDouble());
				break;
			case 7:
				i++;
				break;
			default:
				break;
			}
		}
	}

}

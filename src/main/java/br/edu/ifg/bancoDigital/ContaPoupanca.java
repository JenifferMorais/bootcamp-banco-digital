package br.edu.ifg.bancoDigital;

public class ContaPoupanca extends Conta {
	private static final int AGENCIA_PADRAO = 1;

	public ContaPoupanca(Cliente cliente) {
		super(cliente);
		super.agencia = AGENCIA_PADRAO;
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("*** Extrato Conta Poupanca ***");
		super.imprimirExtrato();
	}

	public void operacoes() {
		int i = 0;
		while (i == 0) {
			System.out.println("Operações: \n 1-Sacar \n 2-Depositar \n 3-ImprimirExtrato \n 4-Sair");
			int operacao1 = scanner.nextInt();
			switch (operacao1) {
			case 1:
				System.out.println("Digite o valor que deseja sacar:");
				sacar(scanner.nextDouble());
				break;
			case 2:
				System.out.println("Digite o valor que deseja depositar:");
				depositar(scanner.nextDouble());
				imprimirExtrato();
				break;
			case 3:
				imprimirExtrato();
				break;
			case 4:
				i++;
				break;
			default:
				break;
			}
		}

	}

}

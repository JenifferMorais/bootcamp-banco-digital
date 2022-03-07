package br.edu.ifg.bancoDigital;



import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContaCorrente extends Conta {
	private static final int AGENCIA_PADRAO = 2;

	
	private double maximoLimite;
	private double limite;

	public ContaCorrente(Cliente cliente) {
		super(cliente);
		super.agencia = AGENCIA_PADRAO;
		limite = 500;
		maximoLimite = 500;
	}


	public void ajustarLimite(double novoCredito) {
		if (novoCredito < 100) {
			System.out.println("Limite não ajustado, minimo é 100 reais");
		} else if (novoCredito > maximoLimite) {
			System.out.println("Limite não ajustado, pois é maior que o credito da conta!");
			System.out.println("O valor maximo do limite de crédito é: " + maximoLimite);
		
		} else {
			this.limite = novoCredito;
			System.out.println("Seu limite foi ajustado, agora é: " + limite);
		}
	}

	public void aumentoCredito(Cliente cliente) {
		if (cliente.getRenda() <= 1000) {
			System.out.println("Nao foi possivel aumentar o credito");
		} else if (cliente.getRenda() > 1000 && cliente.getRenda() <= 2000&& this.maximoLimite<1500) {
			maximoLimite+= 500;
			System.out.println("Novo limite maximo de crédito é: " + maximoLimite);
			System.out.println("Para aumentar o credito atual, ajuste o limite");

		} else if (cliente.getRenda() > 2000 && cliente.getRenda() <= 5000 && this.maximoLimite<3000) {
			maximoLimite+= 1000;
			System.out.println("Novo limite maximo de crédito é: " + maximoLimite);
			System.out.println("Para aumentar o credito atual, ajuste o limite");
		} else if (cliente.getRenda() > 5000 && this.maximoLimite <= 10000) {
			maximoLimite+= 1500;
			System.out.println("Novo limite maximo de crédito é: " + maximoLimite);
			System.out.println("Para aumentar o credito atual, ajuste o limite");

		} else {
			System.out.println("Não é possivel aumentar mais o credito");
		}
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("*** Extrato Conta Corrente ***");
		super.imprimirExtrato();
		System.out.println("*** Credito ***");
		System.out.println(String.format("Credito atual: %.2f", this.limite));
		System.out.println(String.format("Credito disponível: %.2f", this.maximoLimite));
	}

	public void operacoes() {
		int i = 0;
		while (i == 0) {
			System.out.println("Operações: \n 1-Sacar \n 2-Depositar \n 3-Imprimir extrato "
					+ "\n 4-Solicitar aumento de limite \n 5-Ajustar limite\n 6-Sair");
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
				aumentoCredito(getCliente());
				break;
			case 5:
				System.out.println("Digite o novo limite que deseja ter:");
				ajustarLimite(scanner.nextDouble());
				break;
			case 6:
				i++;
				break;
			default:
				break;
			}
		}
	}

}

package br.edu.ifg.bancoDigital;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BancoDigitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(BancoDigitalApplication.class, args);
		Scanner scanner = new Scanner(System.in);

		int i = 0;
		Cliente cliente = new Cliente();
		
		System.out.println("BEM VINDO AO SEU BANCO! \n Precisamos que informe alguns dados: ");
		System.out.println("Digite seu nome: ");
		cliente.setNome(scanner.next());
		System.out.println("Digite seu CPF: ");
		cliente.setCpf(scanner.next());
		System.out.println("Digite sua renda: ");
		cliente.setRenda(scanner.nextDouble());

		System.out.println("Agora digite o número correspondente a operação desejada:");
		System.out.println();
		
		while (i == 0) {
			System.out.println("\n Operações: \n 1-Conta Corrente \n 2-Conta Poupanca \n 3-Sair");
			int operacao = scanner.nextInt();
		
			switch (operacao) {

			case 1:
				Conta contaCorrente = new ContaCorrente(cliente);
				contaCorrente.operacoes();
				
				break;
			case 2:
				Conta contaPoupanca = new ContaPoupanca(cliente);
				contaPoupanca.operacoes();

				break;
			case 3:
				System.out.println("Finalizando Operação!");
				System.out.println("...");
				i++;
				break;
			default:
				System.out.println("Numero não reconhecido!");
				break;
			}

		}
		System.out.println("Operação finalizada \n Volte sempre!");

	}

}

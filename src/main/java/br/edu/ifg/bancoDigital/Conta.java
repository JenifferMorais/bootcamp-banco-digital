package br.edu.ifg.bancoDigital;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public abstract class Conta implements Iconta {
	Scanner scanner = new Scanner(System.in);
	private static int SEQUENCIAL = 1;
	
	protected int agencia;
	protected int numero;
	protected double saldo;
	private Cliente cliente;
	private String dataAtual;
	
	Date data = new Date();
	DateFormat dfs = DateFormat.getDateInstance(DateFormat.LONG);
	
	
	public Conta(Cliente cliente) {
		
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		this.dataAtual= String.valueOf(dfs.format(data));
	}
	
	@Override
	public void sacar(double valor) {
		if(valor>saldo) {
			System.out.println("Valor insuficiente na conta!");
		}else {
			saldo-= valor;
		}
			
	}

	@Override
	public void depositar(double valor) {
		saldo+= valor;
	}

	@Override
	public void transferir(double valor, Conta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}
	
	
	@Override
	public void imprimirExtrato() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("CPF: %s", this.cliente.getCpf()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
		System.out.println(String.format("Data que foi criada: %s", this.dataAtual));
		
	}

	protected abstract void operacoes();
	
	
}

package model.entities;

import model.Exceptions.BusinessException;

public class Conta {
	private Integer numero;
	private String cliente;
	private double saldo;
	private double limiteSaque;
	
	
	public Conta(Integer numero, String cliente, double saldo, double limiteSaque) {
		this.numero = numero;
		this.cliente = cliente;
		this.saldo = saldo;
		this.limiteSaque = limiteSaque;
	}
	
	public Conta() {
		
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public double getSaldo() {
		return saldo;
	}

	public double getLimiteSaque() {
		return limiteSaque;
	}

	public void deposito(double quantia) {
		saldo+=quantia;
	}
	
	public void saque(double quantia) {
		validateSaque(quantia);
		saldo-=quantia;
	}
	private void validateSaque (double quantia) {
	if(quantia>getLimiteSaque()) {
		throw new BusinessException ("Erro de saque: A quantia excede o limite de saque");
		}
	if (quantia>getSaldo()) {
		throw new BusinessException ("Erro de saque: A quantia excede o saldo"); 
	}
	}
}


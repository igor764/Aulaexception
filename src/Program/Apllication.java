package Program;

import java.util.Scanner;
import model.Exceptions.BusinessException;
import model.entities.Conta;

public class Apllication {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Entre com os dados da conta: ");
		System.out.print("Numero: ");
		int numero = entrada.nextInt();
		System.out.print("Nome cliente: ");
		entrada.nextLine();
		String nomecliente = entrada.nextLine();
		System.out.print("Saldo inicial: ");
		double saldoinicial = entrada.nextDouble();
		System.out.println("Limite de saque: ");
		double limitesaque = entrada.nextDouble();
		
		Conta acc = new Conta(numero, nomecliente, saldoinicial, limitesaque);
		
		System.out.println();
		System.out.println("Entre com a quantia que quer sacar: ");
		double saque = entrada.nextDouble();
		
		try {
			acc.saque(saque);
			System.out.printf("Novo saldo: %.2f%n ", acc.getSaldo());
			}
		catch (BusinessException e ) {
			System.out.println(e.getMessage());
			}
		
		
		entrada.close();
	}
}

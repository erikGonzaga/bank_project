package br.com.gonzaga.banksystem;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankSystemStartApplication {

	public static void main(String[] args) {
		int option = 0;

		while (option == 0){
			option = showAndGetMenuOption();
			if (option == 0) {
				System.out.println("Opção Inválida: Insira um numero de 1 a 9");
			}

			switch (option){
				case 1:
					System.out.println("Criar Conta Bancaria - em Construção");
					break;
				case 2:
					System.out.println("Depositar - em Construção");
					break;
				case 3:
					System.out.println("Sacar - em Construção");
					break;
				case 4:
					System.out.println("Transferir - em Construção");
					break;
				case 5:
					System.out.println("Saldo - em Construção");
					break;
				case 6:
					System.out.println("Extrato - em Construção");
					break;
				case 7:
					System.out.println("Ativar Conta - em Construção");
					break;
				case 8:
					System.out.println("Desativar Conta - em Construção");
					break;
				case 9:
					System.out.println("Volte Sempre que Puder");
					break;
			}
		}
	}

	private static int showAndGetMenuOption() {
		System.out.println
				("----------------------------------------------------------------\n" +
						"\n" +
						"BANK SYSTEM MENU \n" +
						"----------------------------------------------------------------\n" +
						"----------------------------------------------------------------");
		System.out.println
				("Selecione uma Opção:\n" +
						"\n" +
						"01 - Criar Conta Bancaria\n" +
						"02 - Depositar\n" +
						"03 - Sacar\n" +
						"04 - Transferir\n" +
						"05 - Saldo\n" +
						"06 - Extrato\n" +
						"07 - Ativar Conta\n" +
						"08 - Desativar Conta\n" +
						"09 - Sair" +
						" \n" +
						"v --------------------------------------------------------");

		try {
			int opt = new Scanner(System.in).nextInt();
			return opt > 0 && opt <= 9 ? opt : 0;

		} catch (InputMismatchException e){
			return 0;
		}
	}
}

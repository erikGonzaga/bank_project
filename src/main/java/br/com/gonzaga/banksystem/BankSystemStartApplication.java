package br.com.gonzaga.banksystem;

import services.AddressService;
import services.impl.AddressServiceImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankSystemStartApplication {

	public static void main(String[] args) {
		int option = 0;							// <- Variável de inicialização

		while (option == 0){
			option = showAndGetMenuOption();	/* <- Enquanto for zero, a opção será inválida,
												logo abaixo no try, catch, numeros inseridos fora do intervalo,
												1 a 9 retornaram 0, o que gera opção inválida. */
			if (option == 0) {
				System.out.println("Opção Inválida: Insira um numero de 1 a 9");
			}

			// ʋ Desenvolvimento do Menu:

			switch (option){
				case 1:
					// Implementação de Serviço de Captura de Endereço
					AddressService addressService = new AddressServiceImpl();
					System.out.println("Informe seu Endereço: \n" +
					"Rua Exemplo, 123, Cidade, UF, CEP, Complemento");
					String address = new Scanner(System.in).nextLine();

					boolean result = addressService.isAddressValid(address);
					if (!result) {
						System.out.println("Endereço Inválido");
						return;
					}

					addressService.createAddress(address);

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

	// ʋ Criando o Menu inicial.
	private static int showAndGetMenuOption() {
		System.out.println 	("----------------------------------------------------------------\n" +
							"\n" +
							"BANK SYSTEM MENU \n" +
							"----------------------------------------------------------------\n" +
							"----------------------------------------------------------------");
		System.out.println ("Selecione uma Opção:\n" +
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
							" ʋ --------------------------------------------------------------");

		// Capturando Exception caso haja inserção de letras.
		try {
			int opt = new Scanner(System.in).nextInt();  	// <- Inicio da Operação através do Scanner.

			/* ʋ Caso a inserção esteja entre o intervalo, retorne opt (o valor da inserção),
			caso contrario retorne 0 */
			return opt > 0 && opt <= 9 ? opt : 0;

			// ʋ Retorna 0, caso valores sejam diferentes aos do Intervalo.
		} catch (InputMismatchException e){
			return 0;
		}
	}
}

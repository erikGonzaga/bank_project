package exceptions;

public class BankAccountSystemException extends RuntimeException{

    // Criando um construtor (classe publica, nome da classe, parametro)

    public BankAccountSystemException(String errorMessage){
        // Invocando construtor de classe Pai
        super(errorMessage);
    }


}

package services.impl;

import exceptions.BankAccountSystemException;
import repositories.AccessRepository;
import repositories.impl.AccessRepositoryImpl;
import services.AccessService;

public class AccessServiceImpl implements AccessService {

    private AccessRepository repository;

    public AccessServiceImpl(){
        this.repository = new AccessRepositoryImpl();
    }

    @Override
    public void createAccess(String password, Long clientId, Long accountId) {
        // delegar ou bypass
        repository.createPassword(password, clientId, accountId);

    }

    @Override
    public boolean isPasswordRight(String password, Long clientId, Long accountId) {
        String passwordFromDataBase = repository.getPassword(clientId, accountId)
                .orElseThrow(() -> new BankAccountSystemException("Senha do cliente não Cadastrada. Contate o Administrador do Banco"));

        return password.equals(passwordFromDataBase);
    }
}

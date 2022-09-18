package services;

import models.BankAccount;
import models.Client;

import java.util.Optional;

public interface BankAccountService {

    Optional<BankAccount> bankAccountAlreadyExists(Client client);

    BankAccount createBankAccount(BankAccount bankAccount);


}

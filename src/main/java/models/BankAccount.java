/* package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class BankAccount {

    public BankAccount(Long clientId, Integer agency, Double balance, AccountType accountType) {
        this.clientId = clientId;
        this.balance = balance;
        this.accountType = accountType;
        this.accountNumber = clientId + 1000;
        this.agency = ApplicationProperties.AGENCY;
        this.registrationDate = LocalDateTime.now();
    }

    public BankAccount(Long clientId, AccountType accountType) {
        this.clientId = clientId;
        this.accountType = accountType;
        this.accountNumber = clientId + 1000;
        this.agency = ApplicationProperties.AGENCY;
        this.registrationDate = LocalDateTime.now();
    }

    private Long id;

    private Long clientId;

    private Integer agency;

    private Double balance;

    private Long accountNumber;

    private AccountType accountType;

    private LocalDateTime registrationDate;

    private LocalDateTime deactivationDate;
}

 */

package models;

import config.ApplicationProperties;
import enums.AccountType;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount implements Serializable{

    public BankAccount(Long clientId, Double balance, AccountType accountType) {
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
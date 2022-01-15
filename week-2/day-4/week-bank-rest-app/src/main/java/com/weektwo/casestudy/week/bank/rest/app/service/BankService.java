package com.weektwo.casestudy.week.bank.rest.app.service;

import com.weektwo.casestudy.week.bank.rest.app.domain.BankAccount;
import com.weektwo.casestudy.week.bank.rest.app.exception.InvalidAmountException;

import java.util.List;

public interface BankService {
    void createNewAccount(BankAccount ba);

    int updateAccountDetails(BankAccount ba);

    boolean activateAccount(Long acNum);

    boolean deActivateAccount(Long acNum);

    double withdraw1(Long acNum, double amt) throws InvalidAmountException;

    double deposit(Long acNum, double amt) throws InvalidAmountException;

    int transferMoney(Long srcAc, Long dstAc, double amt) throws InvalidAmountException;

    BankAccount findAccountByAcNum(Long acNum);

    List<BankAccount> findAllBankAccounts();

    List<BankAccount> namesStartsWith(String prefix);
}

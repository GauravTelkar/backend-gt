package com.weektwo.casestudy.week.bank.rest.app.service;

import com.weektwo.casestudy.week.bank.rest.app.domain.BankAccount;
import com.weektwo.casestudy.week.bank.rest.app.exception.InvalidAmountException;
import com.weektwo.casestudy.week.bank.rest.app.repository.BankRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


@Transactional(
        isolation = Isolation.READ_UNCOMMITTED,
        rollbackFor = SQLException.class,
        noRollbackFor = InvalidAmountException.class
)

@Service
public class BankServiceImpl implements BankService {
    private final Logger logger = LoggerFactory.getLogger(BankServiceImpl.class);

    @Autowired
    private BankRepository repository;

    @Override
    public void createNewAccount(BankAccount ba) {
        repository.save(ba);
    }

    @Override
    public int updateAccountDetails(BankAccount ba) {
        return 0;
    }

    @Override
    public boolean activateAccount(Long acNum) {
        Optional<BankAccount> op = repository.findById(acNum);
        BankAccount baOld = op.orElseThrow();
        boolean existingStatus = baOld.getStatus();
        boolean newStatus = Boolean.parseBoolean("true");
        BankAccount baNew = new BankAccount();
        baNew.setBalance(baOld.getBalance());
        baNew.setAcCrDt(baOld.getAcCrDt());
        baNew.setStatus(newStatus);
        baNew.setAcHldNm(baOld.getAcHldNm());
        baNew.setAcNum(baOld.getAcNum());

        repository.save(baNew);

        return baNew.getStatus();
    }

    @Override
    public boolean deActivateAccount(Long acNum) {
        Optional<BankAccount> op = repository.findById(acNum);
        BankAccount baOld = op.orElseThrow();
        boolean existingStatus = baOld.getStatus();
        boolean newStatus = Boolean.parseBoolean("false");
        BankAccount baNew = new BankAccount();
        baNew.setBalance(baOld.getBalance());
        baNew.setAcCrDt(baOld.getAcCrDt());
        baNew.setStatus(newStatus);
        baNew.setAcHldNm(baOld.getAcHldNm());
        baNew.setAcNum(baOld.getAcNum());

        repository.save(baNew);

        return baNew.getStatus();
    }


    @Override
    public double withdraw1(Long acNum, double amt) throws InvalidAmountException {
        if (amt <= 0) throw new InvalidAmountException("Amount Should be Non Zero Positive " + amt);
        Optional<BankAccount> op = repository.findById(acNum);

        BankAccount baOld = op.orElseThrow();
        double existingBalance = baOld.getBalance();
        double newBalance = existingBalance - amt;
        BankAccount baNew = new BankAccount();
        baNew.setBalance(newBalance);
        baNew.setAcCrDt(baOld.getAcCrDt());
        baNew.setStatus(baOld.getStatus());
        baNew.setAcHldNm(baOld.getAcHldNm());
        baNew.setAcNum(baOld.getAcNum());

        repository.save(baNew);

        return baNew.getBalance();

    }

    @Override
    public double deposit(Long acNum, double amt) throws InvalidAmountException {
        // just explanation I am using this strategy
        // it can be done in more efficient way

        if (amt <= 0) throw new InvalidAmountException("Amount Should be Non Zero Positive " + amt);

        Optional<BankAccount> op = repository.findById(acNum);

        BankAccount baOld = op.orElseThrow();
        double existingBalance = baOld.getBalance();
        double newBalance = existingBalance + amt;

        BankAccount baNew = new BankAccount();
        baNew.setBalance(newBalance);
        baNew.setAcCrDt(baOld.getAcCrDt());
        baNew.setStatus(baOld.getStatus());
        baNew.setAcHldNm(baOld.getAcHldNm());
        baNew.setAcNum(baOld.getAcNum());

        repository.save(baNew);

        return baNew.getBalance();
    }

    public double transferMoney(Long acNum, Long acNum2, double amt) throws InvalidAmountException {
        if (amt <= 0) throw new InvalidAmountException("Amount Should be Non Zero Positive " + amt);
        Optional<BankAccount> op = repository.findById(acNum);

        BankAccount baOld = op.orElseThrow();
        double existingBalance = baOld.getBalance();
        double newBalance = existingBalance - amt;

        BankAccount baNew = new BankAccount();
        baNew.setBalance(newBalance);
        baNew.setAcCrDt(baOld.getAcCrDt());
        baNew.setStatus(baOld.getStatus());
        baNew.setAcHldNm(baOld.getAcHldNm());
        baNew.setAcNum(baOld.getAcNum());

        repository.save(baNew);

        Optional<BankAccount> op2 = repository.findById(acNum2);
        BankAccount baOld2 = op2.orElseThrow();
        double existingBalance2 = baOld2.getBalance();
        double newBalance2 = existingBalance2 + amt;
        BankAccount baNew2 = new BankAccount();
        baNew2.setBalance(newBalance2);
        baNew2.setAcCrDt(baOld2.getAcCrDt());
        baNew2.setStatus(baOld2.getStatus());
        baNew2.setAcHldNm(baOld2.getAcHldNm());
        baNew2.setAcNum(baOld2.getAcNum());

        repository.save(baNew2);

        return baNew2.getBalance();
    }

  /*   @Override
    public int transferMoney(Long srcAc, Long dstAc, double amt) throws InvalidAmountException {
        if (amt <= 0) throw new InvalidAmountException("Amount Should be Non Zero Positive " + amt);

        Optional<AmountTransferDto> op1 = repository.findById1(srcAc);

        AmountTransferDto baOld = op1.orElseThrow();
        double existingBalance = baOld.getAmt();
        double newBalance = existingBalance - amt;

        AmountTransferDto baNew1 = new AmountTransferDto();
        baNew1.setAmt(newBalance);
        baNew1.setSrcAc(baOld.getSrcAc());



       Optional<AmountTransferDto> op2 = repository.findById2(dstAc);
        AmountTransferDto baOld1 = op2.orElseThrow();
        double existingBalance1 = baOld1.getAmt();
        double newBalance1 = existingBalance1 + amt;

        AmountTransferDto baNew1 = new AmountTransferDto();
        baNew1.setAmt(newBalance1);
        baNew1.setSrcAc(baOld1.getSrcAc());

        return Math.toIntExact(baNew1.getSrcAc());
        return  0;
    }  */

    @Override
    public List<BankAccount> findAccountByAcNum(Long acNum) {

        return repository.findByAcNum(acNum);
    }

    @Override
    public List<BankAccount> findAllBankAccounts() {
        return repository.findAll();
    }

    @Override
    public List<BankAccount> namesStartsWith(String prefix) {
        return repository.findByAcHldNmStartingWith(prefix);
    }
}

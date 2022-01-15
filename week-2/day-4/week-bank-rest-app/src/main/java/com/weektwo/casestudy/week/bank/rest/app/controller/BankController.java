package com.weektwo.casestudy.week.bank.rest.app.controller;

import com.weektwo.casestudy.week.bank.rest.app.domain.BankAccount;
import com.weektwo.casestudy.week.bank.rest.app.dto.AmountTransferDto;
import com.weektwo.casestudy.week.bank.rest.app.dto.AppResponse;
import com.weektwo.casestudy.week.bank.rest.app.exception.InvalidAmountException;
import com.weektwo.casestudy.week.bank.rest.app.repository.BankRepository;
import com.weektwo.casestudy.week.bank.rest.app.service.BankService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RequestMapping("/bank")
@RestController
public class BankController {

    private final Logger logger = LoggerFactory.getLogger(BankController.class);

    @Autowired
    private BankService service;

    @PostMapping // POST -> http://localhost:8080/bank/
    public ResponseEntity<AppResponse<Integer>> createBankAccount(@RequestBody BankAccount ba) {

        logger.info("creating bank account");

        service.createNewAccount(ba);

        var response = new AppResponse<Integer>();
        response.setMsg("account created successfully");
        response.setSts("success");
        response.setBody(0);
        return ResponseEntity.ok(response);
    }

    //completed
    @PutMapping("/withdraw") // PUT -> http://localhost:8080/bank/withdraw
    public ResponseEntity<AppResponse<Double>> withdrawMoney(@RequestBody BankAccount ba) {
        try {
            double amt = service.withdraw1(ba.getAcNum(), ba.getBalance());
            var response = new AppResponse<Double>();
            response.setMsg("money withdrawn successfully");
            response.setSts("success");
            response.setBody(amt);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (InvalidAmountException e) {
            var response = new AppResponse<Double>();
            response.setMsg(e.getMessage());
            response.setSts("fail");
            response.setBody(0.0);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    //Completed
    @PutMapping("/deposit") // PUT -> http://localhost:8080/bank/deposit
    public ResponseEntity<AppResponse<Double>> depositMoney(@RequestBody BankAccount ba) {
        try {
            double amt = service.deposit(ba.getAcNum(), ba.getBalance());
            var response = new AppResponse<Double>();
            response.setMsg("money deposit successfully");
            response.setSts("success");
            response.setBody(amt);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }catch (InvalidAmountException e) {
            var response = new AppResponse<Double>();
            response.setMsg(e.getMessage());
            response.setSts("fail");
            response.setBody(0.0);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/activate")
    public ResponseEntity<AppResponse<Boolean>> activate (@RequestBody BankAccount ba) {
        boolean stat = service.activateAccount(ba.getAcNum());
        var response = new AppResponse<Boolean>();
        response.setMsg("Account Activated");
        response.setSts("success");
        response.setBody(stat);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @PutMapping("/deActivate")
    public ResponseEntity<AppResponse<Boolean>> Deactivate (@RequestBody BankAccount ba) {
        boolean stat = service.deActivateAccount(ba.getAcNum());
        var response = new AppResponse<Boolean>();
        response.setMsg("Account DeActivated");
        response.setSts("success");
        response.setBody(stat);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{prefix}")
    public ResponseEntity<AppResponse<List<BankAccount>>> accountsStartWith(@PathVariable String prefix) {
        var response = new AppResponse<List<BankAccount>>();
        response.setMsg("account list");
        response.setSts("success");
        response.setBody(service.namesStartsWith(prefix));

        return ResponseEntity.ok(response);
    }

    @GetMapping()
    public List<BankAccount> findAllCars() {
        return service.findAllBankAccounts();
    }




}
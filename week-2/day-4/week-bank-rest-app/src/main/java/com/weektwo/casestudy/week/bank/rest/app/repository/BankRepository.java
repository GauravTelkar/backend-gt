package com.weektwo.casestudy.week.bank.rest.app.repository;

import com.weektwo.casestudy.week.bank.rest.app.domain.BankAccount;
import com.weektwo.casestudy.week.bank.rest.app.dto.AmountTransferDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface BankRepository extends JpaRepository<BankAccount,Long> {
    @Modifying

  //  @Query(value = "update bank_account set balance = :bal where ac_num = :acNum", nativeQuery = true)
   // void withdraw(@Param("bal") double bal, @Param("acNum") Long acNum);


    List<BankAccount> findByAcHldNmStartingWith(String prefix);

    List<BankAccount> findByAcNum(Long acNum);

    List<BankAccount> findByStatusTrue();



    //Optional<AmountTransferDto> findById2(Long dstAc);

    @Override
    List<BankAccount> findAll();

    Optional<BankAccount> findById(Long acNum);



}

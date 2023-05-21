package com.paymybuddy.Repository;

import com.paymybuddy.Models.Account;
import com.paymybuddy.Models.Transaction;
import com.paymybuddy.Models.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {



    @Query("SELECT t FROM Transaction t WHERE t.account.id = :accountId AND t.type = :type")
    List<Transaction> findAllByAccountIdAndType(@Param("account") Account accountId, @Param("type") TransactionType type);
}


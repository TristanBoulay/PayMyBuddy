package com.paymybuddy.Repository;

import com.paymybuddy.Models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findAllByAccountIdOrderByCreatedAtDesc(Long AccountId);
}


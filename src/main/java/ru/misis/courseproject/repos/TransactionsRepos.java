package ru.misis.courseproject.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.misis.courseproject.entities.Transaction;

public interface TransactionsRepos extends JpaRepository<Transaction,String> {
    Transaction findTransactionByTransactionId(Long id);
}
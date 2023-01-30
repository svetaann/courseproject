package ru.misis.courseproject.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.misis.courseproject.entities.TransactionType;

public interface TransactionTypeRepos extends JpaRepository<TransactionType,String> {
    TransactionType findTransactionTypeByTypeId(Long id);
}

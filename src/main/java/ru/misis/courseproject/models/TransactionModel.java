package ru.misis.courseproject.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import ru.misis.courseproject.repos.TransactionsRepos;

@NoArgsConstructor
public class TransactionModel {
    @Autowired
    TransactionsRepos transactionsRepos;
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String type;
    @Getter
    @Setter
    private Long mcc;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private Long sum;

}

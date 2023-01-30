package ru.misis.courseproject.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import ru.misis.courseproject.repos.TransactionsRepos;

@NoArgsConstructor
public class StatisticsModel {
    @Autowired
    TransactionsRepos transactionsRepos;

    @Getter
    @Setter
    private String type;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private Long number;
    @Getter
    @Setter
    private Long amount;
    @Getter
    @Setter
    private Long dispersion;
}

package ru.misis.courseproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.misis.courseproject.entities.Transaction;
import ru.misis.courseproject.models.TransactionModel;
import ru.misis.courseproject.repos.TransactionsRepos;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {
    @Autowired
    TransactionsRepos transactionsRepos;

    public TransactionModel toModel(Transaction transaction) {
        TransactionModel transactionModel = new TransactionModel();
        transactionModel.setId(transaction.getTransactionId());
        transactionModel.setSum(transaction.getSum());
        transactionModel.setType(transaction.getTypeId().getTypeName());
        transactionModel.setDescription(transaction.getMCC().getDescription());
        transactionModel.setMcc(transaction.getMCC().getMCC());
        return transactionModel;
    }

    public List<TransactionModel> findAll() {
        List<TransactionModel> list = new ArrayList<>();
        for (Transaction tr : transactionsRepos.findAll()) {
            list.add(toModel(tr));
        }
        return list;
    }


}

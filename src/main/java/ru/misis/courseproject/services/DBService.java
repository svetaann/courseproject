package ru.misis.courseproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.misis.courseproject.models.StatisticsModel;
import ru.misis.courseproject.repos.TransactionsRepos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DBService {
    @Autowired
    TransactionsRepos transactionsRepos;

    public void deleteAllTrans(java.sql.Connection connection) {
        String query = "DELETE FROM transaction";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<StatisticsModel> getTrans(java.sql.Connection connection) {
        List<StatisticsModel> statisticsModels = new ArrayList<>();

        String query = "Select concat(tr.trans_id,' ',tr.mc_code) as c1, \n" +
                "concat(tt.type_name,'(',m.description,')') as c2,\n" +
                "count(tr.transaction_id) as \"count\", sum(tr.sum), var_pop(tr.sum)\n" +
                "from transaction as tr join mccode as m on tr.mc_code = m.mcc\n" +
                "join transaction_type as tt on tr.trans_id = tt.type_id\n" +
                "where tr.trans_id = 1 group by c1,c2 having count(tr.transaction_id) > 10";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            try (ResultSet result = statement.executeQuery()) {
                while (result.next()) {
                    StatisticsModel statisticsModel = new StatisticsModel();
                    StringBuilder str = new StringBuilder();
                    statisticsModel.setType(result.getString("c1"));
                    statisticsModel.setDescription(result.getString("c2"));
                    statisticsModel.setNumber(result.getLong("count"));
                    statisticsModel.setAmount(result.getLong("sum"));
                    statisticsModel.setDispersion(result.getLong("var_pop"));
                    statisticsModels.add(statisticsModel);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return statisticsModels;
    }
}
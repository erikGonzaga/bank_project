package repositories.impl;

import lombok.SneakyThrows;
import models.Client;
import repositories.ClientRepository;
import utils.DateUtil;

import java.sql.*;
import java.time.LocalDate;

import static config.DataBaseConfig.getConnection;

public class ClientRepositoryImpl implements ClientRepository {

    @Override
    @SneakyThrows
    public Client createClient(Client client) {
        Connection connection = getConnection();
        PreparedStatement stmt = connection.prepareStatement(INSERT_CLIENT_SQL);

        stmt.setString(1, client.getName());
        stmt.setDate(2, DateUtil.localDatetoDate(client.getBirthdate()));
        stmt.setString(3, client.getPhone());
        stmt.setString(4, client.getEmail());
        stmt.setString(5, client.getDocument());
        stmt.setLong(6,client.getAddressId());

        return client;
    }

    private long getClientId() {
        long clientId = 0;

        try{
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(NEXT_CLIENT_ID_SQL);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                long nextId = resultSet.getLong("AUTO_INCREMENT");
                clientId = nextId - 1;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientId;
    }
}

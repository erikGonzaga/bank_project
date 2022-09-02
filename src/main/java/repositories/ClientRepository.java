package repositories;

import models.Client;

public interface ClientRepository {

    String INSERT_CLIENT_SQL = "INSERT INTO CLIENT (name, birthdate, phone, email, document, address_id) \n " +
            "VALUES(?,?,?,?,?,?)";
    String NEXT_CLIENT_ID_SQL = "SELECT AUTO_INCREMENT FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = DB_BANK_SYSTEM'AND TABLE NAME = client'";
    Client createClient(Client client);
}

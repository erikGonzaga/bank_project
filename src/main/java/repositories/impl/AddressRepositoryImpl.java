package repositories.impl;

import static config.DataBaseConfig.getConnection;                      // import Estático (Static)

import models.Address;
import repositories.AddressRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressRepositoryImpl implements AddressRepository {


    @Override
    public Address createAddress(Address address) {

        try {
            Connection connection = getConnection(); // <- Obtendo Connection através getConnection
            // importando de um método Static - (Conexão com o Banco)

            PreparedStatement stmt = connection.prepareStatement(INSERT_ADDRESS_SQL);   // <- Objeto que Executa as QUERIES no Banco

            stmt.setString(1, address.getCity());                            // <- Replace com ? da Query
            stmt.setString(2, address.getState());
            stmt.setString(3, address.getAddress());
            stmt.setString(4, address.getHouseNumber());
            stmt.setInt(5, address.getCep());
            stmt.setString(6, address.getSecondAddress());
            stmt.executeUpdate();

            long id = getAddressId();

            address.setId(id);

            return address;

        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    private long getAddressId() {
        long addressId = 0;

        try{
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(NEXT_ADDRESS_ID_SQL);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                long nextId = resultSet.getLong("AUTO_INCREMENT");
                addressId = nextId - 1;
            }

    } catch (SQLException e) {
            e.printStackTrace();
        }
        return addressId;
    }
}

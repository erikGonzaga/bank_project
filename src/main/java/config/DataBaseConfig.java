package config;

import lombok.SneakyThrows;
import utils.AplicationProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Objects;

/* Singleton - (Design Pattern)
Disponiliza a Referencia do Objeto pela complicação inteira.*/

public class DataBaseConfig {

    private static Connection connection; // Variavel de Classe que representa coneção com o DB

    @SneakyThrows
    public static Connection getConnection() {
        if (Objects.nonNull(connection) && !connection.isClosed()) {
            return connection;
        }

        String user = AplicationProperties.DB_USERNAME;
        String pass = AplicationProperties.DB_PASSWORD;
        String url = AplicationProperties.DB_CONNECTION;

        connection = DriverManager.getConnection(url, user, pass);

        return connection;
    }
}

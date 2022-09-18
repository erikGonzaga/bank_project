package config;

import lombok.SneakyThrows;

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

        String user = ApplicationProperties.DB_USERNAME;
        String pass = ApplicationProperties.DB_PASSWORD;
        String url = ApplicationProperties.DB_CONNECTION;

        connection = DriverManager.getConnection(url, user, pass);

        return connection;
    }
}

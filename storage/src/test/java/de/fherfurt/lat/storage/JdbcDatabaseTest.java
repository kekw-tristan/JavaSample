package de.fherfurt.lat.storage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class JdbcDatabaseTest {
    //@Test
    public void testMariadb() {
    }

    private String buildUrl(String connectorName, String host, int port, String database) {
        return new StringBuilder()
                .append("jdbc:")
                .append(connectorName)
                .append("://")
                .append(host)
                .append(":")
                .append(port)
                .append("/")
                .append(database)
                .toString();
    }
}

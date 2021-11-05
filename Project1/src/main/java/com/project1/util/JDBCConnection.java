package com.project1.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

    private static Connection conn = null;

    public static Connection getConn() {
        if (conn == null) {
            //establish a new connection
            String endpoint = "ahmed2109postgres.cqsltwiqlxmg.ca-central-1.rds.amazonaws.com";

            String url = "jdbc:postgresql://" + endpoint + "/postgres";
            String username = "ahmed";
            String password = "password";

            try {
                conn = DriverManager.getConnection(url, username, password);

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return conn;
    }

    //testing
    public static void main(String[] args) {
        Connection conn1 = getConn();
        System.out.println(conn1);

    }

}

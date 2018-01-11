package com.nissho.vn.util;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Connection;

public class ConnectionUtil {

    private static Connection con;
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/hrsys";
    private static final String PASSWORD = "123456";
    private static final String USER = "root";

    public static Connection loadDriver() {

        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(CONNECTION_STRING, USER, PASSWORD);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return con;
    }

    /*
     * Select Query
     */
    public static ResultSet getResultSet(String query, Connection con) {

        ResultSet rs = null;
        PreparedStatement st;

        try {
            st = con.prepareStatement(query);
            rs = st.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return rs;

    }

    /*
     * Delete/Update query
     */
    public static int runQuery(String query, Connection con) {
        int in = 0;
        PreparedStatement st;
        try {
            st = con.prepareStatement(query);
            in = st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return in;

    }

    public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

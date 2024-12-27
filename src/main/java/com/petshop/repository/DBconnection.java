package com.petshop.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    private static final String URL = "jdbc:postgresql://localhost:5433/petShop";
    private static final String USER = "postgres";
    private static final String PASSWORD = "98680730";


    public static Connection connect(){
        Connection conn = null;
        try{
           conn = DriverManager.getConnection(DBconnection.URL, DBconnection.USER, DBconnection.PASSWORD);
            if (conn != null) {
                System.out.println("Connected to database");
            }
        } catch (SQLException e) {
            System.out.println("Error in connection: " + e.getMessage());
        } catch (Exception e){
            System.out.println("Error: " + e);
        }
        return conn;
    }

}

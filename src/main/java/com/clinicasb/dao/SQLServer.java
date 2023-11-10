package com.clinicasb.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLServer {
    Connection connection = null;
    static SQLServer instance = null;

    public SQLServer() throws Exception {
        String url = "jdbc:sqlserver://192.168.0.29\\SERVILOLCLI20:1433;"
                + "databaseName=LOLCLI9000;"
                + "user=applolcli;"
                + "password=Lolcliapp23;";
                
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        connection = DriverManager.getConnection(url);
    }

    public static SQLServer getInstance() throws Exception {
        if (instance == null) {
            instance = new SQLServer();
        }
        return instance;
    }


    public Connection getConnection() {
        return connection;
    }

    @Override
    protected void finalize() throws Throwable {
        if (!connection.isClosed()) {
            connection.close();
            connection = null;
        }
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }
}

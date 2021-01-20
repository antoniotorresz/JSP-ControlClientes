package com.antonio.ControlClientesJSP.Datos;


import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/controlClientes?useSSL=false&useTimezon=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";

    private static final String JDBC_USER = "root", JDBC_PWD = "root";

    public static DataSource getDataSource() {
        //estamos usando el pool de conexiones con la libreria de apache
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(JDBC_URL);
        dataSource.setUsername(JDBC_USER);
        dataSource.setPassword(JDBC_PWD);
        dataSource.setInitialSize(50); //el numero de conexiones inicial en el pool de conexiones

        return dataSource;
    }

    public static Connection getConnection() throws SQLException {
        //ejecutamos el metodo get data source y al objeto recibido ejecutamos el metodo getConnection, el cual nos devuelve un objeto tipo Conneciton
        return getDataSource().getConnection();
    }

    public static void closeConnection(ResultSet resultset) {
        try {
            resultset.close();
        } catch (Exception e) {
            e.printStackTrace(System.out); //mandamos la excepcion a la salida estandar
        }
    }

    public static void closeConnection(PreparedStatement preparedStatement) {
        try {
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace(System.out);
        }
    }

    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace(System.out);
        }
    }
}

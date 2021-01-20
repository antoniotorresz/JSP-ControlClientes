package com.antonio.ControlClientesJSP.Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Con {
    Connection con;

    public Con()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/controlClientes", "root", "root");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getCon()
    {
        return con;
    }

    public void closeCon(){
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

package com.antonio.ControlClientesJSP.Datos;

import com.antonio.ControlClientesJSP.Dominio.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatosCliente {
    //en esta clase vamos a agregar el codigo de manera directa sin necesidad de agregar una clase interface

    //agregamos las sentencias sql que vamos a usar

    private static final String SQL_SELECT = "select * from cliente";
    private static final String SQL_SELECT_BY_ID = "select * from cliente where id = ?";
    private static final String SQL_INSERT = "insert into cliente(nombre, apellidos, email, telefono, saldo) values (?,?,?,?,?)";
    private static final String SQL_UPDATE = "update cliente set nombre=?, apellidos=?, email=?, telefono=?, saldo=? where id = ?";
    private static final String SQL_DELETE = "delete from cliente where id = ?";
    Con con = new Con();
    Connection connection;
    PreparedStatement statement;
    ResultSet resultSet;

    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();

        try {
            connection = con.getCon();
            statement = connection.prepareStatement(SQL_SELECT);
            resultSet = statement.executeQuery();

            while (resultSet.next())
                clientes.add(new Cliente(resultSet.getInt("id"), resultSet.getString("nombre"), resultSet.getString("apellidos"),
                        resultSet.getString("email"), resultSet.getString("telefono"), resultSet.getDouble("saldo")));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
                con.closeCon();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return clientes;
    }

    public Cliente encontrarPorId(Cliente c) {
        try {
            connection = con.getCon();
            statement = connection.prepareStatement(SQL_SELECT_BY_ID);
            statement.setInt(1, c.getId()); //asignamos el valor del primer parametro ? al valor del id del cliente TIENE QUE SER ANTES DE EJECUTAR EL QUERY

            resultSet = statement.executeQuery();

            //resultSet.first(); //posicionamos el cursor de bd en el registro n (n) para obtener la n ocurrencia en la tabla cliente con el id especificado
            //probablemente la funcion .first() esta pensada para bases de datos mysql, porque en mariadb no funciono este metodo, por lo cual se decidio iterar en el resultset usando el
            //metodo .next()
            while (resultSet.next()) {
                c.setNombre(resultSet.getString("nombre"));
                c.setApellidos(resultSet.getString("apellidos"));
                c.setEmail(resultSet.getString("email"));
                c.setTelefono(resultSet.getString("telefono"));
                c.setSaldo(Double.parseDouble(resultSet.getString("saldo")));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            con.closeCon();
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return c;
    }

    public int insertCliente(Cliente c) {

        int filasAfectadas = 0;
        try {
            connection = con.getCon();
            statement = connection.prepareStatement(SQL_INSERT);

            //agregamos los valores de los parametros
            statement.setString(1, c.getNombre());
            statement.setString(2, c.getApellidos());
            statement.setString(3, c.getEmail());
            statement.setString(4, c.getTelefono());
            statement.setDouble(5, c.getSaldo());

            filasAfectadas = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
                con.closeCon();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return filasAfectadas;
    }

    public int updateCliente(Cliente c) {
        int filas = 0;
        try {
            connection = con.getCon();
            statement = connection.prepareStatement(SQL_UPDATE);
            statement.setString(1, c.getNombre());
            statement.setString(2, c.getApellidos());
            statement.setString(3, c.getEmail());
            statement.setString(4, c.getTelefono());
            statement.setDouble(5, c.getSaldo());
            statement.setInt(6, c.getId());

            filas = statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.closeCon();
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return filas;
    }

    public int deleteCliente(Cliente c) {

        int filasAfectadas = 0;
        try {

            connection = con.getCon();
            statement = connection.prepareStatement(SQL_DELETE);
            statement.setInt(1, c.getId()); //asignamos el valor del primer parametro ? al valor del id del cliente TIENE QUE SER ANTES DE EJECUTAR EL QUERY

            filasAfectadas = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            con.closeCon();
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return filasAfectadas;
    }
}

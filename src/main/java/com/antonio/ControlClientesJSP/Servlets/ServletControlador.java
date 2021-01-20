package com.antonio.ControlClientesJSP.Servlets;

import com.antonio.ControlClientesJSP.Datos.DatosCliente;
import com.antonio.ControlClientesJSP.Dominio.Cliente;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@WebServlet(name = "ServletControlador", value = "/ServletControlador")
public class ServletControlador extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //recuperamos la lista de clientes desde la capa de datos de la aplicacion, esto es lo primero que se va a ejecutar cuando lanzemos la aplicacion desde el index:
        //validamos el tipo de response para el metodo get y asi mandar a una pagina en concreto

        if (request.getParameter("accion") != null) {
            switch (request.getParameter("accion")) {
                case "editar":
                    //obtenemos los datos del cliente desde la capa de datosd en base a su id, despues lo guardamos en una nueva instancia y esa es la que mandamos al jsp para ver los datos
                    Cliente c = new DatosCliente().encontrarPorId(new Cliente(Integer.parseInt(request.getParameter("idCliente"))));
                    //Cliente c = new DatosCliente().findByID(Integer.parseInt(request.getParameter("idCliente")));
                    request.setAttribute("cliente", c);
                    request.getRequestDispatcher("editarcliente.jsp").forward(request, response);
                    break;

                case "eliminar":
                    int registrosEliminados = new DatosCliente().deleteCliente(new Cliente(Integer.parseInt(request.getParameter("idCliente"))));
                    System.out.println("Registros eliminados: " + registrosEliminados);
                    response.sendRedirect("index.jsp");
                    break;
                default:
                    response.sendRedirect("index.jsp");
            }
        } else {
            this.listarClientes(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //aqui vamos a procesar las acciones segun el parametro recibido
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "insertar": //manejamos la paticion tipo insert
                    this.insertarCliente(request, response);
                    response.sendRedirect("index.jsp");
                    break;
                case "editar":
                    int id = Integer.parseInt(request.getParameter("id"));
                    String nombre = request.getParameter("nombre");
                    String apellidos = request.getParameter("apellidos");
                    String email = request.getParameter("email");
                    String telefono = request.getParameter("telefono");
                    double saldo = Double.parseDouble(request.getParameter("saldo"));

                    Cliente c = new Cliente(id, nombre, apellidos, email, telefono, saldo);

                    int filas = new DatosCliente().updateCliente(c); //mandamos una nueva instancia de la clase cliente sin necesidad de reservar memoria
                    System.out.println("filas afectadas:" + filas);
                    response.sendRedirect("index.jsp");
                    break;
                default:
                    response.sendRedirect("index.jsp");
                    break;
            }
        } else {
            response.sendRedirect("index.jsp");
        }
    }

    private void listarClientes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Cliente> clientes = new DatosCliente().listarClientes();
        double suma = 0.0;
        for (Cliente c : clientes) {
            suma += c.getSaldo();
        }

        request.setAttribute("listaClientes", new ArrayList<>(clientes)); //creamos una nueva instancia de la clase arraylist con una copia de la lista de clientes antes de ordenar
        request.setAttribute("cantidadclientes", clientes.size());
        request.setAttribute("sumaSaldos", suma);
        //ordenar la lista usando un comparador de propiedades del objeto
        if (!clientes.isEmpty()) {
            clientes.sort(Comparator.comparingDouble(Cliente::getSaldo));
            request.setAttribute("mayorsueldo", clientes.get(clientes.size() - 1)); //mandamos el ultimo elemento de la lista de clientes ordenados por saldo
        }
        request.getRequestDispatcher("clientes.jsp").forward(request, response);
    }

    private void insertarCliente(HttpServletRequest request, HttpServletResponse response) {
        //recuperamos los valores del formulario
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = Double.parseDouble(request.getParameter("saldo"));

        DatosCliente datosCliente = new DatosCliente();
        int filas = datosCliente.insertCliente(new Cliente(nombre, apellidos, email, telefono, saldo)); //mandamos una nueva instancia de la clase cliente sin necesidad de reservar memoria

    }


}

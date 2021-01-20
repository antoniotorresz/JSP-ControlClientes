<%--
  Created by IntelliJ IDEA.
  User: ant
  Date: 15/01/21
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<fmt:setLocale value="es_MX"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- Incluimos el contenido de la pagina agregar cliente jsp --%>

<html>
<head>
    <meta charset="utf-8">
    <title>Modulo de clientes usando JSP</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">

    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
    <%-- iconos de materialize --%>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

    <script>
        $(document).ready(function () {
            $("#myInput").on("keyup", function () {
                var value = $(this).val().toLowerCase();
                $("#myTable tr").filter(function () {
                    $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                });
            });
        });

        $(document).ready(function () {
            $('.modal').modal();
        });
    </script>
</head>
<body>

<nav>
    <div class="nav-wrapper">
        <a href="index.jsp" class="brand-logo">Administracion de clientes con JSP</a>
    </div>
</nav>


<div class="container">

    <!-- Modal Structure -->
    <div id="demo-modal-fixed-footer" class="modal">
        <form name="finsert" class="col s12" action="ServletControlador?accion=insertar" method="post">
            <div class="modal-content">
                <h4>Registrar cliente nuevo</h4>
                <div class="row">
                    <div class="input-field col s6">
                        <input placeholder="Ingrese su nombre" id="nombre" name="nombre" type="text" class="validate">
                        <label for="nombre">Nombre(s)</label>
                    </div>
                    <div class="input-field col s6">
                        <input placeholder="Ingrese sus apellidos" id="apellidos" name="apellidos" type="text"
                               class="validate">
                        <label for="apellidos">Apellidos</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s6">
                        <input placeholder="Ingrese su correo electrónico" id="email" name="email" type="email"
                               class="validate">
                        <label for="email">Email</label>
                    </div>
                    <div class="input-field col s4">
                        <input placeholder="Ingrese su número de telefono" id="telefono" name="telefono" type="tel"
                               class="validate">
                        <label for="telefono">Telefóno</label>
                    </div>

                    <div class="input-field col s2">
                        <input placeholder="Ingrese el saldo" id="saldo" name="saldo" type="number" class="validate">
                        <label for="telefono">Saldo</label>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button class="btn waves-effect waves-light" type="submit" name="action">Guardar
                    <i class="material-icons right">send</i>
                </button>
            </div>
        </form>
    </div>
</div>
<div class="container">
    <div class="card">
        <div class="row" style="padding: 1%">
            <div class="input-field col s11">
                <input placeholder="Escriba su busqueda" id="myInput" type="text">
                <label for="myInput">Buscar</label>
            </div>
            <div class="input-field col s1">
                <a class="btn-floating btn-large waves-effect waves-light btn modal-trigger"
                   href="#demo-modal-fixed-footer"
                   role="button"><i
                        class="material-icons">add</i></a>
            </div>
        </div>
        <div class="card-content">
            <table class="striped" id="myTable">
                <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Apellidos</th>
                    <th scope="col">Email</th>
                    <th scope="col">Telefono</th>
                    <th scope="col">Saldo</th>
                    <th scope="col">Acción</th>
                </tr>
                </thead>

                <tbody>
                <c:if test="${fn:length(listaClientes) > 0}">
                    <c:forEach var="cliente" items="${listaClientes}">
                        <tr>
                            <th scope="row">${cliente.id}</th>
                            <td>${cliente.nombre}</td>
                            <td>${cliente.apellidos}</td>
                            <td>${cliente.email}</td>
                            <td>${cliente.telefono}</td>
                            <td><fmt:formatNumber value="${cliente.saldo}" type="currency"/></td>
                            <td>
                                <a class="waves-effect waves-light btn"
                                   href="ServletControlador?accion=editar&idCliente=${cliente.id}"><i
                                        class="material-icons">edit</i></a>
                                <a class="waves-effect waves-light btn pink darken-2"
                                   href="ServletControlador?accion=eliminar&idCliente=${cliente.id}"><i
                                        class="material-icons"
                                        onclick="return confirm('¿Seguro que desea eliminar el registro del cliente ${cliente.id}?')">delete_forever</i></a>

                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                </tbody>
            </table>
        </div>
    </div>
    <div class="card">
        <div class="card-content">
            <p>Datos importantes del conjunto de clientes</p>
        </div>
        <div class="card-tabs">
            <ul class="tabs tabs-fixed-width">
                <li class="tab"><a class="active" href="#test4">Cantidad clientes</a></li>
                <li class="tab"><a href="#test5">Saldo total</a></li>
                <li class="tab"><a href="#test6">Cliente con mayor saldo</a></li>
            </ul>
        </div>
        <div class="card-content grey lighten-4">
            <div id="test4">${cantidadclientes}</div>
            <div id="test5"><fmt:formatNumber value="${sumaSaldos}" type="currency"/></div>
            <div id="test6">${mayorsueldo.nombre} ${mayorsueldo.apellidos} tiene un sueldo de ${mayorsueldo.saldo}</div>
        </div>
    </div>
</div>

<footer class="page-footer">
    <div class="container">
        <div class="row">
            <div class="col l6 s12">
                <h5 class="white-text">Registo simple de clientes usando JSP</h5>
                <p class="grey-text text-lighten-4">Aplicacion sencilla solo para la familiarización con la
                    tecnología</p>
            </div>
            <div class="col l4 offset-l2 s12">
                <h5 class="white-text">Acerca del autor</h5>
                <ul>
                    <li><a class="grey-text text-lighten-3" href="https://github.com/antoniotorresz/">Github</li>
                </ul>
            </div>
        </div>
    </div>
    <div class="footer-copyright">
        <div class="container">
            © 2021 Antonio Torres con GNU General Public License. El uso de esta aplicacion está limitado a uso personal
            o de enseñanza, está completamente prohibida su venta.
        </div>
    </div>
</footer>

<script>
    $(document).ready(function () {
        $('.modal').modal();
    })
</script>
</body>
</html>



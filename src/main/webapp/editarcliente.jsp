<%--
  Created by IntelliJ IDEA.
  User: ant
  Date: 18/01/21
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editar cliente ${cliente.id}</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">

    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
    <%-- iconos de materialize --%>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="card">
        <div class="card-content">
            <h4>Editar datos de ${cliente.nombre} (${cliente.id})</h4>
            <form name="formeditcliente" class="col s12 validation" method="post"
                  action="ServletControlador?accion=editar">
                <div class="row">
                    <div class="input-field col s1">
                        <input value="${cliente.id}" id="id" name="id" type="text" class="validate" readonly>
                        <label for="id">Id</label>
                    </div>
                    <div class="input-field col s5">
                        <input placeholder="Ingrese su nombre" id="nombre" name="nombre" type="text" class="validate" value="${cliente.nombre}">
                        <label for="nombre">Nombre(s)</label>
                    </div>
                    <div class="input-field col s6">
                        <input placeholder="Ingrese sus apellidos" id="apellidos" name="apellidos" type="text"
                               class="validate" value="${cliente.apellidos}">
                        <label for="apellidos">Apellidos</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s6">
                        <input placeholder="Ingrese su correo electrónico" id="email" name="email" type="email"
                               class="validate" value="${cliente.email}">
                        <label for="email">Email</label>
                    </div>
                    <div class="input-field col s4">
                        <input placeholder="Ingrese su número de telefono" id="telefono" name="telefono" type="tel"
                               class="validate" value="${cliente.telefono}">
                        <label for="telefono">Telefóno</label>
                    </div>

                    <div class="input-field col s2">
                        <input placeholder="Ingrese el saldo" id="saldo" name="saldo" type="number" class="validate" value="${cliente.saldo}">
                        <label for="telefono">Saldo</label>
                    </div>
                </div>

                <button class="btn waves-effect waves-light" type="submit" name="action">Submit
                    <i class="material-icons right">send</i>
                </button>
            </form>
        </div>
    </div>
</div>

<script>
    $('#formeditcliente').validate({
        rules: {
            id: {
                required: true
            },
            nombre: {
                required: true,
                minLength: 5
            },
            apellidos: {
                required: true,
                minLength: 5
            },
            email: {
                required: true,
                email: true
            },
            telefono: {
                required: true
                minLength: 10
            },
            saldo: {
                required: true
            }
        },
        errorElement: 'div',
        errorPlacement: function (error, element) {
            var placement = $(element).data('error');
            if (placement) {
                $(placement).append(error)
            } else {
                error.insertAfter(element);
            }
        }
    });
</script>

</body>
</html>

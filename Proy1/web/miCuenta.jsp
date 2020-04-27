<%-- 
    Document   : miCuenta
    Created on : 19-abr-2020, 21:17:14
    Author     : Grelvin
--%>

<%@page import="Model.Dao.ServicioCliente"%>
<%@page import="Model.Usuario"%>
<%@page import="Model.Dao.ServicioCuenta"%>
<%@page import="Model.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/cuentas.tld" prefix="cuentas" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Sistema Bancario</title>
        <link href="css/micuenta.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Poppins:400,500&display=swap" rel="stylesheet"/>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/js/all.min.js" charset="utf-8"></script>
    </head>
    <body>
        <jsp:useBean class="Model.Dao.ServicioCuenta" id="sc" scope="session"></jsp:useBean>
        <jsp:useBean class="beans.Clientebean" id="clientelog" scope="session"></jsp:useBean>

        <header>
            <div class="logo-container">
                <img style="width: 40px; height: 55px;" src="css/imagenes/logo2.png" alt="logo"/>
                <h4 class="logo">Stonks BANK</h4>
            </div>
            <nav>
                <ul class="nav-links">
                    <li><a class="nav-link" href="miCuenta.jsp">Mi Cuenta</a></li>
                    <li><a class="nav-link" href="#">Transferencias</a></li>
                    <li><a class="nav-link" href="vincular.jsp">Vincular</a></li>
                    <li><a class="nav-link" href="#">Contáctenos</a></li>
                </ul>
            </nav>
            <div class="registro">
                <form method="GET" action="Logoutservice">
                    <button class="btn btn1">Logout</button>
                </form>
            </div>
        </header>

        <main>
            <section class="tabla-cuenta">  
                <div class="inner-wigth">
                    <h1>Mi <strong>Cuenta</strong></h1>
                ${cuentas:tablaCuentas(sc, clientelog.usuario.id_Cliente )}
                </div>
            </section>
        </main>
    </body>
</html>

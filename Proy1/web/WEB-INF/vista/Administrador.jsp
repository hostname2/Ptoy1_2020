<%-- 
    Document   : Administrador
    Created on : 14/04/2020, 08:39:33 PM
    Author     : sebas
--%>


<%@page import="Model.Cliente"%>
<%@page import="Model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Sistema Bancario</title>
        <link href="css/cliente.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Poppins:400,500&display=swap" rel="stylesheet"/>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js" charset="utf-8"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/js/all.min.js" charset="utf-8"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js" charset="utf-8"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css">
    </head>
    <body>
        <header>
            <div class="logo-container">
                <img style="width: 40px; height: 55px;" src="css/imagenes/logo2.png" alt="logo"/>
                <h4 class="logo">Stonks BANK</h4>
            </div>
            <nav>
                <ul class="nav-links">
                    <li style="padding: 10px;border: 1px solid lightblue;"><a class="nav-link" href="Redireccionadmin1">Iniciar Cliente</a></li>
                    <li style="padding: 10px;border: 1px solid lightblue;"><a  class="nav-link" href="CuentaRegistroadmin">Abrir Cuenta</a></li>
                    <li style="padding: 10px;border: 1px solid lightblue;"><a class="nav-link" href="DepositoserviceCaja">Deposito</a></li>
                    <li style="padding: 10px;border: 1px solid lightblue;"><a class="nav-link" href="RetiroserviceCaja">Retiro</a></li>
                    <li style="padding: 10px;border: 1px solid lightblue;"><a class="nav-link" href="TransferenciaserviceCaja">Transferencia</a></li>
                    <li style="padding: 10px;border: 1px solid lightblue;"><a class="nav-link" href="RegistroserviceCaja">Registrar Cliente</a></li>
                    <li style="padding: 10px;border: 1px solid lightblue;"><a class="nav-link" href="LogoutserviceCaja">Cerrar Cliente</a></li>            

                </ul>
            </nav>
            <div class="registro">
                <form method="GET" action="Logoutservice">
                    <button class="btn btn1">Logout</button>
                </form>
            </div>
        </header>
        <jsp:useBean class="beans.BeanUsuario" id="usuario" scope="session"></jsp:useBean>
        <jsp:useBean class="beans.Clientebean" id="cliente" scope="session"></jsp:useBean>
            <main>
                <div clas="info-cliente">
                    <table class="tablaDatos">
                        <tr>
                            <td class="Col1">Datos Usuario</td>
                        </tr>
                        <tr>
                            <td class="Col1">Id</td>
                            <td class="Col2">${cliente.usuario.id_Cliente}</td>
                    </tr>
                    <tr>
                        <td class="Col1">Nombre</td>
                        <td class="Col2">${cliente.usuario.nombre}</td>
                    </tr>
                    <tr>
                        <td class="Col1">IdUsuario</td>
                        <td class="Col2">${cliente.usuario.id_usuario}</td>
                    </tr>
                    <tr>
                        <td class="Col1">Apellidos</td>
                        <td class="Col2">${cliente.usuario.apellidos}</td>
                    </tr>
                </table>
            </div>
            <%--          <section class="seccion-servicios">
                          <div class="inner-wigth">

                </div>
            </section>--%>
        </main>
    </body>
    <script src="http://code.jquery.com/jquery-1.12.0.min.js"></script>
    <script src="js/main.js"></script>

</html>

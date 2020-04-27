<%-- 
    Document   : vincular
    Created on : 21-abr-2020, 20:34:24
    Author     : Grelvin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Sistema Bancario</title>
        <link href="css/vincular.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Poppins:400,500&display=swap" rel="stylesheet"/>
    </head>
    <body>
        <header>
            <div class="logo-container">
                <img style="width: 40px; height: 55px;" src="css/imagenes/logo2.png" alt="logo"/>
                <h4 class="logo">Stonks BANK</h4>
            </div>
            <nav>
                <ul class="nav-links">
                    <li><a class="nav-link" href="miCuenta.jsp">Mi Cuenta</a></li>
                    <li><a class="nav-link" href="#">Transferencias</a></li>
                    <li><a class="nav-link" href="vincular.jsp">Vinculación</a></li>
                    <li><a class="nav-link" href="informacion.jsp">Información</a></li>
                </ul>
            </nav>
            <div class="registro">
                <form method="GET" action="Logoutservice">
                    <button class="btn btn1">Logout</button>
                </form>
            </div>
        </header>

        <main>
            <section class="seccion-vincular">  
                <div class="inner-wigth">
                    <h1>Vincular<strong> Cuentas</strong></h1>

                    <div class="formulario">
                        <form class="vincular-form" action="vincularService" method="POST">
                            <div class="form-text">
                                <label>Digite el número de la cuenta a vincular: </label>
                                <input type="text" name="num_cuenta" autofocus="autofocus" placeholder="( Digite Nº de cuenta)"/>
                                <button class="btn2" type="submit">Vincular</button>
                            </div>    
                    </div>  
                    </form>
                </div>
                </div>
            </section>
        </main>
    </body>
</html>

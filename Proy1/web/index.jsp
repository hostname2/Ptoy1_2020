<%-- 
    Document   : inicio
    Created on : 10/03/2020, 09:14:17 PM
    Author     : sebas
    Author     : el otro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Sistema Bancario</title>
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Poppins:400,500&display=swap"
              rel="stylesheet"/>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js" charset="utf-8"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/js/all.min.js" charset="utf-8"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js" charset="utf-8"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css">
    </head>
    <body>
        <header>
            <div class="logo-container">
                <img style="width: 25px; height: 25px;" src="css/imagenes/logo.png" alt="logo"/>
                <h4 class="logo">Stonks BANK</h4>
            </div>
            <nav>
                <ul class="nav-links">
                    <li><a class="nav-link" href="#">Servicios</a></li>
                    <li><a class="nav-link" href="#">Contáctenos</a></li>
                </ul>
            </nav>
            <div class="registro">
                 <form method="GET" action="login.jsp">
                <button class="btn btn1">Login</button>
                 </form>
            </div>
        </header>

        <main>
            <section class="seccion-servicios">
                <div class="inner-wigth">
                    <h1>Nuestros <strong>Servicios</strong></h1>
                    <div class="servicios owl-carousel">
                        <div class="servicio">
                            <div class="servicio-icon">
                                <i class="fas fa-piggy-bank"></i>
                            </div>
                            <div class="servicio-name">Vincule su Cuenta</div>
                            <div class="servicio-desc">adfadsfasdfa adfadsfadsf adsfadsfasdfa</div>
                        </div>
                        
                        <div class="servicio">
                            <div class="servicio-icon">
                                <i class="fas fa-user-circle"></i>
                            </div>
                            <div class="servicio-name">Consule su Cuenta y movimientos</div>
                            <div class="servicio-desc">adfadsfasdfa adfadsfadsf adsfadsfasdfa</div>
                        </div>
                        
                        <div class="servicio">
                            <div class="servicio-icon">
                                <i class="fas fa-money-check-alt"></i>
                            </div>
                            <div class="servicio-name">Tranferencia</div>
                            <div class="servicio-desc">adfadsfasdfa adfadsfadsf adsfadsfasdfa</div>
                        </div>
                        
                        <div class="servicio">
                            <div class="servicio-icon">
                                <i class="fas fa-headset"></i>
                            </div>
                            <div class="servicio-name">Soporte</div>
                            <div class="servicio-desc">adfadsfasdfa adfadsfadsf adsfadsfasdfa</div>
                        </div>
                    </div>
                        
                </div>
            </section>
            <script>
                $(".servicios").owlCarousel({
                    margin:20,
                    loop:true,
                    autplay:true,
                    autoplayTimeout:2000,
                    autoplayHoverPause:true,
                    responsive:{
                        0:{
                            items:1
                        },
                        600:{
                            times:2
                        },
                        1000:{
                            items:3
                        }
                    }
                });
            </script>
        </main>
    </body>


</html>


<%-- 
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Incio de Usuario</title>
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="wrapper">
            <header>
                <h1>Banco Sin Dinero Internacional</h1>
            </header>
            <div id="contents">
                <form method="GET" action="ingreso-usuario" class="info">
                    <p>
                        <label>Identificación del usuario:&nbsp;</label>
                        <input type="text" name="id" autofocus="autofocus"
                               placeholder="(digite la identificación)"/>
                    </p>
                    <p>
                        <label>Clave del usuario:&nbsp;</label>
                        <input type="password" name="clave" autofocus="autofocus"
                               placeholder="(digite contraseña)"/>
                    </p>
                    <p style="text-align: right;">
                        <button type="submit">Ingresar</button>
                    </p>
                </form>
            </div>
        </div>
    </body>
</html>
--%>
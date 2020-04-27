<%-- 
    Document   : Cliente
    Created on : 14/04/2020, 08:39:19 PM
    Author     : sebas
--%>

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
                    <li><a class="nav-link" href="miCuenta.jsp">Mi Cuenta</a></li>
                    <li><a class="nav-link" href="#">Transferencias</a></li>
                    <li><a class="nav-link" href="vincular.jsp">Vinculación</a></li>
                </ul>
            </nav>
            <div class="registro">
                <form method="GET" action="login.jsp">
                    <button class="btn btn1">Logout</button>
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
                            <div class="servicio-desc">Aqui puede vincular sus cuenta con cualquiera de sus cuentas favoritas</div>
                        </div>

                        <div class="servicio">
                            <div class="servicio-icon">
                                <i class="fas fa-user-circle"></i>
                            </div>
                            <div class="servicio-name">Cuenta</div>
                            <div class="servicio-desc">Vea la información de sus cuentas</div>
                        </div>

                        <div class="servicio">
                            <div class="servicio-icon">
                                <i class="fas fa-file-invoice-dollar"></i>
                            </div>
                            <div class="servicio-name">Movimientos</div>
                            <div class="servicio-desc">Vea sus movimientos en cada una de sus cuentas</div>
                        </div>

                        <div class="servicio">
                            <div class="servicio-icon">
                                <i class="fas fa-money-check-alt"></i>
                            </div>
                            <div class="servicio-name">Tranferencia</div>
                            <div class="servicio-desc">Haga sus transferencias a sus cuentas</div>
                        </div>

                        <div class="servicio">
                            <div class="servicio-icon">
                                <i class="fas fa-headset"></i>
                            </div>
                            <div class="servicio-name">Soporte</div>
                            <div class="servicio-desc">Siempre disponible pero nunca se arregla nada!</div>
                        </div>

                        <div class="servicio">
                            <div class="servicio-icon">
                                <i class="fas fa-star"></i>
                            </div>
                            <div class="servicio-name">Favoritas</div>
                            <div class="servicio-desc">Vea sus cuentas favoritas</div>
                        </div>
                    </div>

                </div>
            </section>
            <script>
                $(".servicios").owlCarousel({
                    margin: 20,
                    loop: true,
                    autoplay: true,
                    autoplayTimeout: 2000,
                    autoplayHoverPause: true,
                    responsive: {
                        0: {
                            items: 1
                        },
                        600: {
                            times: 2
                        },
                        1000: {
                            items: 3
                        }
                    }
                });
            </script>
        </main>
    </body>


</html>

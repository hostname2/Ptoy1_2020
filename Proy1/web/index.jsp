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

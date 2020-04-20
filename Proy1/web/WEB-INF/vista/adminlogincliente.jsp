<%-- 
    Document   : adminlogincliente
    Created on : 19/04/2020, 11:30:03 AM
    Author     : sebas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Login</title>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
    </head>
    <body>
        <div class="imagen-gb"></div>
        <div class="box">
            <h2>Login</h2>
            <form method ="GET" action ="LoginserviceCaja" >
                <div class="inputBox">
                    <input type="text" name="id" required="" autofocus="">
                    <label>Identificación</label>
                </div>
                <div class="inputBox">
                    <input type="password" name="id-password" required="">
                    <label>Clave de Acceso</label>
                </div>
                <input type="submit" name="" value="Login">
            </form>
        </div>
    </body>
</html>


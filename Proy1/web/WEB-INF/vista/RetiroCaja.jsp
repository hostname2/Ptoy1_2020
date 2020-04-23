<%-- 
    Document   : RetiroCaja
    Created on : 22/04/2020, 09:39:42 PM
    Author     : sebas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<div id="wrapper">
            <header>
                <h1>Retiro Cliente</h1>
            </header>
            <div id="contents">
                <form method ="POST" action="RetiroserviceCaja" class = "info">
                    <table class="tablaDatos">
                        <tr>
                            <td class ="Col1">Numero de cuenta a retirar</td>
                            <td class="Col2">
                                <input type ="text" name ="num_cuenta" autofocus ="autofocus" placeholder="digite numero de cuenta"/>
                            </td>
                            <%--Hacer un menu o combo box de las cuentas que tiene--%>
                            <td class ="Col1">Cantidad a Retirar</td>
                            <td class="Col2">
                                <input type ="text" name ="retiro"  placeholder="digite nombre"/>
                            </td>
                        </tr>
                    </table>
                    <p>
                        <button type="submit">retirar</button>
                    </p>
                </form>
            </div>
        </div>
    </body>
</html>

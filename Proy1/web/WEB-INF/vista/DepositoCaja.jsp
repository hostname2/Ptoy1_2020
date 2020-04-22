<%-- 
    Document   : DepositoCaja
    Created on : 21/04/2020, 04:33:21 PM
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
                <h1>Deposito Cliente</h1>
            </header>
            <div id="contents">
                <form method ="POST" action="DepositoserviceCaja" class = "info">
                    <table class="tablaDatos">
                        <tr>
                            <td class ="Col1">Numero de cuenta</td>
                            <td class="Col2">
                                <input type ="text" name ="num_cuenta" autofocus ="autofocus" placeholder="digite numero de cuenta"/>
                            </td>
                            <td class ="Col1">Cantidad a depositar</td>
                            <td class="Col2">
                                <input type ="text" name ="deposito"  placeholder="digite nombre"/>
                            </td>
                        </tr>
                    </table>
                    <p>
                        <button type="submit">Depositar</button>
                    </p>
                </form>
            </div>
        </div>
    </body>
</html>

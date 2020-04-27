<%-- 
    Document   : DepositoCaja
    Created on : 21/04/2020, 04:33:21 PM
    Author     : sebas
--%>

<%@page import="Model.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cajero</title>
        <link href="css/registroC.css" rel="stylesheet" type="text/css"/>
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
                        </tr>
                        <tr>
                            <td class ="Col1">Cantidad a depositar</td>
                            <td class="Col2">
                                <input type ="text" name ="deposito"  placeholder="digite nombre"/>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <button calss="btn1" type="submit">Depositar</button>
                            </td>
                            <td>
                                <button calss="btn2" formaction="CancelarserviceCaja">Cancelar</button>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </body>
</html>

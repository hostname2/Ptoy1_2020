<%-- 
    Document   : TransferenciaCaja
    Created on : 22/04/2020, 11:11:12 PM
    Author     : sebas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Caja</title>
    </head>
    <body>
        <div id="wrapper">
            <header>
                <h1>Transferencia Cliente</h1>
            </header>
            <div id="contents">
                <form method ="POST" action="TransferenciaserviceCaja" class = "info">
                    <table class="tablaDatos">
                        <tr>
                            <td class ="Col1">Seleccione cuenta</td>
                            <td class="Col2">
                                <input type ="text" name ="num_cuenta1" autofocus ="autofocus" placeholder="digite numero de cuenta"/>
                            </td>
                            <td class ="Col1">Numero de cuenta a transferir</td>
                            <td class="Col2">
                                <input type ="text" name ="num_cuenta2" autofocus ="autofocus" placeholder="digite numero de cuenta"/>
                            </td>                            
                            <%--Hacer un menu o combo box de las cuentas que tiene--%>
                            <td class ="Col1">Cantidad a transferir</td>
                            <td class="Col2">
                                <input type ="text" name ="transferencia"  placeholder="digite nombre"/>
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

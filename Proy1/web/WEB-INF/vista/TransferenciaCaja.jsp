<%-- 
    Document   : TransferenciaCaja
    Created on : 22/04/2020, 11:11:12 PM
    Author     : sebas
--%>

<%@page import="java.util.List"%>
<%@page import="Model.Cuenta"%>
<%@page import="Model.Dao.ServicioCuenta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Caja</title>
        <link href="css/registroC.css" rel="stylesheet" type="text/css"/>
    </head>
    <jsp:useBean class="beans.Clientebean" id="cliente" scope="session"></jsp:useBean>
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
                                    <select  name ="num_cuenta1">
                                    <%
                                        final ServicioCuenta sc = new ServicioCuenta();
                                        if (cliente.getUsuario() != null) {
                                            List<Cuenta> listac = sc.obtenerListaCuentabyiduser(cliente.getUsuario().getId_Cliente());
                                            if (listac != null) {
                                                for (Cuenta c : listac) {
                                                    out.println(String.format("\t\t<option value=\"%s\">%s</option>", c.getNumero_Cuneta(), c.getNumero_Cuneta()));
                                                }
                                            } else {
                                                out.println(String.format("\t\t<option>%s</option>", "No hay cuentas registradas"));
                                            }
                                        }
                                    %>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td class ="Col1">Numero de cuenta a transferir</td>
                            <td class="Col2">
                                <input type ="text" name ="num_cuenta2" autofocus ="autofocus" placeholder="digite numero de cuenta"/>
                            </td> 
                        </tr>
                        <tr>
                            <%--Hacer un menu o combo box de las cuentas que tiene--%>
                            <td class ="Col1">Cantidad a transferir</td>
                            <td class="Col2">
                                <input type ="text" name ="transferencia"  placeholder="cantidad"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <button type="submit">Transferir</button>
                            </td>
                            <td>
                                <button formaction="CancelarserviceCaja">Cancelar</button>
                            </td>
                        </tr>

                    </table>

                </form>
            </div>
        </div>
    </body>
</html>

<%-- 
    Document   : RetiroCaja
    Created on : 22/04/2020, 09:39:42 PM
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
    <body>
        <div id="wrapper">
            <header>
                <h1>Retiro Cliente</h1>
            </header>
            <jsp:useBean class="beans.Clientebean" id="cliente" scope="session"></jsp:useBean>
                <div id="contents">
                    <form method ="POST" action="RetiroserviceCaja" class = "info">
                        <table class="tablaDatos">
                            <tr>
                                <td class ="Col1">Numero de cuenta a retirar</td>
                                <td class="Col2">
                                    <select name ="num_cuenta">
                                    <%
                                        final ServicioCuenta sc = new ServicioCuenta();
                                        List<Cuenta> listac = sc.obtenerListaCuentabyiduser(cliente.getUsuario().getId_Cliente());
                                        if (listac != null) {
                                            for (Cuenta c : listac) {
                                                out.println(String.format("\t\t<option value=\"%s\">%s</option>", c.getNumero_Cuneta(), c.getNumero_Cuneta()));
                                            }
                                        } else {
                                            out.println(String.format("\t\t<option>%s</option>", "No hay cuentas registradas"));
                                        }

                                    %>
                                </select>
                        </tr>
                        <tr>
                            </td>
                            <td class ="Col1">Cantidad a Retirar</td>
                            <td class="Col2">
                                <input type ="text" name ="retiro"  placeholder="Cantidad"/>
                            </td>
                        </tr>
                    </table>
                    <p>
                        <button class ="btn1" type="submit">retirar</button>
                    </p>
                    <p>
                        <button calss="bt2" formaction="CancelarserviceCaja">Cancelar</button>
                    </p>
                </form>
            </div>
        </div>
    </body>
</html>

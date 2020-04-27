<%-- 
    Document   : VentanaCreacuenta
    Created on : 19/04/2020, 10:25:54 PM
    Author     : sebas
--%>

<%@page import="Model.Moneda"%>
<%@page import="java.util.List"%>
<%@page import="Model.Dao.ServicioMoneda"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <jsp:useBean class="beans.Clientebean" id="cliente" scope="session"></jsp:useBean>
        <body>
            <div id="wrapper">
                <header>
                    <h1>Crear Cuenta</h1>
                </header>
                <div id="contents">
                    <form method ="POST" action="CuentaRegistroadmin" class = "info">
                        <table class="tablaDatos">
                            <tr>
                                <td class ="Col1">num_cuenta</td>
                                <td class="Col2">
                                    <input type ="text" name ="num_cuenta" autofocus ="autofocus" placeholder="###-###-###"/>
                                </td>
                            </tr>
                            <tr>
                                <td class ="Col1">tipo_cuenta_id_tipo_cuenta</td>
                                <td>
                                    <select name="tipo_cuenta_id_tipo_cuenta">
                                        <option value = "1">Cuenta de debito</option>
                                        <option value = "2">Cuenta de ahorros</option>
                                    </select>
                                </td>
                            <%--<td class="Col2">
                                <input type ="text" name ="tipo_cuenta_id_tipo_cuenta"  placeholder="digite nombre"/>
                            </td>--%>
                        </tr>
                        <tr>
                            <td class ="Col1">cliente_id_cliente</td>
                            <td class="Col2">
                                <input type ="text" name ="cliente_id_cliente"  placeholder="id cliente "/>
                            </td>
                        </tr>
                        <tr>
                            <td class ="Col1">moneda_nombre</td>
                            <td>
                                <select name ="moneda_nombre" >
                                    <%
                                        final ServicioMoneda sc = new ServicioMoneda();
                                        List<Moneda> listac = sc.obtenerListaMonedas();
                                        if (listac != null) {
                                            for (Moneda m : listac) {
                                                out.println(String.format("\t\t<option value=\"%s\">%s</option>", m.getNombre(), m.getDescripcion()));
                                            }
                                        } else {
                                            out.println(String.format("\t\t<option>%s</option>", "No hay monedas registradas"));
                                        }
                                    %>
                                </select>
                            </td>
                            <%--<td class="Col2">
                                <input type ="text" name ="moneda_nombre"  placeholder="tipo de moneda"/>
                            </td>--%>
                        </tr>
                        <tr>
                            <td class ="Col1">fecha_creacion</td>
                            <td class="Col2">
                                <input type ="date" name ="fecha_creacion"  placeholder=""/>
                            </td>
                        </tr>
                        <tr>
                            <td class ="Col1">limite_transferencia_diaria</td>
                            <td class="Col2">
                                <input type ="text" name ="limite_transferencia_diaria"  placeholder="Limite"/>
                            </td>
                        </tr>
                        <tr>
                            <td class ="Col1">activa</td>
                            <td class="Col2">
                                <input type ="text" name ="activa"  placeholder="1 o 2"/>
                            </td>
                        </tr>
                        <tr>
                            <td class ="Col1">saldo_inicial</td>
                            <td class="Col2">
                                <input type ="text" name ="saldo_inicial"  placeholder="slado inicial"/>
                            </td>
                        </tr>
                        <tr>
                            <td class ="Col1">fecha_ultima_aplicacion</td>
                            <td class="Col2">
                                <input type ="date" name ="fecha_ultima_aplicacion"  placeholder=""/>
                            </td>
                        </tr>
                        <tr>
                            <td class ="Col1">saldo_final</td>
                            <td class="Col2">
                                <input type ="text" name ="saldo_final"  placeholder="saldo final"/>
                            </td>                            
                        </tr>
                        <tr>
                        <td>
                            <button type="submit">Crear Cuenta</button>
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

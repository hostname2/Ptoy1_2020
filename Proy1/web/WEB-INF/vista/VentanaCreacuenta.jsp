<%-- 
    Document   : VentanaCreacuenta
    Created on : 19/04/2020, 10:25:54 PM
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
                <h1>Registro Cliente</h1>
            </header>
            <div id="contents">
                <form method ="POST" action="CuentaRegistroadmin" class = "info">
                    <table class="tablaDatos">
                        <tr>
                            <td class ="Col1">num_cuenta</td>
                            <td class="Col2">
                                <input type ="text" name ="num_cuenta" autofocus ="autofocus" placeholder="digite id de usuario"/>
                            </td>
                            <td class ="Col1">tipo_cuenta_id_tipo_cuenta</td>
                            <td class="Col2">
                                <input type ="text" name ="tipo_cuenta_id_tipo_cuenta"  placeholder="digite nombre"/>
                            </td>
                            <td class ="Col1">cliente_id_cliente</td>
                            <td class="Col2">
                                <input type ="text" name ="cliente_id_cliente"  placeholder="digite apellidos "/>
                            </td>
                            <td class ="Col1">moneda_nombre</td>
                            <td class="Col2">
                                <input type ="text" name ="moneda_nombre"  placeholder="digite clave"/>
                            </td>
                            <td class ="Col1">fecha_creacion</td>
                            <td class="Col2">
                                <input type ="text" name ="fecha_creacion"  placeholder="digite clave"/>
                            </td>
                            <td class ="Col1">limite_transferencia_diaria</td>
                            <td class="Col2">
                                <input type ="text" name ="limite_transferencia_diaria"  placeholder="digite clave"/>
                            </td>
                            <td class ="Col1">activa</td>
                            <td class="Col2">
                                <input type ="text" name ="activa"  placeholder="digite clave"/>
                            </td>
                            <td class ="Col1">saldo_inicial</td>
                            <td class="Col2">
                                <input type ="text" name ="saldo_inicial"  placeholder="digite clave"/>
                            </td>
                            <td class ="Col1">fecha_ultima_aplicacion</td>
                            <td class="Col2">
                                <input type ="text" name ="fecha_ultima_aplicacion"  placeholder="digite clave"/>
                            </td>
                            <td class ="Col1">saldo_final</td>
                            <td class="Col2">
                                <input type ="text" name ="saldo_final"  placeholder="digite clave"/>
                            </td>                            
                        </tr>
                    </table>
                    <p>
                        <button type="submit">Crear Cuenta</button>
                    </p>
                </form>
            </div>
        </div>
    </body>
</html>

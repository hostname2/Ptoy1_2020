<%-- 
    Document   : RegistrarCliente
    Created on : 19/04/2020, 04:11:14 PM
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
                <form method ="POST" action="RegistroserviceCaja" class = "info">
                    <table class="tablaDatos">
                        <tr>
                            <td class ="Col1">Id_usuario</td>
                            <td class="Col2">
                                <input type ="text" name ="id_usuario" autofocus ="autofocus" placeholder="digite id de usuario"/>
                            </td>
                            <td class ="Col1">Rol</td>
                            <td class="Col2">
                                <input type ="text" name ="rol_usuario"  placeholder="digite nombre"/>
                            </td>
                            <td class ="Col1">Identificacion</td>
                            <td class="Col2">
                                <input type ="text" name ="id"  placeholder="digite apellidos "/>
                            </td>
                            <td class ="Col1">Nombre</td>
                            <td class="Col2">
                                <input type ="text" name ="nombre"  placeholder="digite clave"/>
                            </td>
                            <td class ="Col1">Apellidos</td>
                            <td class="Col2">
                                <input type ="text" name ="apellidos"  placeholder="digite clave"/>
                            </td>
                            <td class ="Col1">Telefono</td>
                            <td class="Col2">
                                <input type ="text" name ="telefono"  placeholder="digite clave"/>
                            </td>
                        </tr>
                    </table>
                    <p>
                        <button type="submit">Registrar</button>
                    </p>
                </form>
            </div>
        </div>
    </body>
</html>

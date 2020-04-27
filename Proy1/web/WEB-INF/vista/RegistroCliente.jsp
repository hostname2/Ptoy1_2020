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
        <title>Caja</title>
        <link href="css/registroC.css" rel="stylesheet" type="text/css"/>
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
                        </tr>
                        <tr>
                            <td class ="Col1">Rol</td>
                            <td class="Col2">
                                <input type ="text" name ="rol_usuario"  placeholder="digite nombre"/>
                            </td>
                        </tr>
                        <tr>
                            <td class ="Col1">Identificacion</td>
                            <td class="Col2">
                                <input type ="text" name ="id"  placeholder="digite apellidos "/>
                            </td>
                        </tr>
                        <tr>
                            <td class ="Col1">Nombre</td>
                            <td class="Col2">
                                <input type ="text" name ="nombre"  placeholder="digite clave"/>
                            </td>
                        </tr>
                        <tr>
                            <td class ="Col1">Apellidos</td>
                            <td class="Col2">
                                <input type ="text" name ="apellidos"  placeholder="digite clave"/>
                            </td>
                        </tr>
                        <tr>
                            <td class ="Col1">Telefono</td>
                            <td class="Col2">
                                <input type ="text" name ="telefono"  placeholder="digite clave"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <button class="btn1" type="submit">Registrar</button>
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

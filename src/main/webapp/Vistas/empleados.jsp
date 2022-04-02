<%-- 
    Document   : empleados
    Created on : Mar 30, 2022, 10:50:37 PM
    Author     : Jenny
--%>
<%@page import="config.Conexion"%>
<%@page import="java.sql.*"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="modelo.EmpleadosDAO"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Empleados"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Empleados</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" 
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    </head>
    <body>
        <div class="container">
            <div class="row">
                <a class="btn btn-primary col-4 m-4" href="EmpleadosController?accion=nuevo">Insertar Empleado</a>
                <table class="table table-primary">
                    <thead>
                        <tr>
                            <th>Codigo</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>DocumentoIdentidad</th>
                            <th>Direccion</th>
                            <th>Telefono</th>
                            <th>Foto</th>
                            <th>Modificar</th>
                            <th>Eliminar</th>
                        </tr>
                    </thead>
                <tbody>
                <%
     
                    List<Empleados> resultado=null;
                    EmpleadosDAO empleado = new EmpleadosDAO();
                    resultado = empleado.listarEmpleados();                       
                        for(int i=0; i < resultado.size(); i++){
                            String ruta ="EmpleadosController?accion=modificar&codigo=" + resultado.get(i).getCodigo();
                            String rutaE ="EmpleadosController?accion=eliminar&codigo=" + resultado.get(i).getCodigo();
                 %>
                        <tr>
                            <td><%= resultado.get(i).getCodigo()%></td>
                            <td><%=resultado.get(i).getNombre()%></td>
                            <td><%=resultado.get(i).getApellido()%></td>
                            <td><%=resultado.get(i).getDocumentoIdentidad()%></td>
                            <td><%=resultado.get(i).getDireccion()%></td>
                            <td><%=resultado.get(i).getTelefono()%></td>
                            <td><%=resultado.get(i).getFoto()%></td>
                            <td><a class="text-success" href=<%=ruta%>>X</a></td>
                            <td><a class="text-danger" href=<%=rutaE%>>X</a></td>
                        </tr>
                    </tbody>
                    <%
                        }
                    %>
                </table>
            </div>           
        </div>
    </body>
</html>


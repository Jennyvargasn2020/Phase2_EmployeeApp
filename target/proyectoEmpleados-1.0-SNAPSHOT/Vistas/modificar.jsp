<%-- 
    Document   : modificar
    Created on : Mar 30, 2022, 10:51:22 PM
    Author     : Jenny
--%>
<%@page import="modelo.EmpleadosDAO"%>
<%@page import="modelo.Empleados"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Empleado</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    </head>

    <body>
        
         <%
            String codigo = request.getParameter("codigo"); // Use request para obtener 
            int mid;
            mid =Integer.parseInt(codigo);
            Empleados resultado=null;
            EmpleadosDAO empleadosDao = new EmpleadosDAO(); 
            resultado =  empleadosDao.mostrarEmpleado(mid);
            
            
        %>     
        <div class="container">
            <h1 class="text-center">Modificar Empleado</h1>
            <div class="row">
                <form class="p-5" action="EmpleadosController?accion=actualizar" method="POST">
                    <div class="mb-3">
                      <label for="codigo" class="form-label"></label>
                      <input type="hidden" class="form-control" codigo="codigo" name="codigo"  value=<%=resultado.getCodigo()%>>
                    </div>
                    <div class="mb-3">
                        <label for="nombre" class="form-label">Nombre</label>
                        <input type="text" class="form-control" codigo="nombre" name="nombre" value=<%=resultado.getNombre()%>>
                    </div>
                    <div class="mb-3">
                        <label for="apellido" class="form-label">Apellido</label>
                        <input type="text" class="form-control" codigo="apellido" name="apellido" value=<%=resultado.getApellido()%>>
                    </div>
                    <div class="mb-3">
                        <label for="DocumentoIdentidad" class="form-label">DocumentoIdentidad</label>
                        <input type="text" class="form-control" codigo="documentoIdentidad" name="documentoIdentidad" value=<%=resultado.getDocumentoIdentidad()%>>
                    </div>
                    <div class="mb-3">
                        <label for="Direccion" class="form-label">Direccion</label>
                        <input type="text" class="form-control" codigo="direccion" name="direccion" value=<%=resultado.getDireccion()%>>
                    </div>
                    <div class="mb-3">
                        <label for="telefono" class="form-label">Telefono</label>
                        <input type="text" class="form-control" codigo="telefono" name="telefono" value=<%=resultado.getTelefono()%>>
                    </div>
                    <div class="mb-3">
                        <label for="foto" class="form-label">Foto</label>
                        <input type="text" class="form-control" codigo="foto" name="foto" value=<%=resultado.getFoto()%>>
                    </div>
                    <button type="submit" class="btn btn-primary">Modificar</button>
                </form>
            </div>
        </div>

    </body>
</html>

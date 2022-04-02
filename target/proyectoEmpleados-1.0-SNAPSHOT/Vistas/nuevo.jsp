<%-- 
    Document   : nuevo
    Created on : Mar 30, 2022, 10:51:05 PM
    Author     : Jenny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Empleados</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    </head>
    <body>
        <div class="container">
            <h1 class="text-center">Añadir Empleado</h1>
            <div class="row">
                <form class="p-5" action="EmpleadosController?accion=insert" method="POST">
                        <div class="mb-3">
                          <label for="nombre" class="form-label">Nombre</label>
                          <input type="text" class="form-control" codigo="nombre" name="nombre" aria-describedby="emailHelp">
                        </div>
                        <div class="mb-3">
                          <label for="apellido" class="form-label">Apellido</label>
                          <input type="text" class="form-control" codigo="apellido" name="apellido">
                        </div>
                        <div class="mb-3">
                          <label for="DocumentoIdentidad" class="form-label">DocumentoIdentidad</label>
                          <input type="int" class="form-control" codigo="documentoIdentidad" name="documentoIdentidad">
                        </div>
                        <div class="mb-3">
                          <label for="Direccion" class="form-label">Direccion</label>
                          <input type="text" class="form-control" codigo="direccion" name="direccion">
                        </div>
                        <div class="mb-3">
                          <label for="telefono" class="form-label">Telefono</label>
                          <input type="int" class="form-control" codigo="telefono" name="telefono">
                        </div>
                        <button type="submit" class="btn btn-primary">Añadir</button>
                      </form>
            </div>
        </div>
        
    </body>
</html>

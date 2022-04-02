/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Empleados;
import modelo.EmpleadosDAO;
/**
 *
 * @author Jenny
 */
@WebServlet(name = "EmpleadosController", urlPatterns = {"/EmpleadosController"})
public class EmpleadosController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        EmpleadosDAO empleadosDao = new EmpleadosDAO();
        String accion;
        RequestDispatcher dispactcher = null;
        accion = request.getParameter("accion");
        if (accion == null || accion.isEmpty()) {
            dispactcher = request.getRequestDispatcher("Vistas/empleados.jsp");
        } else if (accion.equals("modificar")) {
            dispactcher = request.getRequestDispatcher("Vistas/modificar.jsp");

        } else if (accion.equals("actualizar")) {
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String documentoIdentidad = request.getParameter("documentoIdentidad");
            String direccion = request.getParameter("direccion");
            String telefono = request.getParameter("telefono");
            String foto = request.getParameter("foto");

            Empleados empleado = new Empleados(codigo, nombre, apellido, documentoIdentidad, direccion, telefono, foto);
            empleadosDao.actualizarEmpleado(empleado);

            dispactcher = request.getRequestDispatcher("Vistas/empleados.jsp");
        } else if (accion.equals("eliminar")) {

            int codigo = Integer.parseInt(request.getParameter("codigo"));
            empleadosDao.eliminarEmpleado(codigo);

            dispactcher = request.getRequestDispatcher("Vistas/empleados.jsp");
        } else if (accion.equals("nuevo")) {
            dispactcher = request.getRequestDispatcher("Vistas/nuevo.jsp");
        } else if (accion.equals("insert")) {
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String documentoIdentidad = request.getParameter("documentoIdentidad");
            String direccion = request.getParameter("direccion");
            String telefono = request.getParameter("telefono");
            String foto = request.getParameter("foto");

            Empleados empleado = new Empleados(0, nombre, apellido, documentoIdentidad, direccion, telefono, foto);
            empleadosDao.insertarEmpleado(empleado);

            dispactcher = request.getRequestDispatcher("Vistas/empleados.jsp");
        } else {
            dispactcher = request.getRequestDispatcher("Vistas/empleados.jsp");
        }
        dispactcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
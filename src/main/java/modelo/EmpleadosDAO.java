/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.io.IOException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.multipart.MultipartFile;
/**
 *
 * @author Jenny
 */
public class EmpleadosDAO {
  Connection conexion;
      public EmpleadosDAO(){
        Conexion con = new Conexion(); 
        conexion = con.getConnection();
   }
   
   public List<Empleados> listarEmpleados(){
           
       PreparedStatement ps;
       ResultSet rs;
       List<Empleados> lista = new ArrayList<>();
       try{
           ps = conexion.prepareStatement("SELECT codigo, nombre, apellido, documentoIdentidad, direccion, telefono, foto FROM empleados");
           rs = ps.executeQuery(); 
           while (rs.next()) {
               int codigo = rs.getInt("codigo");
               String nombre = rs.getString("nombre");
               String apellido = rs.getString("apellido");
               String documentoIdentidad = rs.getString("documentoIdentidad");
               String direccion = rs.getString("direccion");
               String telefono = rs.getString("telefono");
               String foto = rs.getString("foto");
               Empleados empleados = new Empleados(codigo, nombre, apellido, documentoIdentidad, direccion, telefono, foto);
               lista.add(empleados);
           }
           return lista;
       }catch(SQLException e){
           System.out.println(e.toString());
           return null;
       }
       
   }
   
   public Empleados mostrarEmpleado(int _codigo){
       PreparedStatement ps;
       ResultSet rs;
       Empleados empleado = null;
       
       try{
           ps = conexion.prepareStatement("SELECT codigo, nombre, apellido, documentoIdentidad, direccion, telefono, foto FROM empleados WHERE codigo =?");
           ps.setInt(1, _codigo);
           rs = ps.executeQuery();
           
           while(rs.next()){
               int codigo = rs.getInt("codigo");
               String nombre = rs.getString("nombre");
               String apellido = rs.getString("apellido");
               String documentoIdentidad = rs.getString("documentoIdentidad");
               String direccion = rs.getString("direccion");
               String telefono = rs.getString("telefono");
               String foto = rs.getString("foto");
               empleado = new Empleados(codigo, nombre, apellido, documentoIdentidad, direccion, telefono, foto);
           }
           return empleado;
       }catch(SQLException e){
           System.out.println(e.toString());
           return null;
       }
   }
   
   public boolean insertarEmpleado(Empleados empleado){
       PreparedStatement ps;
       try{
           ps = conexion.prepareStatement("INSERT INTO empleados(nombre, apellido,documentoIdentidad, direccion, telefono, foto) VALUES (?,?,?,?,?,?)");
           ps.setString(1,empleado.getNombre());
           ps.setString(2,empleado.getApellido());
           ps.setString(3,empleado.getDocumentoIdentidad());
           ps.setString(4,empleado.getDireccion());
           ps.setString(5,empleado.getTelefono());
           ps.setString(6, empleado.getFoto());
           ps.execute();
           return true;
       }catch(SQLException e){
           System.out.println(e.toString());
           return false;
       }
   }
   
   public boolean actualizarEmpleado(Empleados empleado){
        PreparedStatement ps;
       try{
           ps = conexion.prepareStatement("UPDATE empleados SET nombre=?, apellido=?,"
                   + "documentoIdentidad=?,direccion=?, telefono=?, foto=? WHERE codigo=?");
           ps.setString(1,empleado.getNombre());
           ps.setString(2,empleado.getApellido());
           ps.setString(3,empleado.getDocumentoIdentidad());
           ps.setString(4,empleado.getDireccion());
           ps.setString(5,empleado.getTelefono());
           ps.setString(6,empleado.getFoto());
           ps.setInt(7,empleado.getCodigo());
           ps.execute();
           return true;
       }catch(SQLException e){
           System.out.println(e.toString());
           return false;
       }
   }
   
   public boolean eliminarEmpleado(int _Codigo){
        PreparedStatement ps;
       try{
           ps = conexion.prepareStatement("DELETE FROM empleados WHERE codigo=?");
           ps.setInt(1, _Codigo);
           ps.execute();
           
           return true;
       }catch(SQLException e){
           System.out.println(e.toString());
           return false;
       }
   }

}

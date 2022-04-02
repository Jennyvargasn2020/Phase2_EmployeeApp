/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;
import java.sql.*;
/**
 *
 * @author Jenny
 */
public class Conexion {
   public String driver = "com.mysql.jdbc.Driver";
    public Connection getConnection(){  
        Connection conexion = null;
        try{
            Class.forName(driver);
                conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/empleados",
                        "root","MyNewPass");           
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e.toString());
        }       
        return conexion;
    } 
    public static void main(String[] args) throws SQLException{  
        Connection conexion = null;
        Conexion con = new Conexion();
        conexion = con.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        ps = conexion.prepareStatement("SELECT * FROM empleados");
            rs = ps.executeQuery();
            while(rs.next()){
                int codigo = rs.getInt("codigo");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String documentoIdentidad = rs.getString("documentoidentidad");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                String foto = rs.getString("foto");
            System.out.println(
                    " codigo: " + codigo
                    + " nombre: " + nombre
                    + " apellido: " + apellido
                    + " DocumentoIdentidad: " + documentoIdentidad
                    + " Direccion: " + direccion
                    + " Telefono: " + telefono
                    + " foto: " + foto);
                    
            
    }
    }
}

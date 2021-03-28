/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Marvin
 */
public class ClsConexion {
  private Connection conexion;
  private final String servidor = "jdbc:mysql://localhost/listanombres";
  private final String user = "root";
  private final String password = "";
  
  public void AbreConexion(){
      try{
          Class.forName("com.mysql.jdbc.Driver");
          conexion = (Connection) DriverManager.getConnection(servidor, user, password);
      }catch(SQLException | ClassNotFoundException e){
          System.out.println("Error en la conexion: "+e);
      }//fin try/catch
  }//fin AbreConexion
  
  private void CerrarConexion(){
        try{
            conexion.close();
        }catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
        }//fin try/catch
    }//fin cerrar conexion
   public List<Tabla_BD> nombres(){
       AbreConexion();
       Tabla_BD persona = new Tabla_BD();
       List<Tabla_BD> todos = new ArrayList();
       
       
       try{
           String sql = "SELECT * FROM nombres";
            Statement stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){ //mientras haya un dato siguiente seguira haciendo ciclos
                persona.setNombre(rs.getString("nombres"));
                todos.add(persona);
                persona = new Tabla_BD();
                
            }//fin while
            CerrarConexion();
       }catch(SQLException e){
           System.out.println(e);
       }//fin try/catch
       return todos;
   }
   
}

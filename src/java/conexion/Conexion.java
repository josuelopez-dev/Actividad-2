
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    
    static String bd = "veterinaria";
    static String user = "root";
    static String pass = "root";
    static String url = "jdbc:mysql://localhost:3306/" + bd;
    Connection conn = null;
    
    public Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
            if (conn != null) {
                System.out.println("Sin miedo al éxito! Conexión exitosa!");
            }
        } catch (Exception e) {
            System.out.println("Error de conexión: " + e);
        }
    }
    
     public Connection conectar() {
        return  conn;
    }
    
    public void desconectar() throws Exception{
        conn.close();
    }
    
    
}

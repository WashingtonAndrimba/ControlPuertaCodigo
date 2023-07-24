/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.intsuperior.controlador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import ec.edu.intsuperior.vista.Login;



public class Conexion {
    public static String url = "jdbc:mysql://localhost:3306/usuarioscontrolpuerta";
    public static String bdUser= "root";
    public static String bdPass= "Kuro_Side666";
    public static Connection establecerConexion() {
        Connection connection = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, bdUser, bdPass);
            System.out.println("Conexión establecida con éxito");
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al establecer la conexión: " + e.getMessage());
        }

        return connection;
    }

    public static Conexion getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
public boolean credencialesValidas(String bdUser, String bdPass){
    
try {
    
            Connection connection = DriverManager.getConnection(url, this.bdUser, this.bdPass);
            String sql = "SELECT * FROM usuario WHERE user = 'Juan123' AND password = '12345';";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, bdUser);
            statement.setString(2, bdPass);
            
            
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                // Las credenciales son válidas
                return true;
            }
            
            // Las credenciales son inválidas
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
public boolean credencialesValidasUsuarios(String bdUser, String bdPass){
    
try {
    
            Connection connection = DriverManager.getConnection(url, this.bdUser, this.bdPass);
            String sql = "SELECT * FROM usuario WHERE user = ? AND password = ? ; ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, bdUser);
            statement.setString(2, bdPass);
            
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                // Las credenciales son válidas
                return true;
            }
            
            // Las credenciales son inválidas
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public PreparedStatement prepareStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void closeConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}


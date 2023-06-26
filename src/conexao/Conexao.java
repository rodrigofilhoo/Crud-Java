/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;
import java.sql.*;

/**
 *
 * @author rodrigo
 */
public class Conexao {
    
   public Statement stmt;
   public Connection con;
   public ResultSet rs;
    
    public Connection getConexao(){
        
        try{
            //tenta estabelecer a conexão
            Connection conn;
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/softpay?serverTimezone=UTC",     //linha de conexão
                    "root",    //usuario do banco
                    ""   //senha do banco
            );
            stmt = conn.createStatement();
            return conn;
            
        } catch (SQLException e){
            //se der erro...
            System.out.print("Erro ao se conectar" + e.getMessage());
            return null;
        }
        
    }

    public PreparedStatement prepareStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

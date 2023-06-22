/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author rodrigo
 */
public class Conexao {
    
    public Connection getConexao(){
        
        try{
            //tenta estabelecer a conexão
            
            Connection conn = DriverManager.getConnection(
                   "jdbc:mysql://localhost:3306/softpay?serverTimezone=UTC",     //linha de conexão
                    "root",    //usuario do banco
                    ""   //senha do banco
            );
            return conn;
            
        } catch (Exception e){
            //se der erro...
            System.out.print("Erro ao se conectar" + e.getMessage());
            return null;
        }
        
    }
    
    
}

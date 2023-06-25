/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beans.Usuario;
import conexao.Conexao;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author rodrigo
 */
public class usuarioDAO {
    
    private final Conexao conexao;
    public Connection conn;
    
    
    //contrutor da classe
    
    public usuarioDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void inserir(Usuario usuario){
        String sql = "insert into usuario(nome, email, cpf, senha, tipo) values " + "(?, ? ,?, ?, ?)";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmai());
            stmt.setInt(3, usuario.getCpf());
            stmt.setString(4, usuario.getSenha());
            stmt.setString(5, usuario.getTipo());
            stmt.execute();
            
        } catch (SQLException e){
         JOptionPane.showMessageDialog(null, "Erro ao inserir: " + e.getMessage());           
        }
    }

   public void deletar (Usuario usuario){ 
        String sql = "delete from usuario where id = ?";
               
        try { 
            try (PreparedStatement stmt = this.conn.prepareStatement(sql)) {
                stmt.setInt(1, usuario.getId());
                stmt.execute();
            }
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
        
    }
    public void atualiza (Usuario usuario){ 
        String sql = "UPDATE usuario SET nome = ?, email = ?, cpf = ?, senha = ?" + " WHERE id=?";
               
        try { 
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmai());
            stmt.setInt(3, usuario.getCpf());
            stmt.setString(4, usuario.getSenha());
            stmt.setInt(5, usuario.getId());
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
        
    } 
        
    public ResultSet login (Usuario usuario){                      
            try{
                String sql = "select * from usuario where nome = ? and senha = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, usuario.getNome());
                stmt.setString(2, usuario.getSenha());
                ResultSet rs = stmt.executeQuery();
                return rs;
            } catch (SQLException erro) { 
            JOptionPane.showMessageDialog(null, erro);
            return null;    
        }           
    }
}

    



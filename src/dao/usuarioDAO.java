/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beans.Usuario;
import conexao.Conexao;
import java.sql.*;
import javax.swing.JOptionPane;
import forms.FormLogin;
/**
 *
 * @author rodrigo
 */
public class usuarioDAO {
    
    private Conexao conexao;
    public Connection conn;
    Statement stmt;
    ResultSet rs;
    
    
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
            
        } catch (Exception e){
         JOptionPane.showMessageDialog(null, "Erro ao inserir: " + e.getMessage());           
        }
    }

   public void usuario (Usuario nome, Usuario senha){
        String sql = "select * from usuario where nome = ? and senha = ?";
        
        try{
        PreparedStatement stmt = this.conn.prepareStatement(sql);
        stmt.setString(1, nome.toString());
        stmt.setString(2, senha.toString());
        
        ResultSet rs = stmt.executeQuery();
        Usuario usuario = new Usuario();
        rs.first();
        usuario.setNome(rs.getString(nome.toString()));
        usuario.setSenha(rs.getString(senha.toString()));
 
    } catch (Exception e){
            System.out.println(e.getMessage());
        }
}
}

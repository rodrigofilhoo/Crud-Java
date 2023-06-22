/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beans.Usuario;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
/**
 *
 * @author rodrigo
 */
public class usuarioDAO {
    
    private Conexao conexao;
    private Connection conn;
    
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
            System.out.print("Erro ao inserir: " + e.getMessage());
            
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package softpay;
import conexao.Conexao;
import forms.FormLogin;

/**
 *
 * @author rodrigo
 */
public class SoftPay {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conexao c = new Conexao();
        c.getConexao();
        
        FormLogin fl = new FormLogin();
        fl.setVisible(true);
        fl.setResizable(false);
    }
    
}

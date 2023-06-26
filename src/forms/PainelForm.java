/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forms;

import beans.Usuario;
import dao.usuarioDAO;
import javax.swing.JOptionPane;
import forms.FormLogin;
import forms.FormCadastro;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author 123119730
 */
public class PainelForm extends javax.swing.JFrame {

    /**
     * Creates new form PainelForm
     */
    public PainelForm() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_id = new javax.swing.JTextField();
        txt_nome = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_cpf = new javax.swing.JTextField();
        txt_senha = new javax.swing.JTextField();
        btn_delete = new javax.swing.JButton();
        btn_atualizar = new javax.swing.JButton();
        btn_inserir = new javax.swing.JButton();
        btn_entrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_id.setBackground(new java.awt.Color(255, 255, 255));
        txt_id.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_id.setBorder(null);
        getContentPane().add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 240, 250, 30));

        txt_nome.setBackground(new java.awt.Color(255, 255, 255));
        txt_nome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_nome.setBorder(null);
        getContentPane().add(txt_nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 310, 220, 20));

        txt_email.setBackground(new java.awt.Color(255, 255, 255));
        txt_email.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_email.setBorder(null);
        getContentPane().add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 380, 220, 20));

        txt_cpf.setBackground(new java.awt.Color(255, 255, 255));
        txt_cpf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_cpf.setBorder(null);
        getContentPane().add(txt_cpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 450, 230, 20));

        txt_senha.setBackground(new java.awt.Color(255, 255, 255));
        txt_senha.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_senha.setBorder(null);
        getContentPane().add(txt_senha, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 510, 200, 30));

        btn_delete.setBorder(null);
        btn_delete.setContentAreaFilled(false);
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });
        getContentPane().add(btn_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 570, 150, 50));

        btn_atualizar.setBorder(null);
        btn_atualizar.setContentAreaFilled(false);
        btn_atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_atualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 630, 150, 50));

        btn_inserir.setBorder(null);
        btn_inserir.setContentAreaFilled(false);
        getContentPane().add(btn_inserir, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 570, 150, 50));

        btn_entrar.setBackground(new java.awt.Color(255, 255, 255));
        btn_entrar.setForeground(new java.awt.Color(204, 0, 204));
        btn_entrar.setBorder(null);
        btn_entrar.setContentAreaFilled(false);
        btn_entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_entrarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_entrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 630, 150, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/PainelForm.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 810));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        Usuario usuarios = new Usuario();
        usuarios.setId(Integer.parseInt(txt_id.getText()));
        // fazendo a validação dos dados
        if ((txt_id.getText().isEmpty()) ) {
            JOptionPane.showMessageDialog(null, "Insira o Id do usuário para deletar!");
        } else {
            
            // instanciando a classe UsuarioDAO do pacote dao e criando seu objeto dao
            usuarioDAO dao = new usuarioDAO();
            dao.deletar(usuarios);
            JOptionPane.showMessageDialog(null, "Usuário "+txt_id.getText()+" excluido com sucesso! ");
        }
        // apaga os dados preenchidos nos campos de texto
        txt_id.setText("");
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atualizarActionPerformed
        String nome, email, senha;
        int cpf, id;
        nome = (txt_nome.getText());
        email = (txt_email.getText());
        senha = (txt_senha).getText();
        cpf =Integer.parseInt(txt_cpf.getText());
        id = Integer.parseInt(txt_id.getText());
        Usuario usuarios = new Usuario();
        usuarios.setNome(nome);
        usuarios.setEmail(email);
        usuarios.setCpf(cpf);
        usuarios.setSenha(senha);
        usuarios.setId(id);
        // instanciando a classe UsuarioDAO do pacote dao e criando seu objeto dao
        usuarioDAO dao = new usuarioDAO();
        dao.atualiza(usuarios);
        JOptionPane.showMessageDialog(null, "Usuário "+txt_nome.getText()+" atualizado com sucesso! ");
        FormLogin lc = new FormLogin();
        lc.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btn_atualizarActionPerformed

    private void btn_entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_entrarActionPerformed
                JOptionPane.showMessageDialog(null, "Entrando no Sistema");
                HomeForm HF = new HomeForm();
                HF.setVisible(true);
                setVisible(false);
    }//GEN-LAST:event_btn_entrarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PainelForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PainelForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PainelForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PainelForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PainelForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_atualizar;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_entrar;
    private javax.swing.JButton btn_inserir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txt_cpf;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JTextField txt_senha;
    // End of variables declaration//GEN-END:variables
}

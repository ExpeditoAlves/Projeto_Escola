/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import Classes.Funcionario;
import Classes.TextFieldValidator;
import javax.swing.JOptionPane;

/**
 *
 * @author Ditto66
 */
public class Cadastro_Funcionario extends javax.swing.JFrame {

    TextFieldValidator validator = new TextFieldValidator();
    
    public Cadastro_Funcionario() {
        initComponents();
    }
    
    public Cadastro_Funcionario(String nome) {
        initComponents();
        Login.setText(nome);
        
        jLabelMsg.setVisible(false);
        jLabelMsg.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Username = new javax.swing.JTextField();
        Nome = new javax.swing.JTextField();
        Senha = new javax.swing.JPasswordField();
        jLabelMsg = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLLimpar = new javax.swing.JLabel();
        jLCadastrar = new javax.swing.JLabel();
        jLBG = new javax.swing.JLabel();
        Login = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(350, 397));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Username.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        Username.setBorder(null);
        Username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernameActionPerformed(evt);
            }
        });
        Username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                UsernameKeyTyped(evt);
            }
        });
        getContentPane().add(Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 201, 290, -1));

        Nome.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        Nome.setBorder(null);
        Nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomeActionPerformed(evt);
            }
        });
        Nome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NomeKeyTyped(evt);
            }
        });
        getContentPane().add(Nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 128, 290, -1));

        Senha.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        Senha.setBorder(null);
        Senha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SenhaKeyTyped(evt);
            }
        });
        getContentPane().add(Senha, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 274, 290, -1));

        jLabelMsg.setBackground(new java.awt.Color(231, 76, 60));
        jLabelMsg.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        jLabelMsg.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMsg.setText("Por favor preencha todos os campos!");
        jLabelMsg.setOpaque(true);
        getContentPane().add(jLabelMsg, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 315, 230, -1));

        jPanel1.setMaximumSize(new java.awt.Dimension(596, 60));
        jPanel1.setMinimumSize(new java.awt.Dimension(596, 60));
        jPanel1.setName(""); // NOI18N
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(596, 60));
        jPanel1.setLayout(new java.awt.GridLayout());

        jLLimpar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLLimparMouseClicked(evt);
            }
        });
        jPanel1.add(jLLimpar);

        jLCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLCadastrarMouseClicked(evt);
            }
        });
        jPanel1.add(jLCadastrar);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 350, 45));

        jLBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/CadastrarFuncionarioWindow.png"))); // NOI18N
        getContentPane().add(jLBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, -1));

        Login.setText("jLabel1");
        getContentPane().add(Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 21, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void UsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsernameActionPerformed

    private void NomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomeActionPerformed

    private void jLLimparMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLLimparMouseClicked
        Nome.setText("");
        Username.setText("");
        Senha.setText("");
    }//GEN-LAST:event_jLLimparMouseClicked

    private void jLCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLCadastrarMouseClicked
        if(Nome.getText().equals("") || Username.getText().equals("") || Senha.getPassword().equals("")){
            jLabelMsg.setVisible(true);
        }else{
            String nome = Nome.getText();
            String senha = Senha.getText();
            String login = Username.getText();

            Funcionario fun = new Funcionario(nome,login,senha);
            fun.setTipo_user("2");
            String User_Login = Login.getText();
            boolean cds = fun.cadastrar_funcionario( fun, User_Login);
            if(true == cds){
                JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso");
                jLLimparMouseClicked(evt);
            }
            else{
                JOptionPane.showMessageDialog(null, "Erro ao Cadastrar");  
            }  
        }
    }//GEN-LAST:event_jLCadastrarMouseClicked

    private void NomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NomeKeyTyped
        validator.maxLengthLimit(Nome, 40);
    }//GEN-LAST:event_NomeKeyTyped

    private void UsernameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UsernameKeyTyped
        validator.maxLengthLimit(Username, 20);
    }//GEN-LAST:event_UsernameKeyTyped

    private void SenhaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SenhaKeyTyped
        validator.maxLengthLimit(Senha, 20);
    }//GEN-LAST:event_SenhaKeyTyped

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
            java.util.logging.Logger.getLogger(Cadastro_Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cadastro_Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cadastro_Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cadastro_Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cadastro_Funcionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Login;
    private javax.swing.JTextField Nome;
    private javax.swing.JPasswordField Senha;
    private javax.swing.JTextField Username;
    private javax.swing.JLabel jLBG;
    private javax.swing.JLabel jLCadastrar;
    private javax.swing.JLabel jLLimpar;
    private javax.swing.JLabel jLabelMsg;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sis.escolar.pkg1.pkg1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javax.swing.JOptionPane;
import java.sql.*;
import br.com.sisescolar.dao.ModuloConexao;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Helio Cezar
 */
public class HomeController implements Initializable {
  
    
    public HomeController() {
        conexao = ModuloConexao.conector();

    }
    
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    
    @FXML
    private Label label;
    private Button btnLogar;
    private TextField txtLogin;
    private PasswordField txtSenha;
    
    @FXML
        public void logar() {
        String sql = "select * from tbusuarios where usuario=? and senha=?";
        try {
            // capturando oque ta sendo gitiado na caixa de texto usuario 
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtLogin.getText());
            pst.setString(2, txtSenha.getText());
            // a linha abaixo executa a instrucao 
            
            rs = pst.executeQuery();
            // se existir usuario e senha correspondente
            if (rs.next()) {
                
            
        
        
                conexao.close();
            } else {
                JOptionPane.showMessageDialog(null, "Usuario e/ou senha incorreto");
                txtSenha.setText(null);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
        
        

    @FXML

    private void Clique(ActionEvent event) {
        System.out.println("You clicked me!");
        JOptionPane.showMessageDialog(null, "Hello World!");
       
    }
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

 

}

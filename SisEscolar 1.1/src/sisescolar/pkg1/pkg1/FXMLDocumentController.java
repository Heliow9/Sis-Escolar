/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisescolar.pkg1.pkg1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.sql.*;
import br.com.sisescolar.dao.ModuloConexao;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javax.swing.JOptionPane;

/**
 *
 * @author Helio Cezar
 */
public class FXMLDocumentController implements Initializable {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    @FXML
    private JFXTextField txtUsuario;
    @FXML
    private JFXPasswordField txtSenha;
    @FXML
    private Label lblBanco;
    @FXML
    private void clicou(ActionEvent event) {

        String sql = "select * from tbusuarios where usuario=? and senha=?";
        try {
            // capturando oque ta sendo gitiado na caixa de texto usuario 
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtUsuario.getText());
            pst.setString(2, txtSenha.getText());
            // a linha abaixo executa a instrucao 

            rs = pst.executeQuery();
            // se existir usuario e senha correspondente
            if (rs.next()) {

                System.out.println("Você entrou");

            } else {
                JOptionPane.showMessageDialog(null, "Usuario e/ou senha incorreto");
                txtSenha.setText(null);
            }

        } catch (Exception e) {
            System.out.println("ERROR:" + e);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // inclusao
        // inclusao
        conexao = ModuloConexao.conector();
        if (conexao != null) {
            lblBanco.setText("Banco Conectado");
        } else {
             lblBanco.setText("Banco Desconectado");
        }
    }

}

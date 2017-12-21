/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisescolar.pkg1.pkg1;

import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.sql.*;
import br.com.sisescolar11.dao.ModuloConexao;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import javafx.application.Platform;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
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
    private AnchorPane paneGeral2;
    @FXML
    private AnchorPane cardPane1;
    @FXML
    private AnchorPane cardPane;
    @FXML
    private JFXButton btnCancelar;

    private StackPane stack;
    //  para cada variavel tem que chamar a FXML e criar como private

    @FXML
    private JFXTextField txtUsuario;
    @FXML
    private JFXPasswordField txtSenha;
    @FXML
    private Label lblBanco;
    @FXML
    private JFXButton btnEntrar;
    @FXML
    private MaterialDesignIconView btnFechar;

    public FXMLDocumentController() {
    }

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
                telaprincipal();
                Stage stage = (Stage) btnEntrar.getScene().getWindow(); //Obtendo a janela atual
                stage.close(); //Fechando o Stage

            } else {
                JOptionPane.showMessageDialog(null, "Usuario e/ou senha incorreto");
                txtSenha.setText(null);
            }

        } catch (Exception e) {
            System.out.println("ERROR:" + e);
        }

    }



    @FXML
    public void telaprincipal() {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("TelaPrincipal.fxml"));

            Stage stage = new Stage();
            stage.resizableProperty().setValue(Boolean.FALSE);
            Scene scene = new Scene(root, 560, 480);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO
        // inicializador da conexao 1.1
        conexao = ModuloConexao.conector();
        if (conexao != null) {
            lblBanco.setText("Banco Conectado");
        } else {
            lblBanco.setText("Banco Desconectado");
        }

    }
    // responsável por chamar a tela

    public Node getNode(String node) {
        Node no = null;
        try {
            no = FXMLLoader.load(getClass().getResource(node));
        } catch (Exception e) {
        }
        return no;

    }

    @FXML
    private void clicouCancelar(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void clicarBtnFechar(MouseEvent event) {
        Platform.exit();
    }



}

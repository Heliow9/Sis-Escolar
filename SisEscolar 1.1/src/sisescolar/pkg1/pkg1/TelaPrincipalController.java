/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisescolar.pkg1.pkg1;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;


import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Helio Cezar
 */
public class TelaPrincipalController implements Initializable {

    @FXML
    private MenuBar mBar;
    @FXML
    private Menu mSair;




    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO


    }

    private void clicouCancelar(ActionEvent event) {
        Platform.exit();
        
    }



    }    




        



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sis.escolar.pkg1.pkg1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Helio Cezar
 */
public class SisEscolar11 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));

        Scene scene = new Scene(root);

        Parent root1 = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene scene1 = new Scene(root1);

        stage.setScene(scene);
        stage.show();
    }

    public static void ChangeScene() {

    }

    public static void main(String[] args) {
        launch(args);
    }

}

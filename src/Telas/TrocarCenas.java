/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 *
 * @author Flávio
 */
//Classe para realizar a troca de cenas entre as telas
public class TrocarCenas {
    public static void trocarcena_direita(Parent root, Button botao, AnchorPane janel){
           
        Scene scene = botao.getScene(); 
        root.translateXProperty().set(scene.getWidth());
        
        StackPane parentContainer = (StackPane) botao.getScene().getRoot();

        parentContainer.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> { parentContainer.getChildren().remove(janel);});
        timeline.play();
    }
    public static void trocarcena_baixo(Parent root, Button botao, AnchorPane janel){
           
        Scene scene = botao.getScene();
        root.translateYProperty().set(scene.getWidth());

        StackPane parentContainer = (StackPane) botao.getScene().getRoot();

        parentContainer.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> { parentContainer.getChildren().remove(janel);});
        timeline.play();
    }
}

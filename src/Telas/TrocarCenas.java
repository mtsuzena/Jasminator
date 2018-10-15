package Telas;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

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
    public static void cena_jogador(Parent root, AnchorPane janel){
         Scene scene = janel.getScene();
         root.translateYProperty().set(scene.getWidth());
         StackPane parentContainer = (StackPane) janel.getScene().getRoot();
         parentContainer.getChildren().add(root);
        
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> {  parentContainer.getChildren().remove(janel);});
        timeline.play();
        
    }
        
}
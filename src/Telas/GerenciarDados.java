package Telas;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GerenciarDados extends Application {
    public static Stage stage;
    
    @Override
    public void start(Stage stage)throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/Fxml/Gerenciar_dados.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Gerenciar cadastros");
        stage.setScene(scene);
        stage.show();
        setStage(stage);
    }

    public static Stage getStage(){
        return stage;
    }

    public static void setStage(Stage stage){
        GerenciarDados.stage = stage;
    }
    
    public static void main(String[] args){
        launch(args);
    }
}
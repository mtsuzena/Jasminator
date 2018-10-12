package Telas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuLogin extends Application {
    public static Stage stage;

    @Override
    public void start(Stage stage)throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/Fxml/Menu_login.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Sessão do administrador");
        stage.setScene(scene);
        stage.show();
        setStage(stage);
    }

    public static Stage getStage(){
        return stage;
    }

    public static void setStage(Stage stage){
        MenuLogin.stage = stage;
    }
    
    public static void main(String[] args){
        launch(args);
    }
}
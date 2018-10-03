
package Telas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Menuinicial extends Application{
    public static Stage stage;
    private static Parent root;
    
    @Override
    public void start(Stage stage)throws Exception{
        //Carregar arquivo FXML
        Parent root = FXMLLoader.load(getClass().getResource("/Fxml/Menu_inicial.fxml"));
        
        //Instanciar uma nova scena, e passar o FXML
        Scene scene = new Scene(root);
        
        //Setar titulo da janela
        stage.setTitle("Castle of Question");
        
        //Setar scena na janela
        stage.setScene(scene);
        //Printar scena
        stage.show();
        
        //Salvar janela
        setRoot(root);
        setStage(stage);
    }
 
    public static Stage getStage(){
        return stage;
    }
    public static void setStage(Stage stage){
        Menuinicial.stage = stage;
    }
    
    public static void start(String[] args){
        launch(args);
    }

    /**
     * @return the root
     */
    public static Parent getRoot() {
        return root;
    }

    /**
     * @param aRoot the root to set
     */
    public static void setRoot(Parent aRoot) {
        root = aRoot;
    }
}

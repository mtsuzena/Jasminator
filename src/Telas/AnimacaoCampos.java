package Telas;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.util.Duration;

//Classe para realizar animação dos campos do cadastrar pessoa e entre outros!!
public class AnimacaoCampos {
    public static void vibrar(JFXCheckBox control){
        RotateTransition rotate = new RotateTransition(Duration.millis(60), control);
               rotate.setFromAngle(-4);
               rotate.setToAngle(4);
               rotate.setCycleCount(8);
               rotate.setAutoReverse(true);
               rotate.setOnFinished((ActionEvent event)->{
                 control.setRotate(0); 
        });
        rotate.play();
    }
    
    public static void vibrar(JFXTextField control){
        RotateTransition rotate = new RotateTransition(Duration.millis(60), control);
               rotate.setFromAngle(-4);
               rotate.setToAngle(4);
               rotate.setCycleCount(8);
               rotate.setAutoReverse(true);
               rotate.setOnFinished((ActionEvent event)->{
                 control.setRotate(0);      
        });
        rotate.play();
    }
    public static void vibrar(JFXComboBox control){
        RotateTransition rotate = new RotateTransition(Duration.millis(60), control);
               rotate.setFromAngle(-4);
               rotate.setToAngle(4);
               rotate.setCycleCount(8);
               rotate.setAutoReverse(true);
               rotate.setOnFinished((ActionEvent event)->{
                 control.setRotate(0);      
        });
        rotate.play();
    }
}

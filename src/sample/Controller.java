package sample;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.userinterface.userinterface;
import sample.application;
public class Controller  {

     private Scene scene;
    private Stage stage;

   public void setScene(ActionEvent event)  {
     /*  stage=(Stage)((Node)event.getSource()).getScene().getWindow();
       userinterface u=new userinterface();
       stage.setScene(u.getScene());
       u.initiate_class();
       stage.show();

      */
   }
}

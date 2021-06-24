package App;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.awt.*;

public class View {
    Stage stage;
    Scene mainScene;
    StackPane root;
    TextField cityField;
    javafx.scene.control.Button getDataBtn;
    public View(){
        init();
        createButtonToGrabData();
        createInputCity();
    }
    public  void init(){
        root = new StackPane();
        mainScene = new Scene(root,360,620);
        mainScene.getStylesheets().add("Assets/style.css");
        stage = new Stage();
        stage.setScene(mainScene);
        stage.show();
    }


    public void createInputCity(){
        cityField = new TextField("city");
        cityField.setFocusTraversable(false);
        root.setAlignment(cityField,Pos.TOP_CENTER);
        root.getChildren().add(cityField);
    }

    public void createButtonToGrabData(){
        getDataBtn = new javafx.scene.control.Button("Show");
        root.setAlignment(getDataBtn,Pos.TOP_CENTER);
        root.getChildren().add(getDataBtn);
    }
}

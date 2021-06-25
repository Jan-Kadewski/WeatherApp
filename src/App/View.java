package App;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class View {
    Stage stage;
    Scene mainScene;
    StackPane root;
    TextField cityField;
    Hyperlink hyperlink;
    javafx.scene.control.Button getDataBtn;
    Label noFoundCityErrorLabel;

    public View() {
        init();
        initGui();
    }

    public void init() {
        root = new StackPane();
        mainScene = new Scene(root, 360, 620);
        mainScene.getStylesheets().add("Assets/style.css");
        stage = new Stage();
        stage.setTitle("Weather");
        stage.setScene(mainScene);
        stage.show();
    }

    public void initGui() {
        createButtonToGrabData();
        createInputCity();
        createButtonAndSetButtonAndInputVisible();
    }

    public void createInputCity() {
        cityField = new TextField("city");
        cityField.setFocusTraversable(false);
        root.setAlignment(cityField, Pos.TOP_CENTER);
        root.getChildren().add(cityField);
    }

    public void createButtonToGrabData() {
        getDataBtn = new javafx.scene.control.Button("Show");
        root.setAlignment(getDataBtn, Pos.TOP_CENTER);
        root.getChildren().add(getDataBtn);
    }

    public void createButtonAndSetButtonAndInputVisible() {
        hyperlink = new Hyperlink("Go to search");
        hyperlink.setId("hyperlink");
        root.setAlignment(Pos.BOTTOM_RIGHT);
        root.getChildren().add(hyperlink);
    }
}

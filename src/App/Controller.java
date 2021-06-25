package App;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;

import java.io.IOException;

public class Controller {
    View view;
    public Controller(){
        view = new View();
        buttonActionOnClick();
        recreateButtonToSearchWithTextField();
    }

    public void buttonActionOnClick(){
        view.getDataBtn.setOnAction(e -> {
            if(e.getSource() == view.getDataBtn){

                Config cfg = new Config();
                cfg.city = view.cityField.getText();
                try {
                    cfg.getDataFromWeatherApi();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                System.out.println(cfg.testResponse);
                if(cfg.status == 404){
                    view.noFoundCityErrorLabel = new Label("No found city, try again");
                    view.noFoundCityErrorLabel.setId("labelError");
                    view.root.getChildren().add(view.noFoundCityErrorLabel);
                }
                view.root.getChildren().removeAll(view.cityField,view.getDataBtn);
            }
        });
    }

    public void recreateButtonToSearchWithTextField(){
        view.hyperlink.setOnAction(e ->{
            if(e.getSource() == view.hyperlink){
                view.root.getChildren().addAll(view.getDataBtn,view.cityField);
                view.root.getChildren().remove(view.noFoundCityErrorLabel);
            }
        });
    }
}

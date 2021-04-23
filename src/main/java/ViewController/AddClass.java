package ViewController;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddClass {
    public Button AddClassBack;
    public Button AddClassPublish;
    public ComboBox AddClassType;
    public TextField AddClassIntro;
    public TextField AddClassIntroUrl;
    public ComboBox AddClassDays;

    public Scene previousScene;

    public void AddClassBackClicked(ActionEvent actionEvent) {
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        TrainerMainSceneController controller = (TrainerMainSceneController) previousScene.getUserData();
        window.setScene(previousScene);
    }

    public void AddClassPublishClicked(ActionEvent actionEvent) {
    }

    public void AddClassChooseDays(ActionEvent actionEvent) {
    }
}

package ViewController;

import Model.*;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;


public class LiveShowScene {
    public Label dayLabel;
    public Label urlLabel;
    public String url;
    public LivePlan live_plan;

    public void liveFinishButtonClicked(ActionEvent actionEvent) throws IOException {
        System.out.println(IO.printObject(live_plan));
        Control.finishLiveSession(live_plan);
        LiveSceneController previousController= (LiveSceneController) ((Node)actionEvent.getSource()).getScene().getUserData();
        previousController.buildScene();
        Stage stage = (Stage)(((Node) actionEvent.getSource()).getScene().getWindow());
        stage.close();
    }
}

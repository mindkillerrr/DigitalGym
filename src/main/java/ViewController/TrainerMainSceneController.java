package ViewController;

import Model.*;
import Model.Control;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;


import Model.Client;
import Model.IO;
import Model.Policy;


public class TrainerMainSceneController {
    public Button TrainerMainAddClassButton;
    public Button TrainerMainAddLiveButton;
    public ChoiceBox myLiveFilterType;
    public Button Goto;
    public TextArea myLiveOverviewText;
    public Model.Trainer trainer;
    public TrainerMainSceneController local_controller;
    public FlowPane MyClassFlowPane;
    public ChoiceBox MyClassFilter;
    public Button MyClassSearch;
    public TextField MyClassOverView;
    public Button MyClassDelete;
    public Button MyClassChange;
    public Label MyAccountName;
    public Button MyAccountChangePassword;
    public Button MyAccountchangeEmail;
    public TextField MyAccountIntro;



    public void TrainerMainAddClassButtonClicked(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/AddClass.fxml"));
        Parent addClassParent = loader.load();
        Scene addClassScene = new Scene(addClassParent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(addClassScene);
        window.show();
    }

    public void TrainerMainAddLiveButtonClicked(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/AddLive.fxml"));
        Parent addLiveParent = loader.load();
        Scene addLiveScene = new Scene(addLiveParent);

        AddLive controller = loader.getController();
        controller.setTrainer(trainer);
        stage.setScene(addLiveScene);
        stage.show();
//


    }
    public void buildScene() throws SAXException, ParserConfigurationException, XPathExpressionException, IOException {
        trainer = (Trainer) IO.read(trainer, trainer.getPhone_number());
        for (Date s : trainer.getOccupation()) {
            myLiveFilterType.getItems().add(s);
        }
        myLiveFilterType.setValue(myLiveFilterType.getItems().get(0));


    }

    //go to new page
    EventHandler<ActionEvent> liveButtonClicked = new EventHandler<ActionEvent>() {
        /**
         * this function change to the live page according to the live button clicked.
         * @param actionEvent
         */
        @Override
        public void handle(ActionEvent actionEvent) {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/LiveScene.fxml"));
            Parent classSceneParent = null;

            try {
                classSceneParent = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene classScene = new Scene(classSceneParent);
            Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

            LiveSceneController controller = loader.getController();
            controller.live = (Live) (((Node) actionEvent.getSource()).getUserData());
            controller.previousScene = ((Node) actionEvent.getSource()).getScene();
            //controller.setTrainer(trainer);

            window.setScene(classScene);
            try {
                controller.buildScene();//build course scene dynamically according to the course information
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    };

    public ArrayList<Button> getLiveButtonsForMyClass() throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {

        ArrayList<Button> buttons =new ArrayList<Button>();
        Control controller = new Control();
        trainer = (Trainer) IO.read(trainer,trainer.getPhone_number());
        //ArrayList <Live> lives = controller.getTrainerLives(trainer);
        //for(Live live : lives){
        Button button = new Button();
        button.setPrefSize(160,160);
        //mainPageFlowPane.getChildren().add(button);
        button.setOnAction(liveButtonClicked);
        button.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        myLiveOverviewText.setText(((Live)button.getUserData()).getInfo());

                    }
                });


        //button.setUserData(live);
        //button.setText("\n"+live.getInfo());
        buttons.add(button);
        return buttons;
    }
    public void MyClassSearchClicked(ActionEvent actionEvent) {
    }

    public void MyClassDeleteClicked(ActionEvent actionEvent) {
    }

    public void MyClassChangeClicked(ActionEvent actionEvent) {
    }

    public void MyAccountChangePasswordClicked(ActionEvent actionEvent) {
    }

    public void MyAccountChangeEmailClicked(ActionEvent actionEvent) {
    }
}


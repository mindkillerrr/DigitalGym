package ViewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class WatchVideo {
    public Circle circle;
    public Label video;
    public Polygon triangle;
    public Label dayLabel;
    public Label urlLabel;
    public String url;
    public MediaView videoView;
    public Label courseNameLabel;

    /**
     *
     * MediaView Component added to show vedio later --PZ
     * vedio function added, for test all course's daily workout vedio are the same
     * @author PZ
     * @throws MalformedURLException
     */
    public void playVedio() throws MalformedURLException {

        File mediaFile = new File("target/classes/video/"+url);//find file
        Media media = new Media(mediaFile.toURI().toURL().toString());//convert to Media

        MediaPlayer mediaPlayer = new MediaPlayer(media);//generate player
        urlLabel.setText(mediaFile.toURI().toURL().toString());
        //videoView = new MediaView(mediaPlayer);
        videoView.setMediaPlayer(mediaPlayer);//put player into MediaView
        mediaPlayer.play();

    }
}

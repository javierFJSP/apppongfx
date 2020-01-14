package com.mycompany.pongfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * JavaFX App
 */
public class App extends Application {

    int ballCenterX = 500;
    int ballCurrentSpeedX = 3;
    int ballDirectionX = 1;
    int ballCenterY = 480;
    int ballCurrentSpeedY = 3;
    int ballDirectionY = 1;
    
    @Override        
    public void start (Stage stage) {
        
        final short SCENE_HEIGHT = 480;
        final short SCENE_WIDHT = 640;
        
        Pane root = new Pane();
        var scene = new Scene(root, SCENE_WIDHT, SCENE_HEIGHT);
        scene.setFill(Color.BLACK);
        stage.setScene(scene);
        stage.show();
    
        //
        Circle circleBall = new Circle();
        circleBall.setCenterX(10);
        circleBall.setCenterY(30);
        circleBall.setRadius(7);
        circleBall.setFill(Color.WHITE);

        root.getChildren().add(circleBall);
        
        short rectHeight = 50;
        Rectangle rectStick = new Rectangle();
        rectStick.setWidth(10);
        rectStick.setHeight(rectHeight);
        rectStick.setX(SCENE_WIDHT - 40);
        rectStick.setY((SCENE_HEIGHT-rectHeight)/2);
        rectStick.setFill(Color.WHITE);

        Timeline timeline = new Timeline(
            // 0.017 = 60 fps
            new KeyFrame(Duration.seconds(0.017), new EventHandler<ActionEvent>() {
                public void handle(ActionEvent ae) {
                    System.out.println(ballCenterX);
                    circleBall.setCenterX(ballCenterX);
                    circleBall.setCenterY(ballCenterY);
                    ballCenterX += ballCurrentSpeedX * ballDirectionX;
                    ballCenterY += ballCurrentSpeedY * ballDirectionY;
                    if(ballCenterX >= 640) {
                        ballDirectionX = -3;
                    } else if(ballCenterX <= 0){
                        ballDirectionX = 3;
                    }
                    if(ballCenterY >= 480) {
                        ballDirectionY = -3;
                    } else if(ballCenterY <= 0){
                        ballDirectionY = 3;
                    }
                }
            })
        );
        timeline.setCycleCount(timeline.INDEFINITE);
        timeline.play();
    }

    public static void main(String[] args){
        launch();
    }


}
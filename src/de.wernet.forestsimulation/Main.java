package de.wernet.forestsimulation;

import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;


public class Main extends Application {

    private Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        if (!Platform.isSupported(ConditionalFeature.SCENE3D)) {
            throw new RuntimeException("ERROR: common conditional SCENE3D is not supported");
        }

        // Near
/*
        Button button = new Button("Display Rectangles");
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, (mouseEvent) -> controller.buttonClicked());
        button.setFocusTraversable(false);

        final Box floor = new Box(200, 200, 1);
        floor.setTranslateX(200);
        floor.setTranslateY(200);
        floor.setTranslateZ(50);
        floor.setMaterial(new PhongMaterial(Color.SANDYBROWN));
*/

        primaryStage.setTitle("Forest Simulation");

//        Group root = new Group(floor, button);

        Scene scene = new Scene(root, 600, 600);

        controller = new Controller(scene);
//        rotationGroup.setDepthTest(DepthTest.DISABLE);

        scene.setOnKeyReleased(e -> controller.addTree(e));


        scene.setCamera(new PerspectiveCamera());
        primaryStage.setScene(scene);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

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
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        if (!Platform.isSupported(ConditionalFeature.SCENE3D)) {
            throw new RuntimeException("ERROR: common conditional SCENE3D is not supported");
        }

//        Button button = new Button("Display Rectangles");
//        button.addEventHandler(MouseEvent.MOUSE_CLICKED, (mouseEvent) -> controller.buttonClicked());
//        button.setFocusTraversable(false);

        //create a new material to use on the floor
        PhongMaterial material = new PhongMaterial(Color.GREEN);

        //create the floor
        Box floor = new Box(200, 0.1, 200);
        floor.setMaterial(material);
//        floor2.setTranslateX(220);
        floor.setTranslateY(100);
//        floor2.setTranslateZ(60);

        //create a white light to light the scene
        PointLight light = new PointLight(Color.WHITESMOKE);
        light.setTranslateX(0.0);
        light.setTranslateY(-400.0);
        light.setTranslateZ(-300.0);

        Group root = new Group(floor, light);

        Scene scene = new Scene(root, 600, 600);

        controller = new Controller(scene);
//        rotationGroup.setDepthTest(DepthTest.DISABLE);

        scene.setOnKeyReleased(e -> controller.addTree(e));

//        scene.setCamera(new PerspectiveCamera());

        primaryStage.setTitle("Forest Simulation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

package de.hska.cg.forestsimulation;

import javafx.application.Application;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.DrawMode;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class Main3D extends Application{
	
	Controller controller;
	SceneCamera camera;
		
	@Override
    public void start(Stage primaryStage) throws Exception {
		Group root = new Group();       
        Rotate cameraRotateX = new Rotate(0.0, Rotate.X_AXIS);
        Rotate cameraRotateY = new Rotate(20, Rotate.Y_AXIS);
        Translate cameraTranslate = new Translate(0.0, -150.0, -700.0);
        camera = new SceneCamera(cameraRotateY, cameraRotateX, cameraTranslate);
        
		
		primaryStage.setResizable(false);
        Scene scene = new Scene(root, 1000, 800);
        scene.setCamera(camera.getCamera());
        controller = new Controller(scene, camera);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Java main for when running without JavaFX launcher
     */
    public static void main(String[] args) {
        launch(args);
        
    }
    
}

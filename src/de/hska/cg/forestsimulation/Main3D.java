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
	
//	public Parent createContent() throws Exception {
//		 
//        // Box
//        Box testBox = new Box(5, 5, 5);
//        testBox.setMaterial(new PhongMaterial(Color.RED));
//        testBox.setDrawMode(DrawMode.LINE);
// 
//        // Build the Scene Graph
//        
//        
//        
//        root.getChildren().add(testBox);
// 
//        // Use a SubScene       
////        SubScene subScene = new SubScene(root, 300,300);
////        subScene.setFill(Color.ALICEBLUE);
////        subScene.setCamera(camera.getCamera());
////        Group group = new Group();
////        group.getChildren().add(subScene);
//        return group;
//    }
	
	
	@Override
    public void start(Stage primaryStage) throws Exception {
		Group root = new Group();       
        Rotate cameraRotateX = new Rotate(0.0, Rotate.X_AXIS);
        Rotate cameraRotateY = new Rotate(0.0, Rotate.Y_AXIS);
        Translate cameraTranslate = new Translate(0.0, -150.0, -700.0);
        camera = new SceneCamera(cameraRotateY, cameraRotateX, cameraTranslate);
        
		
		primaryStage.setResizable(false);
        Scene scene = new Scene(root);
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
    
//  private Group createTree(){
//
//      Image tree = new Image("birch.png");
//
//      Rectangle rect1 = new Rectangle(100,200);
//      rect1.setFill(new ImagePattern(tree));
//      Rectangle rect2 = new Rectangle(100,200);
//      rect2.setFill(new ImagePattern(tree));
//      rect2.setRotationAxis(Rotate.Y_AXIS);
//      rect2.setRotate(60);
//      Rectangle rect3 = new Rectangle(100,200);
//      rect3.setFill(new ImagePattern(tree));
//      rect3.setRotationAxis(Rotate.Y_AXIS);
//      rect3.setRotate(120);
//
//      Group newTree = new Group(rect1, rect2, rect3);
//      newTree.setTranslateY(scene.getHeight() * Math.random());
//      newTree.setTranslateX(scene.getWidth()* Math.random());
//      return newTree;
//  }
}

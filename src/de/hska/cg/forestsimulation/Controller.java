package de.hska.cg.forestsimulation;

import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.scene.Camera;
import javafx.scene.PerspectiveCamera;
import javafx.scene.transform.Translate;

public class Controller {

    private Scene scene;
    
    private SceneCamera camera;
    private ObjectCollection objects;

    private static final double ROTATE_TICK = 10.0;

    private double mouseXOld;
    private double mouseYOld;
    private double mouseXCurr;
    private double mouseYCurr;
    private double mouseXDelta;
    private double mouseYDelta;

    private Rotate cameraRotateX;
    private Rotate cameraRotateY;
    private Translate cameraTranslate;

    public Controller(Scene scene, SceneCamera camera){
        this.scene = scene;
        this.camera = camera;
        this.cameraRotateX = camera.getCameraRotateX();
        this.cameraRotateY = camera.getCameraRotateY();
        this.cameraTranslate = camera.getCameraTranslate();
        this.objects = new ObjectCollection();

        addKeyPressedHandlers();
        addKeyReleasedHandlers();
        addMouseHandlers();
        
    }


//    public void buttonClicked() {
//        Rectangle red = new Rectangle(300, 300, Color.RED);
//        red.setTranslateX(-50);
//        red.setTranslateY(-50);
//        red.setTranslateZ(1);
//
//        // Far
//        Rectangle green = new Rectangle(300, 300, Color.GREEN);
//        green.setTranslateX(100);
//        green.setTranslateY(0);
//        green.setTranslateZ(200);
//
//        // Mid
//        Rectangle blue = new Rectangle(300, 300, Color.BLUE);
//        blue.setTranslateX(0);
//        blue.setTranslateY(100);
//        blue.setTranslateZ(100);
//
//        Group rotationGroup = new Group(red, green, blue);
//        rotationGroup.setTranslateX(125);
//        rotationGroup.setTranslateY(125);
//        rotationGroup.setRotationAxis(Rotate.Y_AXIS);
//
//        Slider s = new Slider(0, 360, 0);
//        s.setBlockIncrement(1);
//        s.setTranslateX(225);
//        s.setTranslateY(575);
//        rotationGroup.rotateProperty().bind(s.valueProperty());
//
//        Parent parent = scene.getRoot();
//        Group group = (Group) parent;
//        group.getChildren().addAll(rotationGroup, s);
//    }

    
    private Group createTree(){

    	Group tree = objects.treeBirch();
    	tree.setTranslateZ(200 * Math.random());
        tree.setTranslateX(200 * Math.random());
        return tree;
    }
    
    public void addKeyReleasedHandlers() {
    	Group group = (Group) scene.getRoot();
    	scene.setOnKeyReleased(e -> {
    		switch(e.getCode()){
    		case SPACE: 
    			System.out.println("Leertaste");
                group.getChildren().add(createTree());
                break;
    		case COMMA: 
    			System.out.println("comma");
                group.getChildren().add(objects.box());
            default:
    		}
    	});
            
    }
    
    private final void addKeyPressedHandlers() {
        scene.setOnKeyPressed(event -> {
            switch(event.getCode()) {
                case RIGHT:
                    cameraRotateY.setAngle(cameraRotateY.getAngle() + ROTATE_TICK);
                    break;
                case LEFT:
                    cameraRotateY.setAngle(cameraRotateY.getAngle() - ROTATE_TICK);
                    break;
                case UP:
                    cameraRotateX.setAngle(cameraRotateX.getAngle() + ROTATE_TICK);
                    break;
                case DOWN:
                    cameraRotateX.setAngle(cameraRotateX.getAngle() - ROTATE_TICK);
                    break;
                default:
                    // For the sake of conventions.
                    break;
            }
        });
    }

    private final void addMouseHandlers() {
        scene.setOnMousePressed(event -> {
            mouseXCurr = event.getSceneX();
            mouseYCurr = event.getSceneY();
            mouseXOld = event.getSceneX();
            mouseYOld = event.getSceneY();
        });

        scene.setOnMouseDragged(event -> {
            mouseXOld = mouseXCurr;
            mouseYOld = mouseYCurr;
            mouseXCurr = event.getSceneX();
            mouseYCurr = event.getSceneY();
            mouseXDelta = mouseXCurr - mouseXOld;
            mouseYDelta = mouseYCurr - mouseYOld;

            cameraTranslate.setX(cameraTranslate.getX() - mouseXDelta);
            cameraTranslate.setY(cameraTranslate.getY() - mouseYDelta);
        });

        scene.setOnScroll(event -> {
            cameraTranslate.setZ(cameraTranslate.getZ() + event.getDeltaY());
        });
    }
}











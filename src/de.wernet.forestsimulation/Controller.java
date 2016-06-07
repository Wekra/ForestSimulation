package de.wernet.forestsimulation;

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

    private static final double ROTATE_TICK = 10.0;

    private double mouseXOld;
    private double mouseYOld;
    private double mouseXCurr;
    private double mouseYCurr;
    private double mouseXDelta;
    private double mouseYDelta;

    private Rotate cameraRotateX = new Rotate(-20.0, Rotate.X_AXIS);
    private Rotate cameraRotateY = new Rotate(-20.0, Rotate.Y_AXIS);
    private Translate cameraTranslate = new Translate(100.0, 100.0, -500.0);

    public Controller(Scene scene){
        this.scene = scene;
        scene.setCamera(setUpCamera());

        addKeyHandlers();
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

    /**
     * React to a key event and add a new "tree" to the scene.
     * @param e the KeyEvent to react to
     */
    public void addTree(KeyEvent e) {

        if(e.getCode() == KeyCode.SPACE){
            System.out.println("Leertaste");
            Group group = (Group) scene.getRoot();
            group.getChildren().add(createTree());
        }
    }

    /**
     * This method creates a new "tree".
     * @return a Group resembling a tree
     */
    private Group createTree(){

        Image tree = new Image("birch.png");

        Rectangle rect1 = new Rectangle(50,100);
        rect1.setFill(new ImagePattern(tree));
        rect1.setRotationAxis(Rotate.Y_AXIS);
        rect1.setRotate(0.01);
        Rectangle rect2 = new Rectangle(50,100);
        rect2.setFill(new ImagePattern(tree));
        rect2.setRotationAxis(Rotate.Y_AXIS);
        rect2.setRotate(60);
        Rectangle rect3 = new Rectangle(50,100);
        rect3.setFill(new ImagePattern(tree));
        rect3.setRotationAxis(Rotate.Y_AXIS);
        rect3.setRotate(120);

        Group newTree = new Group(rect1, rect2, rect3);
        newTree.setTranslateZ((int)(199 * Math.random()) - 100);
        newTree.setTranslateX((int)(199 * Math.random()) - 100);
        return newTree;
    }

    /**
     * Set up the camera used in the scene.
     * @return the finished Camera
     */
    private final Camera setUpCamera() {
        PerspectiveCamera camera = new PerspectiveCamera(true);

        camera.setFieldOfView(105.0);
        camera.setFarClip(10000.0);
        camera.setRotationAxis(Rotate.Z_AXIS);
        camera.setRotate(0);
        camera.getTransforms().addAll(cameraRotateY, cameraRotateX,
                cameraTranslate);

        return camera;
    }

    /**
     * Add KeyHandlers to the scene to control it.
     */
    private final void addKeyHandlers() {
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

    /**
     * Add MouseHandlers to the scene to control the camera with the mouse.
     */
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
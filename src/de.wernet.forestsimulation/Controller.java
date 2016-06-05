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

public class Controller {

    private Scene scene;

    public Controller(Scene scene){
        this.scene = scene;
    }


    public void buttonClicked() {
        Rectangle red = new Rectangle(300, 300, Color.RED);
        red.setTranslateX(-50);
        red.setTranslateY(-50);
        red.setTranslateZ(1);

        // Far
        Rectangle green = new Rectangle(300, 300, Color.GREEN);
        green.setTranslateX(100);
        green.setTranslateY(0);
        green.setTranslateZ(200);

        // Mid
        Rectangle blue = new Rectangle(300, 300, Color.BLUE);
        blue.setTranslateX(0);
        blue.setTranslateY(100);
        blue.setTranslateZ(100);

        Group rotationGroup = new Group(red, green, blue);
        rotationGroup.setTranslateX(125);
        rotationGroup.setTranslateY(125);
        rotationGroup.setRotationAxis(Rotate.Y_AXIS);

        Slider s = new Slider(0, 360, 0);
        s.setBlockIncrement(1);
        s.setTranslateX(225);
        s.setTranslateY(575);
        rotationGroup.rotateProperty().bind(s.valueProperty());

        Parent parent = scene.getRoot();
        Group group = (Group) parent;
        group.getChildren().addAll(rotationGroup, s);
    }

    public void addTree(KeyEvent e) {

        if(e.getCode() == KeyCode.SPACE){
            System.out.println("Leertaste");
            Group group = (Group) scene.getRoot();
            group.getChildren().add(createTree());
        }



    }

    private Group createTree(){

        Image tree = new Image("birch.png");

        Rectangle rect1 = new Rectangle(100,200);
        rect1.setFill(new ImagePattern(tree));
        Rectangle rect2 = new Rectangle(100,200);
        rect2.setFill(new ImagePattern(tree));
        rect2.setRotationAxis(Rotate.Y_AXIS);
        rect2.setRotate(60);
        Rectangle rect3 = new Rectangle(100,200);
        rect3.setFill(new ImagePattern(tree));
        rect3.setRotationAxis(Rotate.Y_AXIS);
        rect3.setRotate(120);

        Group newTree = new Group(rect1, rect2, rect3);
        newTree.setTranslateY(scene.getHeight() * Math.random());
        newTree.setTranslateX(scene.getWidth()* Math.random());
        return newTree;
    }
}

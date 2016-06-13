package de.hska.cg.forestsimulation;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;

public class ObjectCollection {

    private Image tree;
    private ImagePattern treePattern;

    public ObjectCollection() {
        tree = new Image("/res/birch.png");
        treePattern = new ImagePattern(tree);
    }

    public Group treeBirch() {
        Rectangle rect1 = new Rectangle(50, 100);
        rect1.setFill(treePattern);
        rect1.setRotationAxis(Rotate.Y_AXIS);
        rect1.setRotate(1);

        Rectangle rect2 = new Rectangle(50, 100);
        rect2.setFill(treePattern);
        rect2.setRotationAxis(Rotate.Y_AXIS);
        rect2.setRotate(60);

        Rectangle rect3 = new Rectangle(50, 100);
        rect3.setFill(treePattern);
        rect3.setRotationAxis(Rotate.Y_AXIS);
        rect3.setRotate(120);

        Group newTree = new Group(rect1, rect2, rect3);

        return newTree;
    }

    public Box box() {
        Box testBox = new Box(5, 5, 5);
        testBox.setMaterial(new PhongMaterial(Color.RED));
        testBox.setDrawMode(DrawMode.LINE);

        return testBox;
    }

    public Box floor() {
//		if(floor != null){
//			return floor;
//		}
        final Box floor = new Box(200, 1, 200);
        floor.setMaterial(new PhongMaterial(Color.SANDYBROWN));
        floor.setTranslateY(100);
        return floor;
    }
}
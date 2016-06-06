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
	
	public Group treeBirch(){
		Image tree = new Image("/res/birch.png");

        Rectangle rect1 = new Rectangle(100,200);
        rect1.setFill(new ImagePattern(tree));
        rect1.setRotationAxis(Rotate.Y_AXIS);
        rect1.setRotate(1);
        Rectangle rect2 = new Rectangle(100,200);
        rect2.setFill(new ImagePattern(tree));
        rect2.setRotationAxis(Rotate.Y_AXIS);
        rect2.setRotate(60);
        Rectangle rect3 = new Rectangle(100,200);
        rect3.setFill(new ImagePattern(tree));
        rect3.setRotationAxis(Rotate.Y_AXIS);
        rect3.setRotate(120);

        Group newTree = new Group(rect1, rect2, rect3);
        
        return newTree;
	}
	public Box box(){
		Box testBox = new Box(5, 5, 5);
	    testBox.setMaterial(new PhongMaterial(Color.RED));
	    testBox.setDrawMode(DrawMode.LINE);
	    
	    return testBox;
	}
}

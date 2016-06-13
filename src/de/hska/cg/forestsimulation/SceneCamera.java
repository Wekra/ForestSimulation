package de.hska.cg.forestsimulation;

import javafx.scene.Camera;
import javafx.scene.PerspectiveCamera;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

public class SceneCamera {

    private PerspectiveCamera camera;

    Rotate cameraRotateY;
    Rotate cameraRotateX;
    Translate cameraTranslate;

    public SceneCamera(Rotate cameraRotateY, Rotate cameraRotateX, Translate cameraTranslate) {
        PerspectiveCamera camera = new PerspectiveCamera(true);
        this.cameraRotateX = cameraRotateX;
        this.cameraRotateY = cameraRotateY;
        this.cameraTranslate = cameraTranslate;

        camera.setFieldOfView(105.0);
        camera.setFarClip(10000.0);
//        camera.setRotationAxis(Rotate.Z_AXIS);
//        camera.setRotate(0);

        camera.getTransforms().addAll(cameraRotateY, cameraRotateX,
                cameraTranslate);
        this.camera = camera;
    }

    public void rotate(double rotateX, double rotateY) {
        cameraRotateX.setAngle(cameraRotateX.getAngle() + rotateX);
        cameraRotateY.setAngle(cameraRotateY.getAngle() + rotateY);
    }

    public void translate(double translateX, double translateY, double translateZ) {
        cameraTranslate.inverseTransform(translateX, translateY, translateZ);
    }

    public Camera getCamera() {
        return camera;
    }

    public Rotate getCameraRotateY() {
        return cameraRotateY;
    }

    public Rotate getCameraRotateX() {
        return cameraRotateX;
    }

    public Translate getCameraTranslate() {
        return cameraTranslate;
    }

}
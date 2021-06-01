package alt.sim.view;

import java.net.URL;
import java.util.ResourceBundle;

import alt.sim.model.ImageClassification;
import alt.sim.model.plane.Plane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Seaside {

    private static final double PLANE_DIMENSION = 50;
    private Plane plane;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Rectangle wallRectangle;

    @FXML
    private Circle helipadWall;

    @FXML
    void dragDetection(final MouseEvent event) {
        System.out.println("COLLIDED");
    }

    @FXML
    void onPauseClick(final ActionEvent event) {

    }

    @FXML
    void planeMovement(final MouseEvent event) {
        plane.getImagePlane().setX(event.getX());
        plane.getImagePlane().setY(event.getY());
        //check collision
        if (plane.getImagePlane().getBoundsInParent().intersects(wallRectangle.getBoundsInParent())) {
            System.out.println("AirStrip COLLIDED!!!");
        }
    }

    @FXML
    void initialize() {
        assert wallRectangle != null : "fx:id=\"wallRectangle\" was not injected: check your FXML file 'Seaside.fxml'.";
        assert helipadWall != null : "fx:id=\"helipadWall\" was not injected: check your FXML file 'Seaside.fxml'.";
        plane = new Plane(ImageClassification.AIRPLANE);
        plane.getSpritePlane().setX(100);
        plane.getSpritePlane().setY(100);
        plane.getImagePlane().setFitWidth(PLANE_DIMENSION);
        plane.getImagePlane().setFitHeight(PLANE_DIMENSION);
    }

    Plane getPlane() {
        return this.plane;
    }

    public Rectangle getWallRectangle() {
        return wallRectangle;
    }

    public Circle getHelipadWall() {
        return helipadWall;
    }

}

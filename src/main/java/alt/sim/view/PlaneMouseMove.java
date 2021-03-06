package alt.sim.view;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import alt.sim.controller.engine.GameEngineImpl;
import alt.sim.model.ImageClassification;
import alt.sim.model.PlaneMovement;
import alt.sim.model.plane.Plane;
import javafx.animation.Animation.Status;
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * Controlling the Position of the Plane in the Map using MouseEvent controls.
 *
 */
public class PlaneMouseMove extends Application {

    private PlaneMovement planeMove;
    private Plane p1;

    private PathTransition pathTransition = new PathTransition();
    private List<Point2D> planeCoordinates;
    private Path path = new Path();

    private boolean mouseClicked = false;
    private int contatore = 0;

    // TEST
    private static final int PLANE_HEAD_MARGIN = 15;

    private Point2D[] coordinatesTest;

    // for 2) part
    private Point2D startPoint;
    private Point2D middlePoint;
    private Point2D finalPoint;

    // for 3) part
    private Point2D firstPoint;
    private Point2D secondPoint;
    private double tanAlfa;
    private double angularCoefficent;


    public PlaneMouseMove() {
        p1 = new Plane(ImageClassification.AIRPLANE);
        planeMove = new PlaneMovement();
    }

    /**
     *
     */
    @Override
    public void start(final Stage stage) throws Exception {
        Pane paneRoot = new Pane();
        Canvas canvas = new Canvas(MainPlaneView.getScreenWidth(), MainPlaneView.getScreenHeight());

        PathTransition pathTransition = new PathTransition();
        GameEngineImpl engine = new GameEngineImpl(this);

        // TEST adding static coordinates
        /*
         * coordinatesTest = new Point2D[] { new Point2D(0, 0), new Point2D(196, 60),
         * new Point2D(341, 138), new Point2D(601, 369), new Point2D(773, 119), new
         * Point2D(910, 161), new Point2D(953, 123), new Point2D(1144, 50), new
         * Point2D(800, 400), new Point2D(500, 200), new Point2D(500, 300), };
         */

        class ThreadEngine implements Runnable {

            @Override
            public void run() {
                engine.mainLoop();
            }
        }

        Thread t = new Thread(new ThreadEngine());
        t.start();

        //Create ArrayList for manage the coordinates of Plane
        planeCoordinates = new ArrayList<Point2D>();

        // Calculating the Proportion --> (Image:Screen)
        p1.getSpritePlane().getImageSpriteResized().resizeImageSprite(true);

        // View Plane demonstrating:
        paneRoot.resize(MainPlaneView.getScreenWidth(), MainPlaneView.getScreenHeight());

        // Insert Plane test into view:
        paneRoot.getChildren().add(p1.getSpritePlane().getImageSpriteResized().getImageSprite());

        // Section Canvas
        paneRoot.getChildren().addAll(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        GraphicsContext gcOval = canvas.getGraphicsContext2D();

        //-------------------------------------------------------------------
        // 1)

        //TEST Drawing the line path
        /*
         * gc.lineTo(0, 0); gcOval.fillOval(0, 0, 5, 5); gc.lineTo(196, 60);
         * gcOval.fillOval(196, 60, 5, 5); gc.lineTo(341, 138); gcOval.fillOval(341,
         * 138, 5, 5); gc.lineTo(601, 369); gcOval.fillOval(601, 369, 5, 5);
         * gc.lineTo(773, 119); gcOval.fillOval(773, 119, 5, 5); gc.lineTo(910, 161);
         * gcOval.fillOval(910, 161, 5, 5); gc.lineTo(953, 123); gcOval.fillOval(953,
         * 123, 5, 5); gc.lineTo(1144, 50); gcOval.fillOval(1144, 50, 5, 5);
         * 
         * // Torna indietro Test verso il Basso gc.lineTo(800, 400);
         * gcOval.fillOval(800, 400, 5, 5);
         * 
         * // Torna indietro Test verso Alto gc.lineTo(500, 200); gcOval.fillOval(500,
         * 200, 5, 5);
         * 
         * // Aereo verso il Basso gc.lineTo(500, 300); gcOval.fillOval(500, 300, 5, 5);
         * 
         * gc.setLineWidth(1); gc.stroke(); gcOval.setFill(Color.RED);
         */

        //-------------------------------------------------------------------
        // 2)

         //planeHead = new Point2D(p1.getImagePlane().getX)
        //for (int i = 0; i < coordinatesTest.length; i++) {
            //getAngleRotation(p1, coordinatesTest[4], new Point2D(coordinatesTest[3].getX(), 0));

            //this.finalPoint = new Point2D(coordinatesTest[4].getX(), coordinatesTest[3].getY());
            //getAngleRotation(p1, centerImagePositionInGame(p1, coordinatesTest[3]), coordinatesTest[4], finalPoint);

            //p1.getImagePlane().setLayoutX(coordinatesTest[3].getX());
            //p1.getImagePlane().setLayoutY(coordinatesTest[3].getY());

            //centerImagePositionInGame(p1, coordinatesTest[4].getX(), coordinatesTest[4].getY());

        //}

        //-------------------------------------------------------------------
        // 3) Calculating Angle with the 'm' function

        /*
         * for (int i = 0; i < coordinatesTest.length - 1; i++) { this.firstPoint = new
         * Point2D(coordinatesTest[i].getX(), coordinatesTest[i].getY());
         * this.secondPoint = new Point2D(coordinatesTest[i + 1].getX(),
         * coordinatesTest[i + 1].getY());
         * 
         * tanAlfa = (secondPoint.getY() - firstPoint.getY()) / (secondPoint.getX() -
         * firstPoint.getX()); angularCoefficent = Math.toDegrees(Math.atan(tanAlfa));
         * 
         * System.out.println("Angular coefficent: " + angularCoefficent); }
         */
        //-------------------------------------------------------------------
        // 4) Positioning Plane with Angle inclination for testing

        /*
         * p1.getImagePlane().setLayoutX(coordinatesTest[9].getX());
         * p1.getImagePlane().setLayoutY(coordinatesTest[9].getY());
         * 
         * if (coordinatesTest[8].getX() < coordinatesTest[7].getX()) {
         * p1.getImagePlane().setRotate(180 + (33.69)); }
         * 
         * // Caso specifico aereo a 90° o 180° if (coordinatesTest[9].getX() ==
         * coordinatesTest[10].getX() && coordinatesTest[9].getY() <
         * coordinatesTest[10].getX() ) { p1.getImagePlane().setRotate(90); }
         * 
         * if (coordinatesTest[9].getX() == coordinatesTest[10].getX() &&
         * coordinatesTest[9].getY() > coordinatesTest[10].getX()) {
         * p1.getImagePlane().setRotate(270); }
         * 
         * p1.getImagePlane().setLayoutX(getPlaneHeadPosition(p1).getX());
         * p1.getImagePlane().setLayoutY(getPlaneHeadPosition(p1).getY());
         */


        //-------------------------------------------------------------------

        EventHandler<MouseEvent> handlerMouseMoved = new EventHandler<MouseEvent>() {

            @Override
            public void handle(final MouseEvent event) {
                gc.moveTo(event.getX(), event.getY());
            }
        };


        EventHandler<MouseEvent> handlerMouseClicked = new EventHandler<MouseEvent>() {

             @Override
             public void handle(final MouseEvent event) {
                /*
                 * PathTransition pathTransitionCopy = engine.getPathTransition();
                 * ReadOnlyObjectProperty<Status> animationStatus =
                 * pathTransitionCopy.statusProperty();
                 * 
                 * if (animationStatus.getValue() == Status.RUNNING) {
                 * //System.out.println("Animazione on Running");
                 * 
                 * planeCoordinates.clear(); engine.setCoordinate(planeCoordinates);
                 * engine.setBlocked(true); engine.stopAnimation(); pathTransitionCopy.stop(); }
                 */

                 if (planeCoordinates.size() < PlaneMovement.COORDINATES_LIMIT) {
                     planeCoordinates.add(new Point2D(event.getX(), event.getY()));

                     gc.lineTo(event.getX(), event.getY());
                     gc.setStroke(Paint.valueOf("green"));
                     gc.stroke();
                 }
                 
                 PathTransition pathTransitionCopy = engine.getPathTransition();
                 ReadOnlyObjectProperty<Status> animationStatus = pathTransitionCopy.statusProperty();
                 
                 if (animationStatus.getValue() == Status.RUNNING) {
                     //System.out.println("Animazione on Running"); planeCoordinates.clear();
                     pathTransitionCopy.stop();
                     engine.setBlocked(true);
                 }

             }
         };

         EventHandler<MouseEvent> handlerMouseDragged = new EventHandler<MouseEvent>() {

             @Override
             public void handle(final MouseEvent event) {
                 PathTransition pathTransitionCopy = engine.getPathTransition();
                 ReadOnlyObjectProperty<Status> animationStatus = pathTransitionCopy.statusProperty();

                 // 2)
                 // Blocca il ciclo in GameEngineImpl per resettare le nuove coordinate.
                 if (animationStatus.getValue() == Status.RUNNING) {
                     //System.out.println("Animazione on Running"); planeCoordinates.clear();
                     engine.setBlocked(true);
                     engine.setStart(false);
                     engine.stopAnimation(); 
                     pathTransitionCopy.stop(); 
                 }

                 if (planeCoordinates.size() < PlaneMovement.COORDINATES_LIMIT) {
                      planeCoordinates.add(new Point2D(event.getX(), event.getY()));
                      gc.lineTo(event.getX(), event.getY());
                      gc.setStroke(Paint.valueOf("green"));
                      gc.stroke();
                 }
           }
         };

           EventHandler<MouseEvent> handlerMouseReleased = new EventHandler<MouseEvent>() {

               @Override public void handle(final MouseEvent event) {
                   /*
                    * PathTransition pathTransitionCopy = engine.getPathTransition();
                    * ReadOnlyObjectProperty<Status> animationStatus =
                    * pathTransitionCopy.statusProperty();
                    * 
                    * if (animationStatus.getValue() == Status.RUNNING) {
                    * //System.out.println("Animazione on Running");
                    * 
                    * planeCoordinates.clear(); engine.setCoordinate(planeCoordinates);
                    * engine.setBlocked(true); engine.stopAnimation(); pathTransitionCopy.stop(); }
                    */
                   /*
                    * PathTransition pathTransitionCopy = engine.getPathTransition();
                    * ReadOnlyObjectProperty<Status> animationStatus =
                    * pathTransitionCopy.statusProperty();
                    * 
                    * if (animationStatus.getValue() == Status.STOPPED) {
                    * planeMove.printPlaneCoordinates();
                    * planeMove.setPlaneCoordinatesList(planeCoordinates);
                    * engine.setCoordinate(planeMove.getPlaneCoordinatesList());
                    * engine.setBlocked(false); engine.setStart(true);
                    * 
                    * }
                    */

                    // 1)
                    // Quando si rilascia il Mouse, le coordinate campionate vengono salvate e passate al
                    // GameEngineImpl.


                   PathTransition pathTransitionCopy = engine.getPathTransition();
                   ReadOnlyObjectProperty<Status> animationStatus = pathTransitionCopy.statusProperty();

                   if (animationStatus.getValue() == Status.RUNNING) {
                         engine.setBlocked(true); 
                         engine.setStart(false); 
                         engine.stopAnimation();
                    }

                    System.out.println("");
                    System.out.println("Lunghezza planeCoordinates: " + planeCoordinates.size());
                    //Trying to clear the List of Coordinates from duplicates
                    planeMove.setPlaneCoordinatesList(clearListCoordinates(planeCoordinates));
                    planeMove.printPlaneCoordinates();

                    // 3)
                    // Check if animationIsRunning
                    System.out.println("Check if animationIsRunning: " + engine.getAnimationStatus());

                    engine.setCoordinate(planeMove.getPlaneCoordinatesList());
                    engine.setStart(true);
                } 
           };

        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, handlerMouseClicked);
        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, handlerMouseDragged);
        canvas.addEventHandler(MouseEvent.MOUSE_RELEASED, handlerMouseReleased);
        canvas.addEventHandler(MouseEvent.MOUSE_MOVED, handlerMouseMoved);

        Scene scene = new Scene(paneRoot, MainPlaneView.getScreenWidth(), MainPlaneView.getScreenHeight());
        stage.setScene(scene);
        stage.show();
    }

    /*
     * public double getAngleInclination(final Point2D firstPoint, final Point2D
     * secondPoint) { this.firstPoint = firstPoint; this.secondPoint = secondPoint;
     * 
     * tanAlfa = (secondPoint.getY() - firstPoint.getY()) / (secondPoint.getX() -
     * firstPoint.getX()); angularCoefficent = Math.toDegrees(Math.atan(tanAlfa));
     * 
     * //System.out.println("Angular coefficent: " + angularCoefficent);
     * 
     * return angularCoefficent; }
     */
    public Point2D getPlaneHeadPosition(final Plane planeInGame) {
       // double upperX = (planeInGame.getImagePlane().getLayoutX() + PLANE_HEAD_MARGIN);
        double upperX = (planeInGame.getImagePlane().getLayoutX());
        double upperY = planeInGame.getImagePlane().getLayoutY();
        double xHead;
        double yHead;

        xHead = upperX - planeInGame.getImagePlane().getFitWidth();
        yHead = upperY - (planeInGame.getImagePlane().getFitHeight() / 2);

        //System.out.println("getLayoutX + : " + (planeInGame.getImagePlane().getLayoutX() + 15));
        //System.out.println("upperX && upperY: " + upperX + " , " +  upperY);
        //System.out.println("centering: " + (upperX - planeInGame.getImagePlane().getFitWidth()) + " , " + (planeInGame.getImagePlane().getFitHeight() / 2));

        return new Point2D(xHead, yHead);
    }

    /*
     * private void getAngleRotation(final Plane planeInGame, final Point2D
     * startPoint, final Point2D middlePoint, final Point2D finalPoint) {
     * this.startPoint = startPoint; this.middlePoint = middlePoint; this.finalPoint
     * = finalPoint;
     * 
     * //this.planeHead = getPlaneHeadPosition(planeInGame);
     * 
     * if (getAngleValue(new Point2D(341, 138), new Point2D(601, 369), new
     * Point2D(773, 119)) < 90) { planeInGame.getImagePlane().setRotate(90 +
     * startPoint.angle(middlePoint, finalPoint)); } else {
     * planeInGame.getImagePlane().setRotate(startPoint.angle(middlePoint,
     * finalPoint)); }
     * 
     * System.out.println("Angle Rotation: " + startPoint.angle(middlePoint,
     * finalPoint));
     * 
     * }
     */

    /*
     * private double getAngleValue(final Point2D startPoint, final Point2D
     * middlePoint, final Point2D finalPoint) { return startPoint.angle(middlePoint,
     * finalPoint); }
     */

    /*
     * private void centerImagePositionInGame(final Plane planeInGame, final
     * MouseEvent event) { //Insert Center Image when click
     * planeInGame.getImagePlane().setLayoutX(event.getX() -
     * (planeInGame.getImagePlane().getFitWidth() / 2));
     * planeInGame.getImagePlane().setLayoutY(event.getY() -
     * (planeInGame.getImagePlane().getFitHeight() / 2)); }
     */

    /*
     * public Point2D centerImagePositionInGame(final Plane planeInGame, final
     * Point2D finalPoint) { //Insert Center Image when click
     * planeInGame.getImagePlane().setLayoutX(finalPoint.getX() -
     * (planeInGame.getImagePlane().getFitWidth() / 2));
     * planeInGame.getImagePlane().setLayoutY(finalPoint.getY() -
     * (planeInGame.getImagePlane().getFitHeight() / 2));
     * 
     * return new Point2D(planeInGame.getImagePlane().getLayoutX(),
     * planeInGame.getImagePlane().getLayoutY()); }
     */


    private List<Point2D> clearListCoordinates(final List<Point2D> planeCoordinates) {
        Set<Point2D> s = new LinkedHashSet<>(planeCoordinates);
        List<Point2D> copyListCleaned = new ArrayList<Point2D>(s);
        //System.out.println("Lunghezza copyListCleaned: " + copyListCleaned.size());

        return copyListCleaned;
    }

    private void drawShapes(final GraphicsContext gc, final double x, final double y) {
        //System.out.println("Lunghezza in drawShapes: " + planeMove.getPlaneCoordinatesList().size() + " < " + PlaneMovement.COORDINATES_LIMIT);

            //System.out.println("entrato in drawShapes = ");

            if (planeCoordinates.size() < PlaneMovement.COORDINATES_LIMIT) {
                gc.lineTo(x, y);
                gc.setStroke(Paint.valueOf("green"));
                gc.stroke();
            }
    }

    public static void main(final String[] args) {
        launch(args);
    }

    public PlaneMovement getPlaneMovement() {
        return this.planeMove;
    }

    public Plane getPlane() {
        return this.p1;
    }

    /*
     * public void startTransiction(final Double x, final Double y) {
     * path.getElements().add(new MoveTo(x, y));
     * pathTransition.setDuration(Duration.millis(400));
     * pathTransition.setPath(path);
     * pathTransition.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
     * pathTransition.play(); }
     */
}

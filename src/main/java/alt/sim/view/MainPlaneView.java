package alt.sim.view;


import alt.sim.model.ImageResized;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * View class for show the Plane.
 */
public class MainPlaneView extends Application {
    /** Screen width of the view, calling Screen class that return the size of the Primary screen.  */
    private static final double SCREEN_WIDTH = Screen.getPrimary().getBounds().getWidth();
    /** Screen height of the view.  */
    private static final double SCREEN_HEIGHT = Screen.getPrimary().getBounds().getHeight();

    private static boolean fullScreenMode;
    private Scene scene;
    private Pane paneRoot;
    private ImageResized planeImageResized;

    public MainPlaneView() {
        this.paneRoot = new Pane();
        this.planeImageResized = new ImageResized();
        this.paneRoot.resize(SCREEN_WIDTH, SCREEN_HEIGHT);
        this.scene = new Scene(paneRoot, SCREEN_WIDTH, SCREEN_HEIGHT);

        //planeImageResized.resizeImageSprite();
        //paneRoot.getChildren().add(planeImageResized.getImageSprite());
    }

    public MainPlaneView(final double screenWidth, final double screenHeight) {
        this.paneRoot = new Pane();
        this.planeImageResized = new ImageResized(screenWidth, screenHeight);
        this.paneRoot.resize(screenWidth, screenHeight);
        this.scene = new Scene(paneRoot, SCREEN_WIDTH, SCREEN_HEIGHT);

        planeImageResized.resizeImageSprite();
        paneRoot.getChildren().add(planeImageResized.getImageSprite());
    }

    @Override
    public void start(final Stage stage) throws Exception {

        try {
            ImageResized planeImageResized = new ImageResized();
            // Calculating the Proportion --> (Image:Screen)
            //planeImageResized.resizeImageSprite();

            // View Plane demonstrating:
            //paneRoot.getChildren().add(planeImageResized.getImageSprite());
            Rectangle staticAirStripArea = new Rectangle(50, 100);
            Rectangle plane = new Rectangle (50, 50);

            plane.setFill(Paint.valueOf("BLUE"));
            staticAirStripArea.setLayoutX(150);
            staticAirStripArea.setLayoutY(100);
            staticAirStripArea.setFill(Paint.valueOf("RED"));

            //Mouse Click event
            EventHandler<MouseEvent> eventMouseClicked = new EventHandler<MouseEvent>() { 
                @Override 
                public void handle(final MouseEvent e) {
                   plane.setLayoutX(e.getX());
                   plane.setLayoutY(e.getY());
                   
                   
                   //Check collison Plane with AirStrip
                   if (staticAirStripArea.getBoundsInParent().intersects(plane.getBoundsInParent())) {
                       System.out.println("AirStrip collided");
                   }
                } 
            };

            //Registering the event filter 
            paneRoot.addEventFilter(MouseEvent.MOUSE_CLICKED, eventMouseClicked);

            paneRoot.getChildren().addAll(staticAirStripArea, plane); 
            stage.setScene(scene);
            //set the Screen in FullScreen mode:
            stage.setFullScreen(MainPlaneView.fullScreenMode);
            stage.show();

        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Launch a standalone application calling the JavaFx mainThread.
     * @param args the command line arguments.
     */
    public static void main(final String[] args) {
        launch(args);
    }

    public static double getScreenWidth() {
        return SCREEN_WIDTH;
    }

    public static double getScreenHeight() {
        return SCREEN_HEIGHT;
    }

    public static void setFullScreenTrue() {
        fullScreenMode = true;
    }

    public static void setFullScreenFalse() {
        fullScreenMode = false;
    }

    public static boolean isFullScreen() {
        return fullScreenMode;
    }

    public Pane getPane() {
        return this.paneRoot;
    }

    public Scene getScene() {
        return this.scene;
    }
}

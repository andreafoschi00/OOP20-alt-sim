package alt.sim.view;

import alt.sim.controller.engine.GameEngineImpl;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * View class for show the Plane.
 */
public class MainPlaneView extends Application {
    /** Screen width of the view, calling Screen class that return the size of the Primary screen.  */
    private static final double SCREEN_WIDTH = (Screen.getPrimary().getBounds().getWidth() / MainPlaneView.ASPECT_RATIO_DIVISION);
    /** Screen height of the view.  */
    private static final double SCREEN_HEIGHT = (Screen.getPrimary().getBounds().getHeight() / MainPlaneView.ASPECT_RATIO_DIVISION);
    /** Number used to divide the Screen size. */
    private static final double ASPECT_RATIO_DIVISION = 1.5;

    @Override
    public void start(final Stage stage) throws Exception {
        try {
            Pane paneRoot = new Pane();
            GameEngineImpl engine = new GameEngineImpl();
            //ImageResized planeImageResized = new ImageResized("images/map_components/airplane.png");
            //Plane p1 = new Plane("images/map_components/airplane.png");
            // Calculating the Proportion --> (Image:Screen)
            //planeImageResized.resizeImageSprite();
            class ThreadMain implements Runnable{
                @Override
                public void run() {
                    engine.mainLoop();
                }
            }
            Thread t = new Thread(new ThreadMain());
            t.start();
            // View Plane demonstrating:
            paneRoot.resize(SCREEN_WIDTH, SCREEN_HEIGHT);
            //paneRoot.getChildren().add(planeImageResized.getImageSprite());
            // Insert Plane test into view:
            paneRoot.getChildren().add(engine.getP1().getImagePlane());

            Scene scene = new Scene(paneRoot, SCREEN_WIDTH, SCREEN_HEIGHT);
            stage.setScene(scene);
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
}

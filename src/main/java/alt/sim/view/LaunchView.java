package alt.sim.view;

import alt.sim.model.ImageResized;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class LaunchView extends Application {
    /** Screen width of the view, calling Screen class that return the size of the Primary screen.  */
    private static final double LAUNCH_SCREEN_WIDTH = (Screen.getPrimary().getBounds().getWidth() / LaunchView.ASPECT_RATIO_DIVISION);
    /** Screen height of the view.  */
    private static final double LAUNCH_SCREEN_HEIGHT = (Screen.getPrimary().getBounds().getHeight() / LaunchView.ASPECT_RATIO_DIVISION);

    private static final double ASPECT_RATIO_DIVISION = 3;

    private static final double NEW_WINDOW_WIDTH = 1000;

    private static final double NEW_WINDOW_HEIGHT = 1000;

    @Override
    public void start(final Stage primaryStage) throws Exception {
        Button btnNewGame = new Button("New Game");
        Pane paneRoot = new Pane();
        //ImageResized planeImageResized = new ImageResized();

        // View Plane demonstrating:
        paneRoot.resize(LAUNCH_SCREEN_WIDTH, LAUNCH_SCREEN_HEIGHT);
        paneRoot.getChildren().addAll(btnNewGame);

        Scene primaryScene = new Scene(paneRoot, LAUNCH_SCREEN_WIDTH, LAUNCH_SCREEN_HEIGHT);
        primaryStage.setScene(primaryScene);
        //set the Screen in FullScreen mode:
        primaryStage.show();

        //Button NewGame event for launch new window
        btnNewGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent event) {

                try {
                    primaryStage.hide();
                    startNewGame();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void startNewGame() {
        Stage newGameStage = new Stage();
        Pane paneRootNewGame = new Pane();
        ImageResized planeImageResized = new ImageResized(NEW_WINDOW_WIDTH, NEW_WINDOW_HEIGHT);

        paneRootNewGame.resize(LAUNCH_SCREEN_WIDTH, LAUNCH_SCREEN_HEIGHT);
        paneRootNewGame.getChildren().add(planeImageResized.getImageSprite());
        //resize planeImage to bounds of the window
        planeImageResized.resizeImageSprite();

        Scene sceneNewGame = new Scene(paneRootNewGame, NEW_WINDOW_WIDTH, NEW_WINDOW_HEIGHT);

        newGameStage.setScene(sceneNewGame);
        newGameStage.show();
    }

    public static void main(final String[] args) {
        launch(args);
    }

}

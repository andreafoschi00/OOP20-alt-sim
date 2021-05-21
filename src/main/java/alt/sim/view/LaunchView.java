package alt.sim.view;

import alt.sim.model.ImageResized;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class LaunchView extends Application {
    /** Screen width of the view, calling Screen class that return the size of the Primary screen.  */
    private static final double LAUNCH_SCREEN_WIDTH = (Screen.getPrimary().getBounds().getWidth() / LaunchView.ASPECT_RATIO_DIVISION);
    /** Screen height of the view.  */
    private static final double LAUNCH_SCREEN_HEIGHT = (Screen.getPrimary().getBounds().getHeight() / LaunchView.ASPECT_RATIO_DIVISION);

    private static final double ASPECT_RATIO_DIVISION = 2;

    @Override
    public void start(final Stage primaryStage) throws Exception {
        Button btnNewGame = new Button("New Game");
        ToggleButton btnFullScreen = new ToggleButton("Full Screen");
        VBox vBox = new VBox();

        StackPane root = new StackPane();

        // View Plane demonstrating:
        vBox.getChildren().addAll(btnNewGame, btnFullScreen);
        vBox.setAlignment(Pos.CENTER);

        root.resize(LAUNCH_SCREEN_WIDTH, LAUNCH_SCREEN_HEIGHT);
        root.getChildren().addAll(vBox);

        Scene primaryScene = new Scene(root, LAUNCH_SCREEN_WIDTH, LAUNCH_SCREEN_HEIGHT);
        primaryStage.setScene(primaryScene);
        //set the Screen in FullScreen mode
        primaryStage.show();

        //Button NewGame event for launch new window
        btnNewGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent event) {

                try {
                    primaryStage.hide();
                    startNewGame(btnFullScreen.isSelected());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void startNewGame(final boolean isFullScreen) {
        Stage newGameStage = new Stage();
        Pane paneRootNewGame = new Pane();
        ImageResized planeImageResized = new ImageResized(LAUNCH_SCREEN_WIDTH, LAUNCH_SCREEN_HEIGHT);

        paneRootNewGame.resize(LAUNCH_SCREEN_WIDTH, LAUNCH_SCREEN_HEIGHT);
        paneRootNewGame.getChildren().add(planeImageResized.getImageSprite());
        //resize planeImage to bounds of the window
        planeImageResized.resizeImageSprite();

        Scene sceneNewGame = new Scene(paneRootNewGame, LAUNCH_SCREEN_WIDTH, LAUNCH_SCREEN_HEIGHT);

        //set the new Windows full-screen or not
        newGameStage.setFullScreen(isFullScreen);

        newGameStage.setScene(sceneNewGame);
        newGameStage.show();
    }

    public static void main(final String[] args) {
        launch(args);
    }

}

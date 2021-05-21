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
    /** Number used to divide the Screen size. */
    private static final double ASPECT_RATIO_DIVISION = 1.5;

    @Override
    public void start(final Stage primaryStage) throws Exception {
        // View components
        Button btnNewGame = new Button("New Game");
        ToggleButton btnFullScreen = new ToggleButton("Full Screen");
        VBox vBox = new VBox();
        StackPane root = new StackPane();

        vBox.getChildren().addAll(btnNewGame, btnFullScreen);
        // positioning the childs of VBox centered
        vBox.setAlignment(Pos.CENTER);

        // resizing the dimension of the root with the standard dimension of Screen
        root.resize(LAUNCH_SCREEN_WIDTH, LAUNCH_SCREEN_HEIGHT);
        root.getChildren().addAll(vBox);

        Scene primaryScene = new Scene(root, LAUNCH_SCREEN_WIDTH, LAUNCH_SCREEN_HEIGHT);
        primaryStage.setScene(primaryScene);
        primaryStage.show();

        //Button NewGame event for launch the new window
        btnNewGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent event) {

                try {
                    // shadowed the primaryStage that isn't used when we launch the newGameStage
                    primaryStage.hide();

                    // control that Screen must be Full or not
                    if (btnFullScreen.isSelected()) {
                        startNewGameFullScreen();
                    } else {
                        startNewGameNormalScreen();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /** Launch a new Window setted in normal dimension. */
    public void startNewGameNormalScreen() {
        Stage newGameStage = new Stage();
        Pane paneRootNewGame = new Pane();
        ImageResized planeImageResized;

        planeImageResized = new ImageResized(LAUNCH_SCREEN_WIDTH, LAUNCH_SCREEN_HEIGHT);
        //resize planeImage resized to the bounds of the Window
        planeImageResized.resizeImageSprite();

        paneRootNewGame.resize(LAUNCH_SCREEN_WIDTH, LAUNCH_SCREEN_HEIGHT);
        paneRootNewGame.getChildren().add(planeImageResized.getImageSprite());

        Scene sceneNewGame = new Scene(paneRootNewGame, LAUNCH_SCREEN_WIDTH, LAUNCH_SCREEN_HEIGHT);
        newGameStage.setScene(sceneNewGame);
        newGameStage.show();
    }

    /** Launch the new Window setted in Full Screen dimension. */
    public void startNewGameFullScreen() {
        Stage newGameStage = new Stage();
        Pane paneRootNewGame = new Pane();
        ImageResized planeImageResized;

        //set the new Windows size components in Full Screen
        planeImageResized = new ImageResized(Screen.getPrimary().getBounds().getWidth(), Screen.getPrimary().getBounds().getHeight());
        planeImageResized.resizeImageSprite();
        paneRootNewGame.getChildren().add(planeImageResized.getImageSprite());
        paneRootNewGame.resize(Screen.getPrimary().getBounds().getWidth(), Screen.getPrimary().getBounds().getHeight());

        Scene sceneNewGame = new Scene(paneRootNewGame, Screen.getPrimary().getBounds().getWidth(), Screen.getPrimary().getBounds().getHeight());
        newGameStage.setScene(sceneNewGame);
        //set the new Stage in Full Screen mode
        newGameStage.setFullScreen(true);
        newGameStage.show();
    }

    public static void main(final String[] args) {
        launch(args);
    }
}

package alt.sim.view;

import alt.sim.model.ImageResized;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
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

    private static final double NEW_WINDOW_WIDTH = 450;

    private static final double NEW_WINDOW_HEIGHT = 450;

    @Override
    public void start(final Stage stage) throws Exception {
        Button btnNewGame = new Button("New Game");
        Button btnExit = new Button("Exit");
        Pane paneRoot = new Pane();
        ImageResized planeImageResized = new ImageResized();

        // Calculating the Proportion --> (Image:Screen)
        planeImageResized.resizeImageSprite();

        // View Plane demonstrating:
        paneRoot.resize(LAUNCH_SCREEN_WIDTH, LAUNCH_SCREEN_HEIGHT);
        paneRoot.getChildren().addAll(btnNewGame, btnExit);

        Scene scene = new Scene(paneRoot, LAUNCH_SCREEN_WIDTH, LAUNCH_SCREEN_HEIGHT);
        stage.setScene(scene);
        //set the Screen in FullScreen mode:
        stage.show();

        //Button NewGame event for launch new window
        btnNewGame.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(final ActionEvent event) {
                Pane root = new Pane();
                try {
                    //root = FXMLLoader.load(getClass().getClassLoader().getResource("path/to/other/view.fxml"), resources);
                    MainPlaneView startedGame = new MainPlaneView();
                    //Warning public method!!!
                    startedGame.launchApplication();

                    Stage stageLaunchView = startedGame.getStage();
                    stageLaunchView.show();
            
                    // Hide this current window (if this is what you want)
                    //((Node) (event.getSource())).getScene().getWindow().hide();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        //Button Exit event for terminated the window
        btnExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent event) {
                Node newWindow;

                Stage stage = (Stage) btnExit.getScene().getWindow();
                stage.close();
            }
        });
    }

    public static void main(final String[] args) {
        launch(args);
    }

}

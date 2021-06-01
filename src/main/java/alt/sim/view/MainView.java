package alt.sim.view;

import alt.sim.model.plane.Plane;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainView extends Application {

    private static final int PLANE_DIMENSION = 50;
    private static final int SCREEN_WIDTH = 900;
    private static final int SCREEN_LENGTH = 1600;

    @Override
    public void start(final Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("layouts/Seaside.fxml"));
        Pane root = loader.load();

        Seaside controller = loader.getController();
        Plane plane1 = controller.getPlane();



        root.getChildren().add(plane1.getImagePlane());
        primaryStage.setTitle("Prova");
        primaryStage.setScene(new Scene(root, SCREEN_LENGTH, SCREEN_WIDTH));
        primaryStage.show();
    }

    public static void main(final String[] args) {
        launch(args);
    }
}

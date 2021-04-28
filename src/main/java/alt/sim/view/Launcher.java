package alt.sim.view;

import java.awt.Dimension;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
// import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Class that creates the Menu.
 *
 */
public final class Launcher extends Application {

    @Override
    public void start(final Stage primaryStage) throws IOException {
        /*
         * Calculate scene size
         */
        final Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        final double width = screenSize.getWidth() / 3;
        final double height = screenSize.getHeight() / 2.5;
        /*
         * Load Menu fxml.
         */
        final Parent root = FXMLLoader.load(ClassLoader.getSystemResource("MainView.fxml"));
        /*
         * Create MenuView
         */
        final Scene scene = new Scene(root, width, height);
        primaryStage.setScene(scene);
        // primaryStage.getIcons().add(new Image(ClassLoader.getSystemResource("images/icon.png").toExternalForm()));
        primaryStage.setTitle("Rogue");
        primaryStage.setResizable(true);
        primaryStage.show();
    }

    /**
     * 
     * @param args unused.
     */
    public static void main(final String[] args) {
        launch();
    }

}

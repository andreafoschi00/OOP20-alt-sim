package alt.sim.model;

import alt.sim.view.MainPlaneView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Class for managing the Image of the Plane and calculate his ProportionImage.
 */
public class ImageResized implements ImageResizedInterface {

    /** URL Path of the image to load. */
    private static final String URL_SPRITE = ClassLoader
            .getSystemResource("images/map_components/airplane.png")
            .toExternalForm();

    private ProportionImage proportionImageResized;
    private Image loadImage;
    private ImageView imageSprite;
    private double screenWidth;
    private double screenHeight;

    /**
     * Initializes a newly created ImageResized object.
     */
    public ImageResized() {
        this.loadImage = new Image(URL_SPRITE);
        this.imageSprite = new ImageView(loadImage);
        this.screenWidth = MainPlaneView.getScreenWidth();
        this.screenHeight = MainPlaneView.getScreenHeight();

        double widthImage = loadImage.getWidth();
        double heightImage = loadImage.getHeight();

        proportionImageResized = new ProportionImage();
        proportionImageResized.setRatioImage(new Ratio(widthImage, heightImage));
        proportionImageResized.setRatioScreen(new Ratio(screenWidth, screenHeight));
    }

    public ImageResized(final double screenWidthResized, final double screenHeightResized) {
        this();
        this.screenWidth = screenWidthResized;
        this.screenHeight = screenHeightResized;

        proportionImageResized.setRatioScreen(new Ratio(screenWidthResized, screenHeightResized));
    }

    @Override
    public void resizeImageSprite() {
        double widthResized = 0;
        double heightResized = 0;

        this.proportionImageResized.renderingProportionImage();
        widthResized = proportionImageResized.getResultOfProportion().getAntecedent();
        heightResized = proportionImageResized.getResultOfProportion().getConsequent();
        this.imageSprite.setFitWidth(widthResized);
        this.imageSprite.setFitHeight(heightResized);
    }

    /**
     * @return the imageSprite proportioned to the Screen.
     */
    public ImageView getImageSprite() {
        return this.imageSprite;
    }

    public double getScreenWidth() {
        return this.screenWidth;
    }

    public double getScreenHeight() {
        return this.screenHeight;
    }

    public void setScreenWidth(final double screenWidth) {
        this.screenWidth = screenWidth;
    }

    public void setScreenHeight(final double screenHeight) {
        this.screenHeight = screenHeight;
    }
}

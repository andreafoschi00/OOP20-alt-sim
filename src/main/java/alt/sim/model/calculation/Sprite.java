package alt.sim.model.calculation;

import alt.sim.view.MainPlaneView;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;

/**
 *  Describes the Sprite entity, rather than the rappresentation of a dinamic object in game (Plane, Airstrip).
 *
 *  it'll have:
 *  -   A background image,
 *  -   Coordinates x, y for the position in the Map,
 *  -   Width and height for the view rendering.
 *
 */
public class Sprite {

    /** path of the image location that is showed in the class used. */
    //private static String urlSprite;

    //Aggiungiamo questo campo di TEST
    private ImageSprite imageSpriteResized;
    //private Point2D point;
    private double x;
    private double y;

    /** 
     * @param urlSprite contains url of the image to load
     * @param isPreserveRatio specific if the preserveRatio of the image is active
     */
    public Sprite(final String urlSprite, final boolean isPreserveRatio) {
        this.x = 0;
        this.y = 0;

        imageSpriteResized = new ImageSprite(urlSprite, MainPlaneView.getScreenWidth(), MainPlaneView.getScreenHeight(), isPreserveRatio);
    }

    public Sprite(final String urlSprite) {
        this.x = 0;
        this.y = 0;

        imageSpriteResized = new ImageSprite(urlSprite);
    }

    public Sprite(final Point2D positionSprite) {
        this.x = positionSprite.getX();
        this.y = positionSprite.getY();

    }

    /**
     * @param imageSpriteToLoad to add in the imageSprite
     * @param point where place the Sprite 
     */
    public Sprite(final Image imageSpriteToLoad, final Point2D point) {
        //this.point = point;

        this.x = point.getX();
        this.y = point.getY();
    }

    public ImageSprite getImageSpriteResized() {
        return this.imageSpriteResized;
    }

    public void setImageSpriteResized(final String newUrlImage) {
        this.imageSpriteResized.setImageSprite(newUrlImage);
    }

    /*
     * public void setPoint2D(final Point2D point) { this.point = point; }
     */

    public void setX(final double x) {
        this.x = x;
    }

    public void setY(final double y) {
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public Point2D getPoint() { 
        return new Point2D(this.getX(), this.getY()); 
    }

    /*
     * public static void setURLSprite(final String url) { Sprite.urlSprite =
     * ClassLoader.getSystemResource(url).toExternalForm(); }
     */
}

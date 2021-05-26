package alt.sim.controller.engine;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import alt.sim.model.plane.Plane;
import javafx.geometry.Point2D;

public class GameEngineImpl implements GameEngine {

    private static final long PERIOD = 400L;
    private Plane p1;
    private List<Point2D> points;
    private Iterator<Point2D> pointIterator;

    public GameEngineImpl() {
        p1 = new Plane("images/map_components/airplane.png");
        points = new LinkedList<>() {{
                add(new Point2D(149, 149));
                add(new Point2D(200, 200));
                add(new Point2D(249, 249));
                }};
        pointIterator = points.iterator();
    }

    @Override
    public void mainLoop() throws IllegalArgumentException {
        long lastTime = System.currentTimeMillis();
        while (true) {
            long current = System.currentTimeMillis();
            int elapsed = (int) (current - lastTime);
            processInput();
            update(elapsed);
            render();
            try {
                waitForNextFrame(current);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lastTime = current;
        }
    }
    /**
     * Calculates how many milliseconds has to wait for next frame.
     * @param current
     * @throws InterruptedException
     * @throws IllegalArgumentException
     */
    protected void waitForNextFrame(final long current) throws InterruptedException, IllegalArgumentException {
        long dt = System.currentTimeMillis() - current;
        if (dt < PERIOD) {
            try {
                Thread.sleep(PERIOD - dt);
            } catch (IllegalArgumentException ex) {
                ex.printStackTrace();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }


    @Override
    public void processInput() {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(final int elapsed) {
        if (pointIterator.hasNext()) {
            p1.setPoint(pointIterator.next());
        }
    }

    @Override
    public void render() {
        p1.getImagePlane().setLayoutX(p1.getSpritePlane().getPoint().getX());
        p1.getImagePlane().setLayoutY(p1.getSpritePlane().getPoint().getY());
    }

    public Plane getP1() {
        return p1;
    }
}

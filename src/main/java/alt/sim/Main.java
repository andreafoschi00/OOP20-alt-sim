package alt.sim;

import java.io.IOException;

import alt.sim.view.Launcher;

/**
 * Class that invokes {@link Launcher}.
 *
 */
public final class Main {

    private Main() { }

    /**
     * 
     * @param args unused.
     */
    public static void main(final String[] args) throws IOException {
        Launcher.main(args);
    }

}

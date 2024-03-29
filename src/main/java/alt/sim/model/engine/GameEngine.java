package alt.sim.model.engine;

public interface GameEngine {

    /**
     * Capture frames of view once every "Period".
     */
    void mainLoop();
    /**
     * Detect the action executed by the mouse.
     */
    void processInput();
    /**
     * Update model state following input commands.
     * @param elapsed time
     */
    void update(int elapsed);
    /**
     * Update view interface.
     */
    void render();
    /**
     * Initialize the launch of game.
     */
    void initGame();
}

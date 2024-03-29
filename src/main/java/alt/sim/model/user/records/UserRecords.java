package alt.sim.model.user.records;

import alt.sim.model.user.User;

import java.io.IOException;

public interface UserRecords {

    /**
     * Adds user to file.
     * @param user to add to records
     */
    void addUser(User user) throws IOException;

    /**
     * Checks if user name is already present in the file.
     * @param name to check existence
     * @return true if present in records
     */
    boolean isPresent(String name) throws IOException;

    /**
     * Updates user score when game is over.
     * @param name of the user
     * @param score to update
     * @throws IOException if file does not exist
     */
    void updateScore(String name, int score) throws IOException;
}

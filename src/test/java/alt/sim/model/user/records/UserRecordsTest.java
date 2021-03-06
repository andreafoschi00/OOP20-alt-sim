package alt.sim.model.user.records;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import alt.sim.model.user.UserImpl;
import alt.sim.model.user.records.RecordsFolder.RecordsPath;
import alt.sim.model.user.validation.RecordsValidation;

public class UserRecordsTest {


      private final String user1 = "Paolo";
      private final String user2 = "Luca";
      private UserRecordsImpl userRecords = new UserRecordsImpl();
      private static final Path USER_RECORDS_FILE_PATH = Path.of(RecordsPath.USER_RECORDS_FILE_PATH.getPath());

      // static modifier REQUIRED by BeforeAll tag;
      // to remove static, should annotate class with tag
      // TestInstance(Lifecycle.PER_CLASS)
      @BeforeAll
      public static void initialize() throws IOException {
          if (Files.exists(USER_RECORDS_FILE_PATH)) {
              System.out.println("File exists");
          } else {
              System.out.println("File does not exist. I'm creating it now for you!");
              new RecordsValidation().userRecordsFileValidation();
          }
      }

      @BeforeEach
      public void add() throws IOException {
          this.userRecords.addUser(new UserImpl(user1, 0));
          this.userRecords.addUser(new UserImpl(user2, 0));
      }

      @Test
      public void isNameTaken() throws IOException {
          assertEquals(true, this.userRecords.isPresent(user1));
      }
}

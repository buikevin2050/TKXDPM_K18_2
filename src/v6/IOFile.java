package v6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class IOFile implements Saving {
    private static final Path RESULT_FILE = Path.of("result.txt");

    @Override
    public void save(double result) {
        String record = "Result: " + result + System.lineSeparator();
        try {
            Files.writeString(
                    RESULT_FILE,
                    record,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.WRITE,
                    StandardOpenOption.APPEND);
            System.out.println("Result appended to " + RESULT_FILE + ".");
        } catch (IOException exception) {
            System.out.println("Could not save result to " + RESULT_FILE + ": " + exception.getMessage());
        }
    }
}

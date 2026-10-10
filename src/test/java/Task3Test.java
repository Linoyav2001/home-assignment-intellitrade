import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Task3Test {

    @Test
    void testFetchGoogleHomepage() {
        String testFilePath = "google_test_output.html";
        File outputFile = new File(testFilePath);

        try {
            // Execute the method
            Task3.fetchGoogleHomepage(testFilePath);

            // Assertions
            assertTrue(outputFile.exists(), "The output file should be created.");
            assertTrue(outputFile.length() > 0, "The output file should not be empty.");

            // Optional: You could read the file and check if it contains "<html"
            String content = Files.readString(outputFile.toPath());
            assertTrue(content.toLowerCase().contains("<html"), "The content should contain an HTML tag.");

        } catch (IOException e) {
            // Fail the test if an exception is thrown
            org.junit.jupiter.api.Assertions.fail("IOException was thrown: " + e.getMessage());
        } finally {
            // Clean up: delete the file after the test finishes
            if (outputFile.exists()) {
                outputFile.delete();
            }
        }
    }
}
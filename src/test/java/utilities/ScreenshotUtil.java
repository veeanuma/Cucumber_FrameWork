package utilities;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

public class ScreenshotUtil {
    public static void captureScreenshot(WebDriver driver,  Scenario scenario) throws InterruptedException {
        // Take screenshot
        Thread.sleep(5000);
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            // Save the screenshot to a file
            Random random = new Random();
            int randomNumber = random.nextInt(100000); // Generates a random number between 0 (inclusive) and 1000 (inclusive)
            File destinationFile = new File(System.getProperty("user.dir")+"\\target\\Screenshots\\"+randomNumber+scenario.getName() + ".png");
            Files.copy(getPath(screenshot), destinationFile.toPath());

            // Attach the screenshot to the Cucumber report
            byte[] fileContent = Files.readAllBytes(destinationFile.toPath());
            scenario.attach(fileContent, "image/png", scenario.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Path getPath(File screenshot) {
        return screenshot.toPath();
    }
    public static void DeleteScreenshots() {
        String directoryPath = System.getProperty("user.dir") + "\\target\\Screenshots\\";
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        boolean deleted = file.delete();
                        if (deleted) {
                            //System.out.println(file.getName() + " deleted successfully.");
                        } else {
                            System.out.println("Failed to delete " + file.getName());
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist or is not a directory.");
        }
    }
}

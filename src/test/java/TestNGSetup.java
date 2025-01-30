import org.testng.annotations.BeforeSuite;

import static utilities.ScreenshotUtil.DeleteScreenshots;

public class TestNGSetup {
    @BeforeSuite
    public void beforeSuite() {
        // Setup code here (e.g., initializing drivers, starting servers)
        System.out.println("Before Suite - Runs once before all tests");
        DeleteScreenshots();
    }
}

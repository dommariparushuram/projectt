package Screenshotpages;

import org.openqa.selenium.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ScreenshotUtil {

    public static String takeScreenshot(WebDriver driver, String testName) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String reportDir =
                    System.getProperty("user.dir") + "/reports/";
            String screenshotDir = reportDir + "screenshots/";

            new File(screenshotDir).mkdirs();

            File dest = new File(screenshotDir + testName + ".png");

            Files.copy(
                    src.toPath(),
                    dest.toPath(),
                    StandardCopyOption.REPLACE_EXISTING
            );

            return "screenshots/" + testName + ".png";

        } catch (Exception e) {
            System.out.println("Screenshot FAILED: " + e.getMessage());
            return null;
        }
    }
}

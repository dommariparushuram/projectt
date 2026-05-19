package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    WebDriver driver;

    By closePopup = By.cssSelector("img[alt='cross']");
    By offersLink = By.cssSelector("div[style*='rgb(15, 106, 163)']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void closePopup() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(closePopup))
                    .click();
        } catch (Exception e) {
            System.out.println("Popup not found, continuing...");
        }
    }
//    public void captureHomepage() throws Exception{
//        TakesScreenshot ts=(TakesScreenshot) driver;
//        File source=ts.getScreenshotAs(OutputType.FILE);
//        File destination=new File(System.getProperty("user.dir")+"/screenshots/Home_page.png");
//        destination.getParentFile().mkdirs();
//        Files.copy(source.toPath(),destination.toPath(),StandardCopyOption.REPLACE_EXISTING);
//    }


    public void clickOffers() {
        driver.findElement(offersLink).click();
    }
}
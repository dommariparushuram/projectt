package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.OffersPage;
import Screenshotpages.HolidaysAndScreenshotUtil;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class YatraTest extends BaseTest {

    HomePage home;
    OffersPage offers;
    String parent;

    @Test(priority = 1)
    public void openOffersPage() {

        home = new HomePage(driver);
        offers = new OffersPage(driver);

        home.closePopup();
        parent = driver.getWindowHandle();
        home.clickOffers();
        offers.switchToOffersWindow(parent);
    }

    @Test(priority = 2, dependsOnMethods = "openOffersPage")
    public void validateOffersTitle() {

        SoftAssert soft = new SoftAssert();
        soft.assertEquals(
                offers.getTitle(),
                "Domestic Flights Offers | Deals on Domestic Flight Booking | Yatra.com",
                "Title mismatch"
        );
        soft.assertAll();
    }

    @Test(priority = 3, dependsOnMethods = "openOffersPage")
    public void validateBannerText() {

        SoftAssert soft = new SoftAssert();
        soft.assertEquals(
                offers.getBanner(),
                "Great Offers & Amazing Deals",
                "Banner mismatch"
        );
        soft.assertAll();
    }

    @Test(priority = 4, dependsOnMethods = "openOffersPage")
    public void validateExcelAndHolidays() throws Exception {

        YatraExcelValidation.validateOffersPage(driver);
        HolidaysAndScreenshotUtil.captureAndListHolidays(driver, parent);
    }
}
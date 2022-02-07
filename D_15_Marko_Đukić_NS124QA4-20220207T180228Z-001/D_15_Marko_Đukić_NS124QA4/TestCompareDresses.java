import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Dresses;

import java.io.IOException;
import java.time.Duration;

public class TestCompareDresses {
    private WebDriver wd;

    @BeforeClass
    public void initialize() throws IOException {
        System.setProperty("webdriver.chrome.driver",
                PropReader.fetchProperty("WEBDRIVER.CHROME.PATH"));
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void TestCompareDresses() throws InterruptedException {
        wd.get("http://automationpractice.com/index.php?id_category=8&controller=category");
        wd.manage().window().maximize();

        Assert.assertEquals(wd.getCurrentUrl(),"http://automationpractice.com/index.php?id_category=8&controller=category",
                "The current URL should be equal to http://automationpractice.com/index.php?id_category=8&controller=category");

        System.out.println("Add two dresses to compare.");
        Dresses dresses = new Dresses(wd);
        dresses.compareTwoDresses();

        dresses.compareTwoDresses();

        Assert.assertTrue(wd.getPageSource().contains("Printed Dress"));
        System.out.println("Printed dress is on the page.");
        Assert.assertTrue(wd.getPageSource().contains("Printed Dress"));
        System.out.println("Printed dress is on the page.");

        wd.close();
    }
}
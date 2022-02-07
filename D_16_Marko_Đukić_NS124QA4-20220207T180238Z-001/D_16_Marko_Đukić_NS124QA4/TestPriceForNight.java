import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.PriceForNights;

import java.io.IOException;
import java.time.Duration;

public class TestPriceForNight {
    private WebDriver wd;

    @BeforeClass
    public void init() {
        WebDriverManager.chromedriver().setup();
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wd.manage().window().maximize();
    }
    @Test
    public void countThePrice() throws InterruptedException {
        wd.get("https://it-255-dz-06-andjela-bojic3972.vercel.app/");
        Assert.assertEquals(wd.getCurrentUrl(), ("https://it-255-dz-06-andjela-bojic3972.vercel.app/"));

        PriceForNights pfn = new PriceForNights(wd);
        pfn.countThePrice();
        boolean cenaNocenja = wd.findElement(By.xpath("//body/app-root[1]/div[1]/div[1]/div[2]/lista-smestaja-component[1]/div[1]/smestaj-component[3]/div[1]/div[1]/div[1]/a[3]")).isDisplayed();
        Assert.assertTrue(cenaNocenja);

        wd.close();
    }
}

package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TextBox;

import java.io.IOException;
import java.time.Duration;

public class TestTextBox {
    WebDriver wd;

    @BeforeTest
    public void init() {
        WebDriverManager.chromedriver().setup();
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wd.manage().window().maximize();
        wd.get("https://demoqa.com/text-box");
    }
    @AfterTest
    public void close() throws IOException {
        wd.close();
        Runtime.getRuntime().exec("taskkill /F /IM cromedriver.exe /T");
    }
    @DataProvider(name = "dataInputer")
    public Object[][] dataInputer() {
        return new Object[][] {
                {"Cersei Lanister", "cerseilove@hotmail.com", "Casterly rock", "Kings Landing"},
                {"Sansa Stark", "sansanotvergin@gmail.com", "Kings Landing", "Winterfell"},
                {"Oberin Martel", "deathtomountain@gmail.com", "Dorne", "Dorne"},
                {"Lyana Martel", "deathtomountain@gmail.com", "Dorne", "Sunspear"}
        };
    }
    @Test(dataProvider = "dataInputer")
    public void testTextBox(String nameAndLastName, String emailAddress, String userAddress, String permAddress) {
        TextBox tb = new TextBox(wd);
        tb.inputFullName(nameAndLastName);
        tb.inputEmail(emailAddress);
        tb.inputAddress(userAddress);
        tb.inputPermAddress(permAddress);
        tb.clickSubmit();
        Assert.assertTrue(wd.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/form/div[6]/div")).isDisplayed(), "The pop-up is displayed.");
        tb.clearFields();
    }
}

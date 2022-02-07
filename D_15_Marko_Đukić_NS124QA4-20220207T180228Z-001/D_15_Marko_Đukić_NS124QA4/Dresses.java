package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Dresses {
    private WebDriver driver;

    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]")
    WebElement hoverFirstDress;

    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[3]/div[2]/a[1]")
    WebElement hoverAddToCompare;

    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[2]/div[1]")
    WebElement hoverSecondDress;

    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[2]/div[1]/div[3]/div[2]/a[1]")
    WebElement hoverAddToCompare2;

    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/div[4]/div[1]/form[1]/button[1]/span[1]")
    WebElement compareButton;

    public Dresses (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void compareTwoDresses() throws InterruptedException {
        Actions act = new Actions(driver);
        act.moveToElement(hoverFirstDress);
        act.moveToElement(hoverAddToCompare);
        act.click().build().perform();
        Thread.sleep(3000);
        act.moveToElement(hoverSecondDress);
        act.moveToElement(hoverAddToCompare2);
        act.click().build().perform();
        Thread.sleep(3000);
        compareButton.click();
    }
    public void compareDress() throws InterruptedException {
        Actions act = new Actions(driver);
        act.moveToElement(hoverFirstDress);
        act.moveToElement(hoverAddToCompare);
        act.click().build().perform();
        Thread.sleep(3000);
        compareButton.click();
    }
}

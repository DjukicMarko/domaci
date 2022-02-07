package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class PriceForNights {
    private WebDriver dr;

    @FindBy(xpath = "//body/app-root[1]/div[1]/div[1]/div[2]/lista-smestaja-component[1]/div[1]/smestaj-component[3]/div[1]/div[1]/div[1]/input[1]")
    WebElement inputBrojNoci;
    @FindBy(xpath = "//body/app-root[1]/div[1]/div[1]/div[2]/lista-smestaja-component[1]/div[1]/smestaj-component[3]/div[1]/div[1]/div[1]/a[3]")
    WebElement izracunajCenu;

    public PriceForNights(WebDriver dr) {
        this.dr = dr;
        PageFactory.initElements(dr, this);
    }
    @Test
    public void countThePrice() throws InterruptedException {
        Actions act = new Actions(dr);
        act.moveToElement(inputBrojNoci);
        inputBrojNoci.sendKeys("3");
        Thread.sleep(2000);
        izracunajCenu.click();
        Thread.sleep(2000);
    }
}

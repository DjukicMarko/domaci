package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TextBox {
    private WebDriver wd;

    public TextBox(WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(this.wd, this);
    }

    @FindBy(id = "userName")
    WebElement fullName;
    @FindBy(id = "userEmail")
    WebElement email;
    @FindBy(id = "currentAddress")
    WebElement address;
    @FindBy(id = "permanentAddress")
    WebElement permAddress;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[1]/form/div[5]/div/button")
    WebElement submit;

    public void inputFullName(String name) {
        this.fullName.sendKeys(name);
    }
    public void inputEmail(String email) {
        this.email.sendKeys(email);
    }
    public void inputAddress(String address) {
        this.address.sendKeys(address);
    }
    public void inputPermAddress(String permAddress) {
        this.permAddress.sendKeys(permAddress);
    }
    public void clickSubmit() {
        JavascriptExecutor jse2 = (JavascriptExecutor) wd;
        jse2.executeScript("arguments[0].scrollIntoView()", submit);
        submit.click();
    }
    public void clearFields() {
        fullName.clear();
        email.clear();
        address.clear();
        permAddress.clear();
    }

//    public void inputData(String userFullName, String userEmail, String userAddress, String permanentAddress) {
//        this.fullName.sendKeys(userFullName);
//        this.email.sendKeys(userEmail);
//        this.address.sendKeys(userAddress);
//        this.permAddress.sendKeys(permanentAddress);
//        this.submit.click();
//
//        String fullNameEntry = wd.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[1]/div[2]/input[1]")).getText();
//        Assert.assertTrue(fullNameEntry.contains(userFullName), "The data entered is correct.");
//    }

}

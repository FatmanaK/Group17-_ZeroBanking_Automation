package com.zerobank.pages;
//ismail 15-02-21 14:09
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css="[id='user_login']")
    public WebElement userNameInputBox;

    @FindBy(css="[id='user_password']")
    public WebElement passwordInputBox;

    @FindBy(css = "[name='submit']")
    public WebElement LoginPageSignInButton;

    @FindBy(css = "[id='details-button']")
    public WebElement advancedButton;

    @FindBy(css = "[id='proceed-link']")
    public WebElement proceedLinkButton;

    @FindBy(css = "[class='alert alert-error']")
    public WebElement alertError;


    public void login() {
        signInButton.click();
        userNameInputBox.sendKeys(ConfigurationReader.get("username"));
        passwordInputBox.sendKeys(ConfigurationReader.get("password"));
        LoginPageSignInButton.click();
        if (Driver.get().findElements(By.cssSelector("[id='details-button']")).size()==1){
            advancedButton.click();
            proceedLinkButton.click();
        }

   
}}

package com.theInternet.SpringBootSelenium.pages;

import jakarta.annotation.PostConstruct;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class LoginPage extends BasePage{
    @FindBy(how = How.ID, using = "username")
    public WebElement txtUserName;

    @FindBy(how = How.ID, using = "password")
    public WebElement textPassword;

    public void Login(String userName, String password){
        txtUserName.sendKeys(userName);
        textPassword.sendKeys(password);
        System.out.println("UserName and password " + userName + "---" + password);
    }
    public void Clicklogin(){
        System.out.println("Click login from login page");
    }
}

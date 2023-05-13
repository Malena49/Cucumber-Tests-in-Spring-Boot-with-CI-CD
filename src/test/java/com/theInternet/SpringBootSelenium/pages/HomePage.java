package com.theInternet.SpringBootSelenium.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class HomePage extends BasePage{
    @Value("${app.url}")
    private String appUrl;
    @FindBy(how = How.LINK_TEXT, using = "Form Authentication")
    public WebElement linkLogin;

    public void gotoHomePage(){
    driver.navigate().to(appUrl);
}
    public void Clicklogin(){
       linkLogin.click();
        System.out.println("Click the home page login");
    }

}

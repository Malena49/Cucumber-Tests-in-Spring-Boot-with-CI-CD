package com.theInternet.SpringBootSelenium.pages;

import jakarta.annotation.PostConstruct;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;

public class BasePage {

    @Autowired
    protected WebDriver driver;

//    @Autowired
//    protected WebDriverWait wait;


    @PostConstruct
    public void InitHomePage() {
        System.out.println("in home page");
        PageFactory.initElements(driver,this);
    }


//    public <T> void waitElement(T elementAttr) {
//        if (elementAttr
//                .getClass()
//                .getName()
//                .contains("By")) {
//            wait.until(ExpectedConditions.presenceOfElementLocated((By) elementAttr));
//        } else {
//            wait.until(ExpectedConditions.visibilityOf((WebElement) elementAttr));
//        }
//    }

    public void waitelement(By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}

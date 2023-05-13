package com.theInternet.SpringBootSelenium.cucumber;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
public class CucumberHooks {

    @Autowired
    private ApplicationContext applicationContext;
    @After
    public void tearDown() {
        this.applicationContext.getBean(WebDriver.class).quit();
    }
}

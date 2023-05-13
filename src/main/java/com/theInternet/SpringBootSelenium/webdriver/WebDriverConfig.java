package com.theInternet.SpringBootSelenium.webdriver;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


@Configuration
public class WebDriverConfig{

    @Autowired
    protected WebDriverFactory webDriverFactory;

    @Value("${activatedEnv}")
    private String env;

    @Scope("webdriverscope")
    @Bean
    public WebDriver createWebDriverInstance() {
        if (env.equals("local")) {
            return webDriverFactory.createLocalDriver();
        } else {
            return webDriverFactory.createRemoteDriver();
            //java -jar selenium-server-<version>.jar standalone
        }
    }
}

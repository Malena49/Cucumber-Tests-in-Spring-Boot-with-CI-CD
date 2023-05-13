package com.theInternet.SpringBootSelenium.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.List;


@Component
public class WebDriverFactory {
    @Value("${remote.url}")
    private URL remoteUrl;

    @Value("${browser}")
    private String browser;

    @Value("${chromedriver.path}")
    private String chromedriverPath;

    @Value("${chrome.options}")
    private List<String> chromeDriverOptions;

    @Value("${edgedriver.path}")
    private String edgedriverPath;

    @Value("${edge.options}")
    private List<String> edgeDriverOptions;

    public WebDriver createLocalDriver() {
        switch (browser) {
            case "chrome" -> {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments(chromeDriverOptions);
                WebDriverManager.chromedriver().setup();
                // String rootPath = System.getProperty("user.dir");
                //System.setProperty("webdriver.chrome.driver", rootPath+"/drivers/chromedriver.exe"); // Set the path to the chromedriver executable
                return new ChromeDriver(chromeOptions);
            }
            case "edge" -> {
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments(edgeDriverOptions);
                WebDriverManager.firefoxdriver().setup();
                // String rootPath = System.getProperty("user.dir");
                //System.setProperty("webdriver.edge.driver", rootPath+"/drivers/msedgedriver.exe"); // Set the path to the edgedriver executable
                return new EdgeDriver(edgeOptions);
            }
            default -> throw new IllegalArgumentException("Invalid browser: " + browser);
        }
    }

    public WebDriver createRemoteDriver() {
        switch (browser) {
            case "chrome" -> {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments(chromeDriverOptions);
                return new RemoteWebDriver(this.remoteUrl, chromeOptions, false);
            }
            case "edge" -> {
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments(edgeDriverOptions);
                return new RemoteWebDriver(this.remoteUrl, edgeOptions, false);
            }
            default -> throw new IllegalArgumentException("Invalid browser: " + browser);
        }
    }

}

//package com.theInternet.SpringBootSelenium.pages;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//@Component
//public class MainPage extends BasePage{
//    @Autowired
//    private LoginPage loginPage;
//
//    @Autowired
//    private HomePage homePage;
//
//// Use the driver object to interact with the Chrome browser via Selenium WebDriver
//
//
//    @Value("${app.url}")
//    private String appUrl;
//
//    public void PerformLogin(){
//        driver.navigate().to(appUrl);
//        homePage.Clicklogin();
//        loginPage.Login("admin", "adminpassword");
//        loginPage.Clicklogin();
//    }
//}

package com.theInternet.SpringBootSelenium.cucumber.steps;

import com.theInternet.SpringBootSelenium.pages.BasePage;
import com.theInternet.SpringBootSelenium.pages.HomePage;
import com.theInternet.SpringBootSelenium.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


public class login {

    @Autowired
    private LoginPage loginPage;

    @Autowired
    private HomePage homePage;
    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        System.out.println("je me suis connecté");
        homePage.gotoHomePage();
    }
    @When("I try to login with {string} and {string}")
    public void i_try_to_login_with_and(String string1, String string2) {
        System.out.println("j'ai saisi " + string1 + " et " + string2);
        homePage.Clicklogin();
        loginPage.Login(string1,string2);
        loginPage.Clicklogin();
    }
}

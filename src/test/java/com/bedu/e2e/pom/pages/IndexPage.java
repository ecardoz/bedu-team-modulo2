package com.bedu.e2e.pom.pages;

import com.bedu.e2e.pom.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage extends Page {

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@value='Iniciar']")
    private WebElement iniciarButton;

    public IndexPage(WebDriver driver) {
        super(driver);
    }

    public void typeEmail(String email) {
        type(emailInput, email);
    }

    public void clickIniciarSesion(){
        click(iniciarButton);
    }

}

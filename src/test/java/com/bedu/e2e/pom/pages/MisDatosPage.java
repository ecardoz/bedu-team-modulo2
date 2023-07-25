package com.bedu.e2e.pom.pages;

import com.bedu.e2e.pom.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MisDatosPage extends Page {

    @FindBy(xpath = "//span[normalize-space()='edgar122@correo.com']")
    private WebElement emailLabel;

    @FindBy(xpath = "//span[normalize-space()='BLAH212222']")
    private WebElement curpLabel;

    public MisDatosPage(WebDriver driver) {super(driver);}

    public String getEmail(){
        return getText(emailLabel);
    }

    public String getCurp(){
        return getText(curpLabel);
    }

}

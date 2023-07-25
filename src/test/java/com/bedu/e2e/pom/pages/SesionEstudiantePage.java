package com.bedu.e2e.pom.pages;

import com.bedu.e2e.pom.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SesionEstudiantePage extends Page{

    @FindBy(xpath = "//input[@value='MisDatos']")
    private WebElement misDatosButton;

    @FindBy(xpath = "//a[normalize-space()='Detalle']")
    private WebElement detalleButton;

    public SesionEstudiantePage(WebDriver driver) {super(driver);}

    public void clickMisDatonButton(){
        click(misDatosButton);
    }

    public void clickDetalleButton(){
        click(detalleButton);
    }


}

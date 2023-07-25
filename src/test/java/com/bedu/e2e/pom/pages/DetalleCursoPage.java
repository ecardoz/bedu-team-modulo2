package com.bedu.e2e.pom.pages;

import com.bedu.e2e.pom.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DetalleCursoPage extends Page {

    @FindBy(xpath = "//span[normalize-space()='Programacion con POO']")
    private WebElement nombreMateriaLabel;

    @FindBy(xpath = "//span[normalize-space()='10']")
    private WebElement calificacionLabel;

    public DetalleCursoPage(WebDriver driver ) { super(driver);}


    public String getNombreMateria(){
        return getText(nombreMateriaLabel);
    }

    public String getCalificacion(){
        return getText(calificacionLabel);
    }

}

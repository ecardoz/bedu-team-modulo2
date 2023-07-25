package com.bedu.e2e.pom;

import com.bedu.e2e.driver.Driver;
import com.bedu.e2e.pom.pages.DetalleCursoPage;
import com.bedu.e2e.pom.pages.IndexPage;
import com.bedu.e2e.pom.pages.MisDatosPage;
import com.bedu.e2e.pom.pages.SesionEstudiantePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Test {

    public WebDriver driverBrowser = new Driver().getWebDriver();
    protected IndexPage indexPage = PageFactory.initElements(driverBrowser, IndexPage.class);
    protected MisDatosPage misDatosPage = PageFactory.initElements(driverBrowser, MisDatosPage.class);
    protected SesionEstudiantePage sesionEstudiantePage = PageFactory.initElements(driverBrowser, SesionEstudiantePage.class);
    protected DetalleCursoPage detalleCursoPage = PageFactory.initElements(driverBrowser, DetalleCursoPage.class);

}

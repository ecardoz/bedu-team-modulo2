package com.bedu.e2e.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Driver {

    private WebDriver webDriver;
    private ChromeOptions chromeOptions = new ChromeOptions();

    public Driver(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
        System.setProperty("webdriver.chrome.verboseLogging", "false");

        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--window-size=1920,1080");
        this.webDriver = new ChromeDriver(chromeOptions);
    }

    public WebDriver getWebDriver(){
        if(webDriver != null)
            return this.webDriver;
        return new ChromeDriver();
    }

}

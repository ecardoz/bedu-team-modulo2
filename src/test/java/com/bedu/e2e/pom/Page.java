package com.bedu.e2e.pom;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class Page {

    private final WebDriver driver;
    private final Wait<WebDriver> fluentWait;

    public Page(WebDriver driver){
        this.driver = driver;
        this.fluentWait = new FluentWait<>(this.driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NoSuchElementException.class);
    }

    public void visit(String url){
        this.driver.navigate().to(url);
    }

    public void type(WebElement element, String text){
        try{
            this.fluentWait.until(ExpectedConditions.visibilityOf(element));
            element.sendKeys(text);
        }catch (Exception e){
            new Exception("Element not found" + element);
        }
    }

    public void click(WebElement element){
        try{
            this.fluentWait.until(ExpectedConditions.visibilityOf(element));
            element.click();
        }catch (Exception e){
            new Exception("Element not found" + element);
        }
    }

    public String getText(WebElement element){
        try{
            this.fluentWait.until(ExpectedConditions.visibilityOf(element));
        }catch (Exception e){
            new Exception("Element not found" + element);
        }
        return element.getText();
    }
}

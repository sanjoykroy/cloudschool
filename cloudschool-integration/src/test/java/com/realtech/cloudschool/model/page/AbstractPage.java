package com.realtech.cloudschool.model.page;


import com.realtech.cloudschool.driver.SharedWebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

import static java.lang.String.format;
import static org.apache.commons.lang.Validate.notNull;

public abstract class AbstractPage {

    protected static final String MAIN_URL = "http://localhost:8080/cloudschool";

    private WebDriver webDriver = SharedWebDriver.getInstance();

    private Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriver)
                                            .withTimeout(5, TimeUnit.SECONDS)
                                            .pollingEvery(1, TimeUnit.SECONDS)
                                            .ignoring(NoSuchElementException.class);

    protected void getPage(String url) {
        webDriver.get(url);
    }

    protected void setFieldElement(String id, String value) {
        WebElement element = findElementById(id);
        notNull(element, format("Expected element '%s' is not present", id));
        element.clear();
        element.sendKeys(value);
    }

    protected WebElement findElementById(String id) {
        return findElement(By.id(id));
    }

    protected void submit(String id){
        WebElement element = findElementById(id);
        notNull(element, format("Expected element '%s' is not present", id));
        element.submit();
    }

    private WebElement findElement(final By by) {
        try{
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch(TimeoutException ignore){
            return null;
        }
    }
}

package com.realtech.cloudschool.driver;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class SharedWebDriver {

    private static final WebDriver CS_DRIVER = init();

    private static WebDriver init(){
        return new HtmlUnitDriver();
    }

    public static WebDriver getInstance(){
        return CS_DRIVER;
    }

    static {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run(){
                CS_DRIVER.close();
            }
        });
    }
}

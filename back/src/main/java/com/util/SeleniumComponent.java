package com.util;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Service;

// @Service
public class SeleniumComponent {
    private static String SELENIUM_ID = "webdriver.chrome.driver";
    private static String SELENIUM_PATH_MAC = "back/src/main/resources/external/selenium/chromedriver_104_mac64_m1";
    private static String SELENIUM_PATH_LINUX = "back/src/main/resources/external/selenium/chromedriver_104_linux";
    private static String SELENIUM_PATH_JENKINS = "src/main/resources/external/selenium/chromedriver_104_linux";
    private WebDriver driver;

    public SeleniumComponent() {
        try {
            System.setProperty(SELENIUM_ID, SELENIUM_PATH_JENKINS);
            ChromeOptions options = new ChromeOptions();
            options.setHeadless(true);
            options.addArguments("--lang=ko");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            options.setCapability("ignoreProtectedModeSettings", true);
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        } catch (Exception eA) {
            eA.printStackTrace();
            try {
                System.setProperty(SELENIUM_ID, SELENIUM_PATH_LINUX);
                ChromeOptions options = new ChromeOptions();
                options.setHeadless(true);
                options.addArguments("--lang=ko");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--disable-gpu");
                options.setCapability("ignoreProtectedModeSettings", true);
                driver = new ChromeDriver(options);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            } catch (Exception eB) {
                eB.printStackTrace();
                System.setProperty(SELENIUM_ID, SELENIUM_PATH_MAC);
                ChromeOptions options = new ChromeOptions();
                options.setHeadless(true);
                options.addArguments("--lang=ko");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--disable-gpu");
                options.setCapability("ignoreProtectedModeSettings", true);
                driver = new ChromeDriver(options);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            }
        }
    }

    public String requestUrlByTag(String url, String elementName) {
        driver.get(url);
        WebElement webElement = driver.findElement(By.tagName(elementName));
        String outerHTML = webElement.getAttribute("outerHTML");
        quitDriver();
        return outerHTML;
    }

    public String requestUrlById(String url, String idName) {
        driver.get(url);
        WebElement webElement = driver.findElement(By.tagName("body"));
        WebElement targetElement = webElement.findElement(By.id(idName));
        String outerHTML = targetElement.getAttribute("outerHTML");
        quitDriver();
        return outerHTML;
    }

    public void quitDriver() {
        driver.quit();
    }

}
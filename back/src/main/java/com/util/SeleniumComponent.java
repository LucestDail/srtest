package com.util;

import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.stereotype.Service;

@Service
public class SeleniumComponent {

    private static String CHROME_PATH = "http://localhost:4444/";
    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    public String requestUrlByTag(String url, String elementName) throws Exception {
        WebDriver webdriver = getDriver();
        webdriver.navigate().to(url);
        WebElement webElement = webdriver.findElement(By.tagName(elementName));
        String outerHTML = webElement.getAttribute("outerHTML");
        quitRDriver();
        return outerHTML;
    }

    public String requestUrlById(String url, String idName) throws Exception {
        WebDriver webdriver = getDriver();
        webdriver.navigate().to(url);
        WebElement webElement = webdriver.findElement(By.tagName("body"));
        WebElement targetElement = webElement.findElement(By.id(idName));
        String outerHTML = targetElement.getAttribute("outerHTML");
        quitRDriver();
        return outerHTML;
    }

    public void setupThread() throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        options.addArguments("--lang=ko");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.setCapability("ignoreProtectedModeSettings", true);
        driver.set(new RemoteWebDriver(new URL(CHROME_PATH), options));
    }

    public WebDriver getDriver() throws Exception {
        setupThread();
        return driver.get();
    }

    public void quitRDriver() throws Exception {
        getDriver().quit();
    }

}

package com.util;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Service;

@Service
public class SeleniumComponent {
    private static String SELENIUM_ID = "webdriver.chrome.driver";
    private static String SELENIUM_PATH_JENKINS = "/var/lib/jenkins/workspace/srtest/back/src/main/resources/external/selenium/chromedriver_linux64_106/chromedriver";
    private static String SELENIUM_PATH_MAC = "back/src/main/resources/external/selenium/chromedriver_mac64/chromedriver";
    private static String SELENIUM_PATH_MAC_M1 = "back/src/main/resources/external/selenium/chromedriver_mac64_m1/chromedriver";
    private static String SELENIUM_PATH_LINUX = "back/src/main/resources/external/selenium/chromedriver_linux64/chromedriver";
    private static String SELENIUM_PATH_WINDOWS = "back/src/main/resources/external/selenium/chromedriver_win32/chromedriver.exe";
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
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
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
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
                driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
            } catch (Exception eB) {
                eB.printStackTrace();
                try {
                    System.setProperty(SELENIUM_ID, SELENIUM_PATH_WINDOWS);
                    ChromeOptions options = new ChromeOptions();
                    options.setHeadless(true);
                    options.addArguments("--lang=ko");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");
                    options.addArguments("--disable-gpu");
                    options.setCapability("ignoreProtectedModeSettings", true);
                    driver = new ChromeDriver(options);
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                    driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
                    driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
                } catch (Exception eC) {
                    eC.printStackTrace();
                    try {
                        System.setProperty(SELENIUM_ID, SELENIUM_PATH_MAC);
                        ChromeOptions options = new ChromeOptions();
                        options.setHeadless(true);
                        options.addArguments("--lang=ko");
                        options.addArguments("--no-sandbox");
                        options.addArguments("--disable-dev-shm-usage");
                        options.addArguments("--disable-gpu");
                        options.setCapability("ignoreProtectedModeSettings", true);
                        driver = new ChromeDriver(options);
                        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
                        driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
                    } catch (Exception eD) {
                        eD.printStackTrace();
                        System.setProperty(SELENIUM_ID, SELENIUM_PATH_MAC_M1);
                        ChromeOptions options = new ChromeOptions();
                        options.setHeadless(true);
                        options.addArguments("--lang=ko");
                        options.addArguments("--no-sandbox");
                        options.addArguments("--disable-dev-shm-usage");
                        options.addArguments("--disable-gpu");
                        options.setCapability("ignoreProtectedModeSettings", true);
                        driver = new ChromeDriver(options);
                        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
                        driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
                    }
                }
            }
        }
    }

    public String requestUrlByTag(String url, String elementName) {
        driver.get(url);
        WebElement webElement = driver.findElement(By.tagName(elementName));
        String outerHTML = webElement.getAttribute("outerHTML");
        return outerHTML;
    }

    public String requestUrlById(String url, String idName) {
        driver.get(url);
        WebElement webElement = driver.findElement(By.tagName("body"));
        WebElement targetElement = webElement.findElement(By.id(idName));
        String outerHTML = targetElement.getAttribute("outerHTML");
        return outerHTML;
    }

    public String requestUrlbyClass(String url, String className) {
        driver.get(url);
        WebElement webElement = driver.findElement(By.tagName("body"));
        WebElement targetElement = webElement.findElement(By.className(className));
        System.out.println(targetElement);
        String outerHTML = targetElement.getAttribute("outerHTML");
        return outerHTML;
    }

    public void quitDriver() {
        driver.quit();
    }

}
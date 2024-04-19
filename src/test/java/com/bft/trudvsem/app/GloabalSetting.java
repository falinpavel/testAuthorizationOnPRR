package com.bft.trudvsem.app;

import com.bft.trudvsem.properties.ConfProperties;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GloabalSetting {
    public static com.bft.trudvsem.app.BasePage BasePage;
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeAll
    public static void start() {
        System.out.println("Начало выполнения теста");
    }
    @BeforeEach
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        // Создание экземпляра WebDriver для Chrome
        driver = new ChromeDriver();
        // Развернуть на весь экран
        driver.manage().window().maximize();
        // Установка ожидания 15 секунд/
        wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // Инициализация объекта явного ожидания
        driver.get(ConfProperties.getProperty("stand"));
        BasePage = new BasePage(driver);
    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
    @AfterAll
    public static void end() {
        System.out.println("Все тесты успешны");
    }
}

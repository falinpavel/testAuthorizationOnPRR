package com.bft.trudvsem;

import org.junit.Test;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class CreateNewCvTest { // нужно ли наследование?
    //public static LoginPageTest LoginPageTest;
    public static BasePage BasePage;
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeAll
    public static void start () {
        System.out.println("Лог - начало выполнения теста по созданию резюме");
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
    @Test
    public void CreateCv () {
        BasePage.setHoverAndClickDropDownCv();
        BasePage.setClickAllCv();
        BasePage.setClickCreateNewCv();
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

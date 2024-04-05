package com.bft.trudvsem;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPageTest {
    public static BasePage BasePage;
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
    @Test
    public void loginTest () {
        // Открытие страницы
        //driver.get("https://web-hotfix-test11.k8s.trudvsem.ru/"); // подключили в сетап через проперти

        // Нажатие на кнопку "Войти" по XPath
        //WebElement loginButton = driver.findElement(By.xpath("//body//div[@class='mega-menu__user-interface']//a"));
        //loginButton.click();
        BasePage.clickloginBaseButton();

        // Нажатие на кнопку входа через госуслуги
        //WebElement submitButton = driver.findElement(By.xpath("//body//main//div[@class='mb-3 row']//button"));
        //submitButton.click();
        BasePage.clickloginEsia();

        // Дожидаемся загрузки страницы ввода логина и пароля
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='login']")));

        // Ввод логина на форме авторизации ЕСИА
        //WebElement loginField = driver.findElement(By.xpath("//*[@id='login']"));
        //loginField.sendKeys("+7(929)8405043");
        BasePage.inputLoginEsia(ConfProperties.getProperty("login"));

        // Ввод пароля на форме авторизации ЕСИА
        //WebElement passwordField = driver.findElement(By.xpath("//*[@id='password']"));
        //passwordField.sendKeys("Y3a!5eT$");
        BasePage.inputPasswordEsia(ConfProperties.getProperty("password"));

        // Нажатие на кнопку "Войти" на форме авторизации ЕСИА
        //WebElement loginSubmitButton = driver.findElement(By.xpath("//body//div//button[@class='plain-button plain-button_wide']"));
        //loginSubmitButton.click();
        BasePage.clickEnter();

        // Дождаться загрузки страницы
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='individual_button']")));

        // Нажать на кнопку "individual_button"
        //WebElement individualButton = driver.findElement(By.xpath("//*[@id='individual_button']"));
        //individualButton.click();
        BasePage.clickApplicant();

        // Дождаться полной загрузки страницы
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ib-display_templates']/h1")));

        // Проверка, что страница успешно загружена
        //WebElement pageTitle = driver.findElement(By.xpath("//div[@class='ib-display_templates']/h1"));
        //assert pageTitle.getText().equals("Мой кабинет");
    }
    @AfterEach
    public void tearDown() {
        // Закрытие браузера
        driver.quit();

    }
    @AfterAll
    public static void end() {
        System.out.println("Все тесты успешны");
    }
}
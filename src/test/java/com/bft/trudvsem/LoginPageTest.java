package com.bft.trudvsem;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
        // Нажатие на кнопку "Войти" по XPath
        BasePage.clickloginBaseButton();
        // Клик на кнопку "Войти через ЕСИА"
        BasePage.clickloginEsia();
        // Дожидаемся загрузки страницы ввода логина и пароля
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='login']")));
        // Ввод логина на форме авторизации ЕСИА
        BasePage.inputLoginEsia(ConfProperties.getProperty("login"));
        // Ввод пароля на форме авторизации ЕСИА
        BasePage.inputPasswordEsia(ConfProperties.getProperty("password"));
        // Нажать на кнопку "Войти" на форме авторизации ЕСИА
        BasePage.clickEnter();
        // Дождаться загрузки страницы
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='individual_button']")));
        // Навести и нажать на кнопку "Войти как соискатель"
        BasePage.hoverAndClickOnApplicantButton();
        // Дождаться полной загрузки страницы
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ib-display_templates']/h1")));

        //Создание резюме
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
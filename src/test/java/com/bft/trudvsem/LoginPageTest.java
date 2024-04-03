package com.bft.trudvsem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPageTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        // Создание экземпляра WebDriver для Chrome
        driver = new ChromeDriver();
        // Установка ожидания 15 секунд
        driver.manage().window().maximize();
        // Развернуть на весь экран
        wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // Инициализация объекта явного ожидания
    }

    @Test
    public void loginTest() {
        // Открытие страницы
        driver.get("https://web-hotfix-test11.k8s.trudvsem.ru/");

        // Нажатие на кнопку "Войти" по XPath
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div/div/a/span"));
        loginButton.click();

        // Нажатие на кнопку входа через госуслуги
        WebElement submitButton = driver.findElement(By.xpath("//*[@id='laborer']/div/div[1]/div[2]/div/form/button"));
        submitButton.click();

        // Дожидаемся загрузки страницы ввода логина и пароля
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='login']")));

        // Ввод логина
        WebElement loginField = driver.findElement(By.xpath("//*[@id='login']"));
        loginField.sendKeys("+7(976)4017944");

        // Ввод пароля
        WebElement passwordField = driver.findElement(By.xpath("//*[@id='password']"));
        passwordField.sendKeys("Y3a!5eT$");

        // Нажатие на кнопку "Войти"
        WebElement loginSubmitButton = driver.findElement(By.xpath("/html/body/esia-root/div/esia-login/div/div[1]/form/div[4]/button"));
        loginSubmitButton.click();
    }

    @AfterEach
    public void tearDown() {
        // Закрытие браузера
        driver.quit();
    }
}

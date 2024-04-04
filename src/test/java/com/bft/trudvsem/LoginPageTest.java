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
import page.BaseTest;

import java.time.Duration;

public class LoginPageTest extends BaseTest {
    private WebDriver driver;
    private WebDriverWait wait;
    @Test
    public void loginTest() {
        // Открытие страницы
        driver.get("https://web-hotfix-test11.k8s.trudvsem.ru/");
        // Нажатие на кнопку "Войти" по XPath
        WebElement loginButton = driver.findElement(By.xpath("//body//div[@class='mega-menu__user-interface']//a"));
        loginButton.click();
        // Нажатие на кнопку входа через госуслуги
        WebElement submitButton = driver.findElement(By.xpath("//body//main//div[@class='mb-3 row']//button"));
        submitButton.click();
        // Дожидаемся загрузки страницы ввода логина и пароля
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='login']")));
        // Ввод логина на форме авторизации ЕСИА
        WebElement loginField = driver.findElement(By.xpath("//*[@id='login']"));
        loginField.sendKeys("+7(929)8405043");
        // Ввод пароля на форме авторизации ЕСИА
        WebElement passwordField = driver.findElement(By.xpath("//*[@id='password']"));
        passwordField.sendKeys("Y3a!5eT$");
        // Нажатие на кнопку "Войти" на форме авторизации ЕСИА
        WebElement loginSubmitButton = driver.findElement(By.xpath("//body//div//button[@class='plain-button plain-button_wide']"));
        loginSubmitButton.click();
        // Дождаться загрузки страницы
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='individual_button']")));
        // Нажать на кнопку "individual_button"
        WebElement individualButton = driver.findElement(By.xpath("//*[@id='individual_button']"));
        individualButton.click();
        // Дождаться полной загрузки страницы
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ib-display_templates']/h1")));
        // Проверка, что страница успешно загружена
        //WebElement pageTitle = driver.findElement(By.xpath("//div[@class='ib-display_templates']/h1"));
        //assert pageTitle.getText().equals("Мой кабинет");
    }
}
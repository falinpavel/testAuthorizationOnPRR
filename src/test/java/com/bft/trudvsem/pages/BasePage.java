package com.bft.trudvsem.pages;

import com.bft.trudvsem.tests.LoginPageTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver;
    public BasePage (WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    Actions actions = new Actions(LoginPageTest.driver);
    public static WebDriverWait wait;

    // Нажатие на кнопку "Войти" по XPath
    @FindBy(xpath = "//body//div[@class='mega-menu__user-interface']//a")
    private WebElement loginBaseButton;
    // Нажатие на кнопку входа через госуслуги
    @FindBy(xpath = "//body//main//div[@class='mb-3 row']//button")
    private WebElement loginEsia;
    // Ввод логина на форме авторизации ЕСИА
    @FindBy(xpath = "//*[@id='login']")
    private WebElement inputLoginEsia;
    // Ввод пароля на форме авторизации ЕСИА
    @FindBy(xpath = "//*[@id='password']")
    private WebElement inputPasswordEsia;
    // Нажатие на кнопку "Войти" на форме авторизации ЕСИА
    @FindBy(xpath = "//body//div//button[@class='plain-button plain-button_wide']")
    private WebElement clickEnter;
    // Нажать на кнопку "individual_button" (соискатель)
    @FindBy(xpath = "//*[@id='individual_button']")
    private WebElement clickApplicant;


    // МЕТОДЫ
    // простой клик на кнопку"Войти"
    public void clickloginBaseButton () {
        try {
            //wait.until(ExpectedConditions.visibilityOf(loginBaseButton));
            loginBaseButton.click();
            System.out.println("Лог - нажатие на кнопку 'Войти'");
        }   catch (Exception e) {
            System.out.println("Кнопка 'Войти' не найдена или не кликабельна");
        }
    }
    // простой клик на кнопку "Войти через Госуслуги"
    public void clickloginEsia () {
        try {
            // Ожидание появления элемента
            //wait.until(ExpectedConditions.visibilityOf(loginEsia));
            // Логирование нажатия на кнопу
            loginEsia.click();
            System.out.println("Лог - нажатие на кнопку 'Войти через Госуслуги'");
            // Нажатие на кнопку
        } catch (Exception e) {
            System.out.println("Кнопка 'Войти через Госуслуги' не найдена или не кликабельна");
        }
    }
    // Ввод логина ЕСИА
    public void inputLoginEsia (String login) {
        try {
            if (inputLoginEsia.isEnabled()) {
                inputLoginEsia.clear();
                inputLoginEsia.sendKeys(login);
                System.out.println("Лог - очистка поля и успешный ввод логина");
            } else {
                System.out.println("Лог - поле ввода логина недоступно");
            }
        } catch (Exception e) {
            System.out.println("Лог - что то пошло не так при вводе логина");
        }
    }
    // ввод пароля ЕСИА
    public void inputPasswordEsia (String password) {
        try {
            if (inputPasswordEsia.isEnabled()) {
                // очистка поля ввода
                inputPasswordEsia.clear();
                //Ввод пароля
                inputPasswordEsia.sendKeys(password);
                System.out.println("Лог - очистка поля и успешный ввод пароля");
            } else {
                System.out.println("Лог - поле ввода пароля недоступно");
            }
        } catch (Exception e) {
            System.out.println("Лог - что то пошло не так при вводе пароля");
        }
    }
    // Клик на кнопку "Войти" в ЕСИА
    public void clickEnter () {
        //wait.until(ExpectedConditions.visibilityOf(clickEnter));
        actions.moveToElement(clickEnter).perform();
        System.out.println("Лог - наведение и клик на кнопку 'Войти' на фоме ЕСИА");
        clickEnter.click();
    }
    // Клик на кнопку "Соискатель"
    public void hoverAndClickOnApplicantButton () {
        //wait.until(ExpectedConditions.visibilityOf(clickApplicant));
        actions.moveToElement(clickApplicant).perform();
        clickApplicant.click();
        System.out.println("Лог - наведение, ожидание и клик на кнопку 'Соискатель'");
        //actions.click(clickApplicant);
    }
}
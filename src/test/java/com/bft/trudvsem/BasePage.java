package com.bft.trudvsem;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class BasePage extends LoginPageTest { // добавил extends
    public WebDriver driver;
    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    // Нажатие на кнопку "Войти" по XPath
    @FindBy(xpath = "//body//div[@class='mega-menu__user-interface']//a")
    private WebElement loginBaseButton; // может без private???
    // Нажатие на кнопку входа через госуслуги
    @FindBy(xpath = "//body//main//div[@class='mb-3 row']//button")
    private WebElement loginEsia; // может без private???
    // Ввод логина на форме авторизации ЕСИА
    @FindBy(xpath = "//*[@id='login']")
    private WebElement inputLoginEsia; // может без private???
    // Ввод пароля на форме авторизации ЕСИА
    @FindBy(xpath = "//*[@id='password']")
    private WebElement inputPasswordEsia; // может без private???
    // Нажатие на кнопку "Войти" на форме авторизации ЕСИА
    @FindBy(xpath = "//body//div//button[@class='plain-button plain-button_wide']")
    private WebElement clickEnter; // может без private???
    // Нажать на кнопку "individual_button" (соискатель)
    @FindBy(xpath = "//*[@id='individual_button']")
    private WebElement clickApplicant; // может без private???

    // МЕТОДЫ
    // простой клик на кнопку"Войти"
    public void clickloginBaseButton () {
        loginBaseButton.click();
    }

    // простой клик на кнопку "Войти через Госуслуги"
    public void clickloginEsia () {
        loginEsia.click();
    }

    // Ввод логина ЕСИА
    public void inputLoginEsia (String login) {
        inputLoginEsia.sendKeys(login);
    }

    // ввод пароля ЕСИА
    public void inputPasswordEsia (String password) {
        inputPasswordEsia.sendKeys(password);
    }

    // Клик на кнопку "Войти" в ЕСИА
    public void clickEnter () {
        clickEnter.click();
    }

    // Клик на кнопку "Соискатель"
    public void clickApplicant () {
        clickApplicant.click();
    }

}
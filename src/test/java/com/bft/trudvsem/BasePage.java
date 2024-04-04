package com.bft.trudvsem;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class BasePage {
    public WebDriver driver;
    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    // Нажатие на кнопку "Войти" по XPath
    @FindBy(xpath = "//body//div[@class='mega-menu__user-interface']//a")
    private WebElement loginButton;
    // Нажатие на кнопку входа через госуслуги
    @FindBy(xpath = "//body//main//div[@class='mb-3 row']//button")
    private WebElement loginEsia;
    // Ввод логина на форме авторизации ЕСИА
    @FindBy(xpath = "//*[@id='login']")
    private WebElement setLoginEsia;
    // Ввод пароля на форме авторизации ЕСИА
    @FindBy(xpath = "//*[@id='password']")
    private WebElement setPasswordEsia;
    // Нажатие на кнопку "Войти" на форме авторизации ЕСИА
    @FindBy(xpath = "//body//div//button[@class='plain-button plain-button_wide']")
    private WebElement clickEnter;
    // Нажать на кнопку "individual_button" (соискатель)
    @FindBy(xpath = "//*[@id='individual_button']")
    private WebElement clickSoiskatel;

}
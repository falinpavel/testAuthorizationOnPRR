package com.bft.trudvsem.tests;

import com.bft.trudvsem.app.GloabalSetting;
import com.bft.trudvsem.properties.ConfProperties;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPageTest extends GloabalSetting {
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
        //BasePage.hoverAndClickOnApplicantButton();
        // Дождаться полной загрузки страницы
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ib-display_templates']/h1")));
        //Создание резюме
        //BasePage.setHoverAndClickDropDownCv();
        //BasePage.setClickAllCv();
        //BasePage.setClickCreateNewCv();
    }
}
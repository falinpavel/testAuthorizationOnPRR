package com.bft.trudvsem.pages;

import com.bft.trudvsem.tests.LoginPageTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class CreateNewCv {
    public WebDriver driver;
    public CreateNewCv (WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    Actions actions = new Actions(LoginPageTest.driver);
    public static WebDriverWait wait;
    // ВЕБ ЭЛЕМЕНТЫ ДЛЯ СОЗДАНИЯ РЕЗЮМЕ
    // Навести и кликнуть на "Мои резюме" в главном меню (дропдаун)
    @FindBy (xpath = "//button[@class='mega-menu__dropdown-toggle']")
    private WebElement hoverAndClickDropDownCv;
    // кликнуть на "Список моих резюме"
    @FindBy (xpath = "/*[@class=\"mega-menu__dropdown-item\"]/a[text()='Список моих резюме']")
    private WebElement ClickAllCv;
    // Кликнуть на кнопку "Добавить резюме"
    @FindBy (xpath = "//*[@id=_cc3b03d4-07fc-402d-a0ab-aab1533e88e0]/div[1]/div[1]/button[1]")
    private WebElement ClickCreateNewCv;
    @FindBy (xpath = "//*[@class=\"mega-menu__dropdown-item\"]/a[text()='Список моих резюме']")
    private WebElement DropDownCv;

    // МЕТОДЫ ДЛЯ СОЗДАНИЯ РЕЗЮМЕ
    public void setHoverAndClickDropDownCv () {
        //wait.until(ExpectedConditions.visibilityOf(hoverAndClickDropDownCv));
        //actions.moveToElement(hoverAndClickDropDownCv).perform();
        hoverAndClickDropDownCv.click();
        wait.until(ExpectedConditions.visibilityOf(DropDownCv));
        System.out.println("Лог - ожидание, наведение и клик на кнопку 'Мои резюме'");
    }
    public void setClickAllCv () {
        try {
            //wait.until(ExpectedConditions.visibilityOf(DropDownCv));
            ClickAllCv.click();
        } catch (Exception e) {
            System.out.println("Лог - что то пошло не так при клике на кнопку 'Список всех резюме'");
        }
    }
    public void setClickCreateNewCv () {
        wait.until(ExpectedConditions.visibilityOf(ClickCreateNewCv));
        ClickCreateNewCv.click();
    }
}

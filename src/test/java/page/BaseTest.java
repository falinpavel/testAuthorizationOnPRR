package page;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        // Создание экземпляра WebDriver для Chrome
        driver = new ChromeDriver();
        // Развернуть на весь экран
        driver.manage().window().maximize();
        // Установка ожидания 15 секунд/
        wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // Инициализация объекта явного ожидания
    }

    @AfterEach
    public void tearDown() {
        // Закрытие браузера
        driver.quit();
    }

}

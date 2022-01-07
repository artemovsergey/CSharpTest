import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationTest {

    WebDriver webDriver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/kirill/chrome_driver/chromedriver");

        webDriver = new ChromeDriver();
        webDriver.get("https://fastpic.ru");
    }


    @After
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    @Test
    public void testNavigateToRules() {
        webDriver.findElement(By.xpath("//a[@title='Правила использования сервиса']/div/div[@class='a'][text()='Правила']")).click();

        Assertions.assertEquals("https://fastpic.ru/rules", webDriver.getCurrentUrl());
    }

    @Test
    public void testNavigateToInfo() {
        webDriver.findElement(By.xpath("//a[@title='Информация о нас']/div/div[@class='a'][text()='О сервисе']")).click();

        Assertions.assertEquals("https://fastpic.ru/about", webDriver.getCurrentUrl());
    }

    @Test
    public void testNavigateToFp() {
        webDriver.findElement(By.xpath("//a[@title='Программа загрузки изображений и скриншотов для вашего ПК']" +
                "/div/div[@class='a'][text()='FP Uploader']")).click();

        Assertions.assertEquals("https://fastpic.ru/fpuploader", webDriver.getCurrentUrl());
    }

    @Test
    public void testNavigateToDownloads() {
        webDriver.findElement(By.xpath("//a[@title='Посмотреть загруженные вами изображения на сервис']" +
                "/div/div[@class='a'][text()='Мои загрузки']")).click();

        Assertions.assertEquals("https://fastpic.ru/my.php", webDriver.getCurrentUrl());
    }

    @Test
    public void testNavigateToHomePage() {
        webDriver.get("https://fastpic.ru/rules");

        webDriver.findElement(By.xpath("//a[@title='Загрузка изображений']" +
                "/div/div[@class='a'][text()='Главная']")).click();

        Assertions.assertEquals("https://fastpic.ru/", webDriver.getCurrentUrl());
    }

}

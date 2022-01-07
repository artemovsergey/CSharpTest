package downloads;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DownloadsPageTest {

    WebDriver webDriver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/kirill/chrome_driver/chromedriver");

        webDriver = new ChromeDriver();
        webDriver.get("https://fastpic.ru/");
    }


    @After
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    @Test
    public void testDeleteAllDownloads() {
        webDriver.findElement(By.xpath("//*[@name='file[]']")).
                sendKeys(System.getProperty("user.dir") + "/src/main/resources/mmm.png");

        webDriver.findElement(By.xpath("//input[@value='Загрузить']")).submit();

        webDriver.navigate().to("https://fastpic.ru/");

        webDriver.findElement(By.xpath("//*[@name='file[]']")).
                sendKeys(System.getProperty("user.dir") + "/src/main/resources/mmm.png");

        webDriver.findElement(By.xpath("//input[@value='Загрузить']")).submit();

        webDriver.findElement(By.xpath("//a[@title='Посмотреть загруженные вами изображения на сервис']" +
                "/div/div[@class='a'][text()='Мои загрузки']")).click();

        webDriver.findElement(By.xpath("//a[@class='jslink'][contains(text(), 'выбрать всё')]")).click();
        webDriver.findElement(By.xpath("//a[@class='jslink'][contains(text(), 'удалить выбранное')]")).click();

        Assertions.assertThrows(NoSuchElementException.class, () -> webDriver.findElement(By.xpath("//div[@class='thumb']/div/a/img")));
    }

}

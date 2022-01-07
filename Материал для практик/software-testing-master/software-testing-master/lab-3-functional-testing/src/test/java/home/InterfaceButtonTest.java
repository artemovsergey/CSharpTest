package home;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InterfaceButtonTest {

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
    public void testAddingUploadingFileButton() {

        WebElement addingUploadingFileButton = webDriver.findElement(By.xpath("//*[text()='[ добавить поле ]']"));

        int previousAmount = addingUploadingFileButton.findElements(By.xpath(".//parent::div/parent::div/input[@class='upfile']")).size();
        addingUploadingFileButton.click();
        int currentAmount = addingUploadingFileButton.findElements(By.xpath(".//parent::div/parent::div/input[@class='upfile']")).size();

        Assertions.assertEquals(previousAmount + 1, currentAmount);
    }

    @Test
    public void testShowingConstraints() {
        WebElement showingLimitsButton = webDriver.findElement(By.xpath("//*[text()='[ посмотреть ограничения ]']"));

        showingLimitsButton.click();

        Assertions.assertDoesNotThrow(() -> webDriver.findElement(By.xpath("//p//b[text()='gif, jpeg, png, webp, bmp']")));
    }

    @Test
    public void testDisablingEffects() {
        webDriver.findElement(By.xpath("//*[text()='[ отключить все эффекты ]']")).click();

        Assertions.assertTrue(webDriver.findElement(By.xpath("//input[@name='check_thumb'][@value='no']")).isSelected());

        Assertions.assertFalse(webDriver.findElement(By.xpath("//input[@name='check_orig_resize']")).isSelected());
        Assertions.assertFalse(webDriver.findElement(By.xpath("//input[@name='check_orig_rotate']")).isSelected());
        Assertions.assertFalse(webDriver.findElement(By.xpath("//input[@name='check_optimization']")).isSelected());
        Assertions.assertFalse(webDriver.findElement(By.xpath("//input[@name='check_poster']")).isSelected());

    }

    @Test
    public void testSwitchingToLinkMode() {
        webDriver.findElement(By.xpath("//*[text()='[ по ссылке ]']")).click();

        Assertions.assertDoesNotThrow(() -> webDriver.findElement(By.xpath("//textarea[@name='files']")));
    }

    @Test
    public void testSwitchingToComputerMode() {
        webDriver.findElement(By.xpath("//*[text()='[ с компьютера ]']")).click();

        Assertions.assertDoesNotThrow(() -> webDriver.findElement(By.xpath("//input[@name='file[]'][@type='file']")));
    }

}

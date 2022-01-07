package fp;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FpPageTest {

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

}

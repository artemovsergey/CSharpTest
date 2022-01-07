package home;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class UploadingTest {

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
    public void testUploadingFileFromComputer() {
        webDriver.findElement(By.xpath("//*[@name='file[]']")).
                sendKeys(System.getProperty("user.dir") + "/src/main/resources/mmm.png");

        checkUploading();
    }


    @Test
    public void testUploadingFileFromLink() {
        webDriver.findElement(By.xpath("//*[text()='[ по ссылке ]']")).click();

        webDriver.findElement(By.xpath("//textarea[@name='files']"))
        .sendKeys("https://freepngimg.com/thumb/luigi/21674-3-luigi-hd-thumb.png");

        checkUploading();
    }

    @Test
    public void testReducingSizeFromSelect() {
        String imgSizeRequired = "320";

        webDriver.findElement(By.xpath("//*[@name='file[]']")).
                sendKeys(System.getProperty("user.dir") + "/src/main/resources/kkk.jpg");

        webDriver.findElement(By.xpath("//select[@name='res_select']")).sendKeys(imgSizeRequired);

        WebElement reduceSizeCheckbox = webDriver.findElement(By.xpath("//input[@name='check_orig_resize']"));

        if (!reduceSizeCheckbox.isSelected()) {
            reduceSizeCheckbox.click();
        }

        webDriver.findElement(By.xpath("//input[@value='Загрузить']")).submit();

        Dimension imageSize = getDimensionOfUploadedImage();

        Assertions.assertEquals(Integer.parseInt(imgSizeRequired), Math.max(imageSize.getHeight(), imageSize.getWidth()));
    }

    @Test
    public void testReducingSizeFromInputText() {
        String imgSizeRequired = "294";

        webDriver.findElement(By.xpath("//*[@name='file[]']")).
                sendKeys(System.getProperty("user.dir") + "/src/main/resources/kkk.jpg");

        WebElement reduceSizeCheckbox = webDriver.findElement(By.xpath("//input[@name='check_orig_resize']"));

        if (!reduceSizeCheckbox.isSelected()) {
            reduceSizeCheckbox.click();
        }

        WebElement inputText = webDriver.findElement(By.xpath("//input[@name='orig_resize']"));

        inputText.clear();
        inputText.sendKeys(imgSizeRequired);

        webDriver.findElement(By.xpath("//input[@value='Загрузить']")).submit();

        Dimension imageSize = getDimensionOfUploadedImage();

        Assertions.assertEquals(Integer.parseInt(imgSizeRequired), Math.max(imageSize.getHeight(), imageSize.getWidth()));
    }

    @Test
    public void testPreviewSizeWidth() {
        String imgSize = "240";

        try {
            previewSizeHelper(imgSize);

            webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

            Assertions.assertEquals(Integer.parseInt(imgSize),
                    webDriver.findElement(By.xpath("//div[@class='dCenter']//img[contains(@src, 'fastpic.ru')]")).getSize().getWidth());

            clearDownloads();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void testPreviewSizeHeight() {
        String imgSize = "130";

        webDriver.findElement(By.xpath("//div[@class='preview-size']//input[@name='check_thumb_size_vertical']")).click();

        try {
            previewSizeHelper(imgSize);

            Assertions.assertEquals(Integer.parseInt(imgSize),
                    webDriver.findElement(By.xpath("//div[@class='dCenter']//img[contains(@src, 'fastpic.ru')]")).getSize().getHeight());

            clearDownloads();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testRotateImage() {
        webDriver.findElement(By.xpath("//*[@name='file[]']")).
                sendKeys(System.getProperty("user.dir") + "/src/main/resources/kkk.jpg");

        webDriver.findElement(By.xpath("//input[@name='check_orig_resize']")).click();
        webDriver.findElement(By.xpath("//select[@name='res_select']")).sendKeys("320");
        webDriver.findElement(By.xpath("//input[@name='check_orig_rotate']")).click();
        webDriver.findElement(By.xpath("//select[@name='orig_rotate']")).sendKeys("90");
        webDriver.findElement(By.xpath("//input[@value='Загрузить']")).submit();

        Dimension imageSize = getDimensionOfUploadedImage();

        Assertions.assertEquals(320, imageSize.getHeight());
    }

    @Test
    public void testUploadIncorrectFile() {
        webDriver.findElement(By.xpath("//*[@name='file[]']")).
                sendKeys(System.getProperty("user.dir") + "/src/main/resources/tourist.svg");

        webDriver.findElement(By.xpath("//input[@value='Загрузить']")).submit();

        Assertions.assertDoesNotThrow(() -> webDriver.findElement(By.xpath("//div[contains(text(), 'Загружено изображение (tourist.svg) неизвестного формата.')]")));
    }

    private void previewSizeHelper(String size) throws IOException {
        String imgSize = size;

        BufferedImage img = ImageIO.read(new File(System.getProperty("user.dir") + "/src/main/resources/lll.png"));

        if (img.getWidth() < Integer.parseInt(imgSize)) {
            imgSize = String.valueOf(Integer.parseInt(imgSize) - 20);
        }

        if (Integer.parseInt(imgSize) > 400) {
            imgSize = "400";
        }

        WebElement previewSize = webDriver.findElement(By.xpath("//div[@class='preview-size']/input[@name='thumb_size']"));

        previewSize.clear();
        previewSize.sendKeys(imgSize);

        webDriver.findElement(By.xpath("//*[@name='file[]']")).sendKeys(System.getProperty("user.dir") + "/src/main/resources/lll.png");
        webDriver.findElement(By.xpath("//input[@value='Загрузить']")).submit();

    }

    private void checkUploading() {
        webDriver.findElement(By.xpath("//input[@value='Загрузить']")).submit();

        Assertions.assertDoesNotThrow(() -> webDriver.findElement(By.xpath("//div[@class='dCenter']/h3")));
        Assertions.assertDoesNotThrow(() -> webDriver.findElement(By.xpath("//div[@class='dCenter']")).
                findElement(By.xpath("//img[contains(@src, 'fastpic.ru')]")));

        clearDownloads();
    }

    private void clearDownloads() {
        webDriver.findElement(By.xpath("//div[@class='a'][text()='Мои загрузки']")).click();
        webDriver.findElement(By.xpath("//a[@class='jslink'][text()='[ выбрать всё ]']")).click();
        webDriver.findElement(By.xpath("//a[@class='jslink'][text()='[ удалить выбранное ]']")).click();
    }

    private Dimension getDimensionOfUploadedImage() {
        String link =
                webDriver.findElement(By.xpath("//span[contains(text(), '(Clickable thumbnails for forums)')]//parent::li/input")).getAttribute("value");

        link = link.replace("view", "fullview");
        link = link.substring(5, link.indexOf("html") + 4);

        System.out.println(link);

        webDriver.quit();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addExtensions(new File("/home/kirill/Загрузки/extension_3_5_34_0.crx"));

        webDriver = new ChromeDriver(chromeOptions);
        webDriver.get(link);

        return webDriver.findElement(By.xpath("//img[@class='image']")).getSize();
    }

}

package ru.ithillel.ua;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FirstTest {

    public ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://ithillel.ua");
    }

    @Test
    public void OpenSyte() {
        System.out.println("Проверка title сайта");
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Компьютерная школа Hillel в Киеве: курсы IT технологий"));
    }

    @Test
    public void Register() {
        System.out.println("Проверка регистрации на курс");
        driver.findElement(By.id("btn-consultation-hero")).click();
        System.out.println("Заполните имя");
        driver.findElement(By.id("input-name-consultation")).sendKeys("Иван");
        System.out.println("Заполните почту");
        driver.findElement(By.id("input-email-consultation")).sendKeys("Ivan@gmail.com");
        System.out.println("Заполните номер телефона");
        driver.findElement(By.id("input-tel-consultation")).sendKeys("342261321");
        System.out.println("Выберите курс");
        driver.findElement(By.id("listbox-btn-input-course-consultation")).click();
        driver.findElement(By.id("modal")).findElement(By.xpath("//li[@data-entry-id = '17065']")).click();
        System.out.println("Согласитесь с условиями");
        driver.findElement(By.className("checkbox_checkmark")).click();
        System.out.println("Зарегестрируйтесь на курс");
        driver.findElement(By.className("site-wrapper")).findElement(By.className("form-footer_btn")).click();
        System.out.println("Регистрация прошла успешно");
    }

    @After
    public void close() {
        driver.quit();
    }
}

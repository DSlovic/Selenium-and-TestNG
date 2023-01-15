
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utils_test.UtilsTest;

import java.util.concurrent.TimeUnit;


public class Login_test {
    static WebDriver driver = new ChromeDriver();

    static void logOut(){
        UtilsTest.findByText("Odjavi se",driver).click();
        driver.get("http://localhost/projekat5/IP_projekat/login.php");
    }

    @BeforeClass
    public static void prep(){
        driver.get("http://localhost/projekat5/IP_projekat/login.php");
    }

    @Test
    public void successfulLoginTestForStudent(){
        UtilsTest.inputLogin("k_ime", "ana",driver);
        UtilsTest.inputLogin("lozinka", "Sifra1234$",driver);
        UtilsTest.loginClickSubmitButton(driver);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        UtilsTest.findByText("Ostavi biografiju",driver);
        logOut();
    }

    @Test
    public void successfulLoginTestForKompanija(){
        UtilsTest.inputLogin("k_ime", "mobity",driver);
        UtilsTest.inputLogin("lozinka", "Sifra123$",driver);
        UtilsTest.loginClickSubmitButton(driver);
        UtilsTest.findByText("Otvori novi konkurs",driver);
        logOut();
    }

    @Test
    public void successfulLoginTestForAdministrator(){
        UtilsTest.inputLogin("k_ime", "anci",driver);
        UtilsTest.inputLogin("lozinka", "Admin123.",driver);
        UtilsTest.loginClickSubmitButton(driver);
        UtilsTest.findByText("Unesi novi sajam",driver);
        logOut();
    }

    @Test
    public void unsuccessfulLoginTestEmpty(){
        UtilsTest.loginClickSubmitButton(driver);
        String message = driver.findElement(By.xpath("//tbody//td//input[contains(@name, \"k_ime\")]")).getAttribute("validationMessage");
        Assert.assertEquals(message, "Please fill out this field.");
    }

    @Test
    public void unsuccessfulLoginTestInvalid(){
        UtilsTest.inputLogin("k_ime", "error",driver);
        UtilsTest.inputLogin("lozinka", "errorPass",driver);
        UtilsTest.loginClickSubmitButton(driver);
        UtilsTest.findByText("Pogresno korisnicko ime i/ili lozinka",driver);
    }

    @AfterClass
    public void finish(){
        driver.quit();
    }
}

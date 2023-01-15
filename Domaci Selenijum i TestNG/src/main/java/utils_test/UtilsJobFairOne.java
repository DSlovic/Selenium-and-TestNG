package utils_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UtilsJobFairOne {

    public static void logInAsAdmin(WebDriver driver){
        driver.get("http://localhost/projekat5/IP_projekat/login.php");
        UtilsTest.inputLogin("k_ime", "anci",driver);
        UtilsTest.inputLogin("lozinka", "Admin123.",driver);
        UtilsTest.loginClickSubmitButton(driver);
    }

    public static void inputsJobFairOne(String input, String value, WebDriver driver){
        String xpath = "//tbody//td//input[contains(@name, \"%s\")]";
        xpath = String.format(xpath, input);
        driver.findElement(By.xpath(xpath)).sendKeys(value);
    }

    public static void datesJobFairOne(String input, String value, WebDriver driver){
        String xpath = "//td/input[contains(@name, '%s')]";
        xpath = String.format(xpath, input);
        driver.findElement(By.xpath(xpath)).sendKeys(value);
    }

    public static void clickButtonNext(WebDriver driver){
        driver.findElement(By.xpath("//th/input[contains(@type, 'submit')]")).click();
    }
}

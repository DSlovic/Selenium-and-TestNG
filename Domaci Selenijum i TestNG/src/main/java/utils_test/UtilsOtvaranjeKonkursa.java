package utils_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class UtilsOtvaranjeKonkursa {
    public static void logInAsCompany(WebDriver driver){
        driver.get("http://localhost/projekat5/IP_projekat/login.php");
        UtilsTest.inputLogin("k_ime", "mobity",driver);
        UtilsTest.inputLogin("lozinka", "Sifra123$",driver);
        UtilsTest.loginClickSubmitButton(driver);
    }

    public static void inputsOtvaranjaKonkursa(String input, String value, WebDriver driver){
        String xpath = "//tbody//td//input[contains(@name, \"%s\")]";
        xpath = String.format(xpath, input);
        driver.findElement(By.xpath(xpath)).sendKeys(value);
    }

    public static void selectType(String type, WebDriver driver){
        driver.findElement(By.xpath("//td/select")).click();
        String xpath = "//td/select/option[contains(@name,'%s')]";
        xpath = String.format(xpath, type);
        driver.findElement(By.xpath(xpath)).click();
    }

    public static void clickButtonOpen(WebDriver driver){
        driver.findElement(By.xpath("//th/input[contains(@type, 'submit')]")).click();
    }
}

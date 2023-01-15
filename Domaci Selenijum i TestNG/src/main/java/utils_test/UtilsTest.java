package utils_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UtilsTest {
    public static void inputLogin(String input, String value, WebDriver driver){
        String xpath = "//tbody//td//input[contains(@name, \"%s\")]";
        xpath = String.format(xpath, input);
        driver.findElement(By.xpath(xpath)).sendKeys(value);
    }

    public static void loginClickSubmitButton(WebDriver driver){
        driver.findElement(By.xpath("//tbody//td//input[contains(@type, \"submit\")]")).click();
    }

    public static WebElement findByText(String text,WebDriver driver){
        String xpath = "//*[contains(text(), \"%s\")]";
        xpath = String.format(xpath, text);
        return driver.findElement(By.xpath(xpath));
    }

}

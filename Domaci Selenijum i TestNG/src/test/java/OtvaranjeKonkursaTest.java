import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils_test.UtilsOtvaranjeKonkursa;
import utils_test.UtilsTest;

public class OtvaranjeKonkursaTest {
    static WebDriver driver = new ChromeDriver();

    @BeforeMethod
    public void prep(){
        UtilsOtvaranjeKonkursa.logInAsCompany(driver);
        driver.get("http://localhost/projekat5/IP_projekat/konkurs_otvori.php");
    }

    @Test
    public void successfulCompetitionOpeningTest(){
        UtilsOtvaranjeKonkursa.selectType("posao",driver);
        UtilsOtvaranjeKonkursa.inputsOtvaranjaKonkursa("pozicija","Test sample competition",driver);
        driver.findElement(By.xpath("//td/textarea[contains(@name, 'tekst')]")).sendKeys("Test text sample for the competition opening");
        UtilsOtvaranjeKonkursa.inputsOtvaranjaKonkursa("rok","2023-02-01 12:00:00",driver);
        UtilsOtvaranjeKonkursa.clickButtonOpen(driver);
        UtilsTest.findByText("Uspesan unos",driver);//Application is supposed to show success message but there are some bugs in this functionality
    }
}

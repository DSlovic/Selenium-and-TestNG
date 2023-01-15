import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils_test.UtilsJobFairOne;
import utils_test.UtilsOtvaranjeKonkursa;
import utils_test.UtilsTest;

public class JobFairOneTest {

    static WebDriver driver = new ChromeDriver();

    @BeforeMethod
    public void prep(){
        UtilsJobFairOne.logInAsAdmin(driver);
        driver.get("http://localhost/projekat5/IP_projekat/sajam_unesi.php");
    }
    @Test
     public void successfulNewJobFairEntryStepOne(){
        UtilsJobFairOne.inputsJobFairOne("vreme_od","2023-02-01 12:00:00",driver);
        UtilsJobFairOne.inputsJobFairOne("vreme_do","2023-02-01 18:00:00",driver);
        UtilsJobFairOne.datesJobFairOne("cv_od","12-28-2022",driver);
        UtilsJobFairOne.datesJobFairOne("cv_do","01-26-2023",driver);
        UtilsJobFairOne.datesJobFairOne("ucesce_od","12-14-2022",driver);
        UtilsJobFairOne.datesJobFairOne("ucesce_do","12-28-2022",driver);
        UtilsJobFairOne.clickButtonNext(driver);
        UtilsTest.findByText("Unesi novi sajam: Korak 2",driver);//Test fails because of bug
    }
}

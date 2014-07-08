import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.runners.Suite;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

/**
 * Created by robbiebridgewater on 7/2/14.
 */
public class HomePageCheck {

    static WebDriver driver;

    //Create a generic string of the home location. This will allow me to run the same test on different sites by changing this string
    static String homeString;


    @BeforeClass
    public static void createDriver() {

        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        System.setProperty("webdriver.ie.driver","IEDriverServer.exe ");
        driver = new FirefoxDriver();
        //Logger needs to be turned off if using HTMLUnitDriver, as it gives many verbose statements
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.OFF);
    }

    @Before
    public void goHome() {
        //Temporary setting the homeString here
        // homeString = "http://cmcrossroads.com";
        // homeString="http://agileconnection.com";
        homeString = "http://stickyminds.com";
        //At the beginning of each test go to the home, have the same start point.
        driver.get(homeString);
    }
    @RunWith(Suite.class)
    @Suite.SuiteClasses({HomePageCheck.class})
    public class TestSuite {
    }

    @Test
    public void checkSummary() {
        //WebElement element1 = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[2]/div/p"));
        //Use * in xpath to avoid problems of SM
        //Find the first summay
      //  new WebDriverWait(driver, 100).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[1]/div/div[1]/*/div[2]/table/tbody/tr[1]/td[2]/div/p")));
        WebElement element1 = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/*/div[2]/table/tbody/tr[1]/td[2]/div/p"));
        String summary = element1.getText();
        //click the first item
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/*/div[2]/table/tbody/tr[1]/td[2]/a")).click();

        //Wait for things to load(long time for slow internet)
        new WebDriverWait(driver, 100).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("summary")));

        // System.out.println(test.getText());
        //Find the new summary
        WebElement element2 = driver.findElement(By.className("summary"));
        //Remove the string "Summary: " from the front
        String summary2 = element2.getText().substring(9);
        //The two summaries should be the same, if not say what each of them are
        assertEquals("" + summary + " vs " + summary2, summary, summary2);
    }


    @AfterClass
    public static void closeEverything() {
        driver.close();
        driver.quit();
    }
}

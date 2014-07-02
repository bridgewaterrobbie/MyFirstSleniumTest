import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;

/**
 * Created by robbiebridgewater on 7/2/14.
 */
public class HomePageCheck {

    static WebDriver driver;

    @BeforeClass
    public static void createDriver() {
        driver = new FirefoxDriver();
    }

    @Before
    public static void goHome() {
        String homeString;
        homeString = "cmcrossroads.com";
        //homeString="agileconnection.com";
        //homeString="stickyminds.com";

        driver.get(homeString);
    }

    @Test
    public void checkSummary() {
        WebElement summary = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[2]/div/p"));
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[2]/a")).click();
        WebElement summary2 = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/article/div[2]/div[1]/p"));
        assertEquals("" + summary.getText() + " vs " + summary2.getText(), summary.getText(), summary2.getText());
    }


}

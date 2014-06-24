/**
 * Created by robbiebridgewater on 3/5/14.
 */

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

//import static org.hamcrest.core.Is.is;
//import static org.hamcrest.core.IsNot.not;

public class MyFirstTest {
    static WebDriver driver;

    @BeforeClass
    public static void createDriver() {
        System.setProperty("webdriver.chrome.driver", " C:\\Users\\Robbie Bridgewater\\Documents\\chromedriver.exe");

        driver = new FirefoxDriver();
    }

    @AfterClass
    public static void closeEverything() {
        driver.close();
        driver.quit();
    }

    @Test
    public void HomePageGoAndCheckTitle() {
        driver.navigate().to("http://compendiumdev.co.uk/selenium");
        assertTrue("title should start with Selenium Simplified", driver.getTitle().startsWith("Selenium Simplified"));
    }

    @Test
    public void checkSearchPage() {
        driver.navigate().to("http://compendiumdev.co.uk/selenium/search.php");
        assertTrue("title should start with Selenium Simplified", driver.getTitle().startsWith("Selenium Simplified Search Engine"));
    }

    @Test
    public void backTest() {
        driver.navigate().back();
        assertTrue("title should start with Selenium Simplified", driver.getTitle().startsWith("Selenium Simplified"));
    }

    @Test
    public void forwardTest() {
        driver.get("http://compendiumdev.co.uk/selenium/search.php");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().forward();
        assertTrue("title should start with Selenium Simplified", driver.getTitle().startsWith("Selenium Simplified Search Engine"));
    }

    @Test
    public void refreshTest() {
        driver.navigate().to("http://compendiumdev.co.uk/selenium/refresh.php");
        //String test= driver.getTitle();
        driver.navigate().refresh();
        // Assert.assertFalse("Rereshes should not match",test==driver.getTitle());
    }

    @Test
    public void greaterTest() {
        //  driver.navigate().to("http://compendiumdev.co.uk/selenium/refresh.php");
        //"test".contains();
        long test = 1;
        assertThat("the answer", is(not("an answer")));

    }
}

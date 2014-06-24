import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

import static org.junit.Assert.assertEquals;

/**
 * Created by robbiebridgewater on 6/4/14.
 */
public class MySecondTest {
    static WebDriver driver;
    static String home = "http://www.compendiumdev.co.uk/selenium/find_by_playground.php#pName0";

    @BeforeClass
    public static void createDriver() {
        driver = new SafariDriver();
        driver.get(home);
    }

    @AfterClass
    public static void teardown() {
        driver.close();
        driver.quit();
    }

    @Test
    public void test1() {
        //driver.get(home);
        WebElement e = driver.findElement(By.xpath("//*[@id='p31']"));
        assertEquals("Matches", e.getAttribute("name"), "pName31");
    }

    @Test
    public void test2() {
        WebElement e = driver.findElement(By.xpath("//*[@name='ulName1']"));
        assertEquals("Matches", e.getAttribute("id"), "ul1");
    }

    @Test
    public void test3() {
        String atName = "id";
        String result = "div1";
        WebElement e = driver.findElement(By.xpath("//*[@class='specialDiv']"));
        String a = e.getAttribute(atName);
        assertEquals("Matches", a, result);
    }

    @Test
    public void test4() {
        String atName = "name";
        String result = "liName1";
        WebElement e = driver.findElement(By.xpath("//li"));
        String a = e.getAttribute(atName);
        assertEquals("Matches", a, result);
    }
}

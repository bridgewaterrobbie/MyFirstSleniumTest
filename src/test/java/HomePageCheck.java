import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.junit.Assert.assertEquals;

/**
 * Created by robbiebridgewater on 7/2/14.
 */
public class HomePageCheck {

    static WebDriver driver;

    @BeforeClass
    public static void createDriver() {
        driver = new HtmlUnitDriver();
    }

    @Before
    public void goHome() {
        String homeString;
        homeString = "http://cmcrossroads.com";
        //homeString="agileconnection.com";
        //homeString="stickyminds.com";

        driver.get(homeString);
    }

    @Test
    public void checkSummary() {
        WebElement summary = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[2]/div/p"));
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[2]/a")).click();
        WebElement test = driver.findElement(By.cssSelector("html.js body.html.not-front.not-logged-in.one-sidebar.sidebar-second.page-node.page-node-.page-node-183064.node-type-article.domain-agile.section-article.page-panels.section-article.page-panels.lightbox-processed div#page div#main div#content.column article.node-article.node div div.field.field-name-body.field-type-text-with-summary.field-label-hidden div.field-items div.field-item.even p"));
        System.out.println(test.getText());
        WebElement summary2 = driver.findElement(By.className("summary"));
        String text2 = summary2.getText().substring(9);
        assertEquals("" + summary.getText() + " vs " + text2, summary.getText(), text2);
    }

    @Test
    public void fasterTest() {
        driver.get("http://www.cmcrossroads.com/interview/security-testing-muggles-interview-paco-hope");
        WebElement sum = driver.findElement(By.className("summary"));
        System.out.println(sum.getText());
    }

    @AfterClass
    public static void closeEverything() {
        driver.close();
        driver.quit();
    }
}

package com.techwell.test;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

/**
 * Created by robbiebridgewater on 7/2/14.
 */
public class HomePageCheck {
    static WebDriver driver;
    static String homeString;


    //Create a generic string of the home location. This will allow me to run the same test on different sites by changing this string


    public static void main(String[] args) {
        if (args.length!=0)
        {
            homeString=args[0];
        }
        else
        {
            homeString = "http://www.stickyminds.com/";
        }
        org.junit.runner.JUnitCore.main("com.techwell.test.HomePageCheck");
    }

    @BeforeClass
    public static void createDriver() {
        driver = new FirefoxDriver();
        homeString = "http://www.stickyminds.com/";

        //Logger needs to be turned off if using HTMLUnitDriver, as it gives many verbose statements
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.OFF);
    }

    @Before
    public void goHome() {
        //At the beginning of each test go to the home, have the same start point.
        driver.get(homeString);
    }

    @Test
    public void checkSummary() {
        //WebElement element1 = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[2]/div/p"));
        //Use * in xpath to avoid problems of SM
        //Find the first summary
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

    @Test
    public void willFail()
    {
        //assertEquals(0,1);
    }

    @AfterClass
    public static void closeEverything() {
        driver.close();
        driver.quit();
    }
}

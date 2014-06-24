/**
 * Created by Robbie Bridgewater on 6/17/2014.
 */

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DilbertDownloader {
    static WebDriver driver;

    @Test
    public void Dilbert336() throws Exception {
        int max = 13147;
        driver = new FirefoxDriver();
        FileDownloader downloadTestFile = new FileDownloader(driver);
        String path = "http://dilbert.com/strips/comic/1989-04-16/";
        driver.get(path);
        String title;
        for (int i = 1; i < max; i++) {
            title = driver.getTitle();
            WebElement item = driver.findElement(By.cssSelector("html body div.SiteWrapper div.TransparentBackground.Content div.Col_A div.STR_Featured div.FeaturedStripWrapper div.STR_Container div.STR_Content div.STR_Image img"));
            WebElement next = driver.findElement(By.cssSelector("html body div.SiteWrapper div.TransparentBackground.Content div.Col_A div.STR_Featured div.FeaturedStripWrapper div.STR_Container div.STR_Header div.STR_Calendar a.STR_Next.PNG_Fix"));
            String downloadedFileAbsoluteLocation = downloadTestFile.downloadImage(item, "Dilbert/", "" + i);
            System.out.println(downloadedFileAbsoluteLocation);
            new Actions(driver).click(next).perform();
            //new WebDriverWait(driver,100000).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("html body div.SiteWrapper div.TransparentBackground.Content div.Col_A div.STR_Featured div.FeaturedStripWrapper div.STR_Container div.STR_Content div.STR_Image img"))));
            new WebDriverWait(driver, 100000).until(ExpectedConditions.not(ExpectedConditions.titleIs(title)));
        }

        driver.close();
        driver.quit();
    }

    @Test
    public void Garfield() throws Exception {
        int max = 13147;
        driver = new HtmlUnitDriver();
        FileDownloader downloadTestFile = new FileDownloader(driver);
        String path = "http://garfield.com/comic/2003-08-18";
        driver.get(path);
        String title;
        for (int i = 9191; i < max; i++) {
            title = driver.getTitle();
            WebElement item = driver.findElement(By.cssSelector("html.no-js body div#wrap div#container.container div#comic-banner.clearfix div#comic_wrap.img-polaroid img.img-responsive.center-block"));
            WebElement next = driver.findElement(By.cssSelector("html.no-js body div#wrap div#container.container div#comic-banner.clearfix div.row div.col-sm-5.mobile-text-center a.hidden-phone i.fa.fa-arrow-circle-right"));
            String downloadedFileAbsoluteLocation = downloadTestFile.downloadImage(item, "Garfield/", "" + i);
            System.out.println(downloadedFileAbsoluteLocation);
            new Actions(driver).click(next).perform();
            //new WebDriverWait(driver,100000).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("html body div.SiteWrapper div.TransparentBackground.Content div.Col_A div.STR_Featured div.FeaturedStripWrapper div.STR_Container div.STR_Content div.STR_Image img"))));
            new WebDriverWait(driver, 100000).until(ExpectedConditions.not(ExpectedConditions.titleIs(title)));
        }
        System.out.println(driver.getCurrentUrl());
        driver.close();
        driver.quit();
    }

}

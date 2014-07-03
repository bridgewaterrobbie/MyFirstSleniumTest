import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;

/**
 * Created by robbiebridgewater on 6/15/14.
 */

public class MyThirdTest {
    static WebDriver driver;
    static String home = "http://www.compendiumdev.co.uk/selenium/gui_user_interactions.html";

    @BeforeClass
    public static void createDriver() {
        driver = new FirefoxDriver();
        driver.get(home);
    }

    @AfterClass
    public static void teardown() {
        driver.close();
        driver.quit();
    }

    @Before
    public void refresh() {
        // driver.get(home);

    }

    @Test
    public void drag1() {
        WebElement box1 = driver.findElement(By.cssSelector("html body div.draganddrops div div#draggable1.draggable.ui-draggable"));
        WebElement box2 = driver.findElement(By.cssSelector("html body div.draganddrops div div#draggable2.draggable.ui-draggable"));
        WebElement drag1 = driver.findElement(By.cssSelector("html body div.draganddrops div div#droppable1.droppable.ui-droppable"));
        WebElement drag2 = driver.findElement(By.cssSelector("html body div.draganddrops div div#droppable2.droppable.ui-droppable"));
        WebElement text1 = drag1.findElement(By.cssSelector("p"));
        WebElement text2 = drag2.findElement(By.cssSelector("p"));

        // assertEquals(text1.getText(),"Drop here");
        Action firstOne = new Actions(driver).clickAndHold(box1).build();
        firstOne.perform();
        Action secondOne = new Actions(driver).release(drag1).build();
        secondOne.perform();
        assertEquals(text1.getText(), "Dropped!");
    }

    @Test
    public void drag2() {
        WebElement box1 = driver.findElement(By.cssSelector("html body div.draganddrops div div#draggable1.draggable.ui-draggable"));
        WebElement box2 = driver.findElement(By.cssSelector("html body div.draganddrops div div#draggable2.draggable.ui-draggable"));
        WebElement drag1 = driver.findElement(By.cssSelector("html body div.draganddrops div div#droppable1.droppable.ui-droppable"));
        WebElement drag2 = driver.findElement(By.cssSelector("html body div.draganddrops div div#droppable2.droppable.ui-droppable"));
        WebElement text = drag1.findElement(By.cssSelector("p"));

        //assertEquals(text.getText(),"Drop here");
        new Actions(driver).dragAndDrop(box2, drag1).perform();
        assertEquals(text.getText(), "Get Off Me!");
    }

    @Test
    public void bwaHa() {
        WebElement box1 = driver.findElement(By.cssSelector("html body div.draganddrops div div#draggable1.draggable.ui-draggable"));
        WebElement box2 = driver.findElement(By.cssSelector("html body div.draganddrops div div#draggable2.draggable.ui-draggable"));
        WebElement drag1 = driver.findElement(By.cssSelector("html body div.draganddrops div div#droppable1.droppable.ui-droppable"));
        WebElement drag2 = driver.findElement(By.cssSelector("html body div.draganddrops div div#droppable2.droppable.ui-droppable"));
        WebElement text1 = box1.findElement(By.cssSelector("p"));
        WebElement text2 = drag2.findElement(By.cssSelector("p"));

        assertEquals("Drag me", text1.getText());
        box2.sendKeys(Keys.chord(Keys.CONTROL, Keys.COMMAND, "b"));

        /*new Actions(driver).keyDown(Keys.CONTROL).perform();
        new Actions(driver).keyDown(Keys.COMMAND).perform();

        new Actions(driver).sendKeys("b").perform();
        new Actions(driver).sendKeys(Keys.NULL);*/

        assertEquals("Bwa! Ha! Ha!", text1.getText());
    }

    @Test
    public void adraw() {
        WebElement drawBox = driver.findElement(By.cssSelector("html body div canvas#canvas"));
        WebElement box2 = driver.findElement(By.cssSelector("html body div.draganddrops div div#draggable2.draggable.ui-draggable"));
        new Actions(driver).clickAndHold(drawBox).perform();

        for (int var = 0; var < 30; var++) {
            int x = (int) (Math.random() * 2) - 1;
            int y = (int) (Math.random() * 2) - 1;
            new Actions(driver).moveByOffset(x, y).perform();
        }
        new Actions(driver).release().perform();
    }

    @Test
    public void a2draw() {
        WebElement drawBox = driver.findElement(By.cssSelector("html body div canvas#canvas"));
        WebElement box2 = driver.findElement(By.cssSelector("html body div.draganddrops div div#draggable2.draggable.ui-draggable"));
        new Actions(driver).clickAndHold(drawBox).perform();

        for (int var = 0; var < 30; var++) {
            int x = (int) (Math.random() * 2) - 1;
            int y = (int) (Math.random() * 2) - 1;
            new Actions(driver).moveByOffset(x, y).perform();
        }
        new Actions(driver).release().perform();
    }

}

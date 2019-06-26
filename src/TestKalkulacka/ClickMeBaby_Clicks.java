package TestKalkulacka;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ClickMeBaby_Clicks extends MainTest {

    @Before
    public void openBaseUrl(){
    driver.get(getBASE_URL() + "clickmebaby.php");

    }
    @Test
    public void Test(){
        Assert.assertEquals("Inicialny pocet klikov", "0", driver.findElement(By.id("clicks")).getText());
        Assert.assertEquals("klikov",driver.findElement((By.className("description"))).getText());
        for (int i = 1; i < 21; i++) {
            driver.findElement(By.id("clickMe")).click();
            Assert.assertEquals(String.valueOf(i),driver.findElement(By.id("clicks")).getText());
            //System.out.println(driver.findElement(By.className("description")).getText()); //vypisanie do konzoly
            if (i==1){
                Assert.assertEquals("klik",driver.findElement((By.className("description"))).getText());
                System.out.println("Overujem jeden klik");
            }
            if (i>=2 && i<=4){
                Assert.assertEquals("kliky",driver.findElement((By.className("description"))).getText());
                System.out.println("Overujem 2-4 kliky");
            }
            if (i>=5){
                Assert.assertEquals("klikov",driver.findElement((By.className("description"))).getText());
                System.out.println("Overujem viac ako 4 kliky");
            }


        }
    }

}

package TestKalkulacka;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.testng.Assert;

public class FullTest_ClickMeBaby extends MainTest {

    @Before
    public void openBaseUrl(){
        driver.get(getBASE_URL() + "clickmebaby.php");
    }
    @Test
    public void test() {
        //System.out.print(driver.findElement(By.id("clicks")).getText());
        //jUnit framework
        //Check why this is not working:
        //Assert.assertEquals("Zaciatocny pocet klikov nesedi","0",driver.findElement(By.id("clicks")).getText()); //Ctrl+D kopiruje cely riadok pod aktualny
        Assert.assertEquals("0",driver.findElement(By.id("clicks")).getText());
        driver.findElement(By.id("clickMe")).click();
        Assert.assertEquals("1",driver.findElement(By.id("clicks")).getText());
        driver.findElement(By.id("clickMe")).click();
        Assert.assertEquals("2",driver.findElement(By.id("clicks")).getText());
        driver.findElement(By.id("clickMe")).click();
        Assert.assertEquals("3",driver.findElement(By.id("clicks")).getText());
        driver.findElement(By.id("clickMe")).click();
        Assert.assertEquals("4",driver.findElement(By.id("clicks")).getText());
        driver.findElement(By.id("clickMe")).click();
        Assert.assertEquals("5",driver.findElement(By.id("clicks")).getText()); //DRY (Dont repeat yourself)
    }


}

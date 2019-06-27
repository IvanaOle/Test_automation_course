package TestKalkulacka;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class CssSelector extends MainTest{

    @Before
    public void openUrl(){
        driver.get(getBASE_URL() + "stroopeffect.php");
    }

    @Test
    public void Test() {
        driver.findElement(By.cssSelector("button#count")).click();
        driver.findElement(By.cssSelector("#count")).click();//oznacenie ID #
        driver.findElement(By.cssSelector("button.btn-success")).click();//oznacenie triedy - class sa deje bodkou
    driver.get("http://localhost:8888/clickmebaby.php");
    driver.findElement(By.cssSelector("div.row>button")).click(); //tu si najde najprv classu div.row a v nom prvy button
    driver.findElement(By.cssSelector("div.container button")).click();//priame dieta rodica sa oznaci ako >
    }

}


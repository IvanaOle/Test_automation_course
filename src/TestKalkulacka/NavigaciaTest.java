package TestKalkulacka;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

public class NavigaciaTest {

    private String BASE_URL = "http:/localhost:8888";
    private WebDriver driver;

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
    }
    @Test
    public void test() {
        String expectedClass = "active";
        List<String> pages = new ArrayList<String>();
        pages.add("vybersi");
        pages.add("clickmebaby");
        pages.add("tabulka");
        pages.add("redalert");

//funcia iter sa pouzivat na iterovanie cez list
        for (String page : pages) {
            driver.get(BASE_URL + "/" + page + ".php");
            Assert.assertTrue(driver.findElement(By.xpath("//li[a/@href='" + page+ "']" ))
                    .getAttribute("class").contains(expectedClass));
        }

          }

      //  driver.get(BASE_URL+"/clickmebaby.php");
       // Assert.assertTrue(driver.findElement(By.xpath("//li[a/@href='clickmebaby.php']")).
               // getAttribute("class").contains(expectedClass));

       // driver.get(BASE_URL+"/tabulka.php");
        //Assert.assertTrue(driver.findElement(By.xpath("//li[a/@href='tabulka.php']")).
                //getAttribute("class").contains(expectedClass));

        //System.out.println(driver.findElement(By.xpath("//li[a/@href='vybersi.php']")).getAttribute("class"));



        ////li[a/@href='vybersi.php']


    @After
    public void tearDown(){

    }


}

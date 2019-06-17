package TestKalkulacka;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

public class TitleStranky {
    private String BASE_URL = "http://localhost:8888";
    private WebDriver driver;

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
    }
    @Test
    public void test(){
        driver.get(BASE_URL);


        List<WebElement> pages = driver.findElements(By.xpath("//nav//ul/li/a"));
        List<String> pageUrls = new ArrayList<>();
        for (WebElement page : pages) {
            pageUrls.add(page.getAttribute("href"));
        }
        for (String pageUrl : pageUrls) {
            driver.get(pageUrl);
            //funkcionalita ako vypisat resp. zmenit lower case na uppercase
            String expectedTitle= pageUrl.substring(pageUrl.lastIndexOf("/")+1,pageUrl.indexOf(".php"));
            System.out.println(expectedTitle.substring(0,1).toUpperCase()+expectedTitle.substring(1));
            Assert.assertTrue(driver.getTitle()
                    .contains(expectedTitle.substring(0,1).
                            toUpperCase()+expectedTitle.substring(1)));
            //System.out.println(driver.getTitle());
        }
        //System.out.println(driver.getTitle());

    }
    @After
    public void tearDown(){

    }

}

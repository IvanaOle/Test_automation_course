package TestKalkulacka;

import java.util.List;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TabulkaVerify {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8888/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testTabulkaVerify() throws Exception {
    driver.get(baseUrl + "/tabulka.php");
    assertEquals("1", driver.findElement(By.cssSelector("td")).getText());

    List<WebElement> rows = driver.findElements(By.xpath("//table//tbody/tr"));

    for (int i = 1; i < rows.size()+1; i++) {
      //Try catch block - nespadne test ak cosi, ale na konci len vypise chybu ak cosi najde
      try {
        assertEquals(String.valueOf(i), driver.findElement(By.xpath("//tr["+i+"]/td")).getText());
      }
      catch (Error e) {
        verificationErrors.append(e.toString());
      }

    }


    System.out.println("Overovanie tabulky hotove");
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

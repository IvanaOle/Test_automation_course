package ChromeBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchApplication {

    public static void main(String[] args)
    {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ivana.oleksakova\\Desktop\\playground\\Chrome\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://itesk-dev-005/#/login");
        System.out.println(driver.getTitle());

    }
}

package java8featuresinselenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class Demo2 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.in/");

        Set<String> windowids = driver.getWindowHandles();

        /**
        for(String winid:windowids)
        {
            System.out.println(driver.switchTo().window(winid).getCurrentUrl());
        }
         **/

        windowids.forEach(winid -> System.out.println(driver.switchTo().window(winid).getTitle()));


        driver.quit();




    }
}

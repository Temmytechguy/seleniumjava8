package java8featuresinselenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo4 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://demowebshop.tricentis.com/");
        driver.manage().window().maximize();

        List<WebElement> prodTitle = driver.findElements(By.xpath("//h2[@class='product-title']"));
        List<WebElement> prodPrices = driver.findElements(By.xpath("//div[@class='prices']"));

        Map<String, Double> products_map = new HashMap<String, Double>();

        //using java*

        for(int i =0; i < prodTitle.size();i++)
        {
            String title = prodTitle.get(i).getText();
            Double price = Double.parseDouble(prodPrices.get(i).getText());

            products_map.put(title,price);
        }

        /**
        //print map data using for each loop using java8
        for(Map.Entry<String, Double> entry:products_map.entrySet())
        {
            System.out.println(entry.getKey()+ " " + entry.getValue());
        }
**/
        //print hashmap using lambda express
        products_map.forEach((t,p) -> System.out.println(t + " " + p));

        //print product details whose price is >800
        System.out.println("Product whose price is greater than 800...");
        products_map.entrySet().stream().filter(e -> e.getValue() > 800)
               .forEach(price -> System.out.println(price));


        driver.quit();


    }
}

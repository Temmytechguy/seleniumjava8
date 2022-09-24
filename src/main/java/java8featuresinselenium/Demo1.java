package java8featuresinselenium;

//find number of links in a page
//print link texts from all links
//Check how many links doe snot have href attribute


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Demo1 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();

        webDriver.get("http://demowebshop.tricentis.com/");

        List<WebElement> links = webDriver.findElements(By.tagName("a"));
        System.out.println("Number of Links present on the page: " + links.size());

        for(WebElement link : links)
        {
            link.getText();

        }

        //lambda expression
        links.forEach(link -> System.out.println(link.getText()));

        //process and Filter the links based on href

       long workingLinks =  links.stream().filter(link -> link.getAttribute("href")!=null).count();
       System.out.println("Working links are: "+ workingLinks);

       webDriver.close();






    }
}

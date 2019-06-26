package test2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.Driver;
import java.util.Set;

public class Benefits {

    public static void main(String[] args) throws InterruptedException {



        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https:beyondfinance.com");



        WebElement loginButton = driver.findElement(By.xpath("(//a[contains(.,'Log In')])[1]"));
loginButton.click();


        String defaultWindow = driver.getWindowHandle();
        Set<String > childWindows = driver.getWindowHandles();
        Thread.sleep(3000);

        for (String child: childWindows){
            driver.switchTo().window(child);
            String title =driver.getTitle();
            System.out.println(title);
            if (title.equals("Beyond Client Portal")){
                driver.switchTo().window(child);
            }
        }

       // WebElement email = driver.findElement(By.xpath("(//input[@name='email']"));
        //  WebElement loginButton = driver.findElement(By.xpath("(//a[contains(.,'Log In')])[1]"));
        Thread.sleep(1000);
     //   String kk = "fdfd@gmail.com";

            JavascriptExecutor js = (JavascriptExecutor)driver;
   //js.executeScript("document.getElementsByName('email').value='gsdgds@gmail.com';");
        js.executeScript("document.getElementByClassName('form-control.').value='abppc@gmail.com';");
       // email.sendKeys(kk);
        WebElement continueEmail=driver.findElement(By.xpath("//button[@id='emailStep']"));
        continueEmail.click();

    }
}
//    JavascriptExecutor js = (JavascriptExecutor)driver;
//   js.executeScript("document.getElementById('s').value='Avinash Mishra';");
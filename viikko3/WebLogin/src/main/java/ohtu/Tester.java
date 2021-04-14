package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {

    public static void main(String[] args) {
        WebDriver driver = new HtmlUnitDriver();

        driver.get("http://localhost:4567");
        
                // tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource());
        
//        WebElement element = driver.findElement(By.linkText("login"));
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();

        // tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource());
        
        

        element = driver.findElement(By.name("username"));
//        element.sendKeys("pekka");
//        element.sendKeys("vaaratunnus");
        element.sendKeys("uusinTunnus6");
        element = driver.findElement(By.name("password"));
//        element.sendKeys("akkep");
//        element.sendKeys("vaarasalasana");
        element.sendKeys("uusinSalasana6");
        
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("uusinSalasana6");
        
//        element = driver.findElement(By.name("login"));
        element = driver.findElement(By.name("signup"));
        
        
        element.submit();
        
        
      
        System.out.println(driver.getPageSource());
        
          
        element = driver.findElement(By.linkText("continue to application mainpage"));
        
        
        element.click();


        System.out.println(driver.getPageSource());
        
          
        element = driver.findElement(By.linkText("logout"));
        
        
        element.click();
        
        
        System.out.println(driver.getPageSource());
        
        
        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}

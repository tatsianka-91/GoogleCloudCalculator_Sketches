import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GoogleCloudCalculator {

    public static void main (String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://cloud.google.com/");
        driver.manage().window().maximize();

        driver.manage().timeouts().setScriptTimeout(25,TimeUnit.SECONDS);
      

       new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='devsite-searchbox']/descendant::*[@name='q']")));

        WebElement searchInput=driver.findElement(By.xpath("//div[@class='devsite-searchbox']/descendant::*[@name='q']"));
       searchInput = waitForElementLocatedBy(driver, By.xpath("//div[@class='devsite-searchbox']/descendant::*[@name='q']"));
      searchInput.click();


      searchInput.sendKeys("Google Cloud Platform Pricing Calculator");
     searchInput.sendKeys(Keys.ENTER);

       new WebDriverWait(driver,10)
              .until(ExpectedConditions
                      .presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class, 'gs-bidi-start-align gs-snippet') and contains (., 'Google') and contains (., 'Cloud') and contains (.,'Platform') and contains (., 'Pricing') and contains (., 'Calculator')]")));

        List<WebElement> searchResults=driver.findElements(By.xpath("//div[contains(@class, 'gs-bidi-start-align gs-snippet') and contains (., 'Google') and contains (., 'Cloud') and contains (.,'Platform') and contains (., 'Pricing') and contains (., 'Calculator')]"));
       new WebDriverWait(driver, 10)
              .until (ExpectedConditions
               .presenceOfAllElementsLocatedBy(By.xpath("//a[@data-ctorig=\"https://cloud.google.com/products/calculator\"]")));
        List<WebElement> neededResult=driver.findElements(By.xpath("//a[@data-ctorig=\"https://cloud.google.com/products/calculator\"]"));
        neededResult.get(0).click();

       new WebDriverWait(driver,60)
              .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='compute-engine-block']/descendant::*[@ng-required='true' and @id='input_60']")));
      List<WebElement> instanceInputField=driver.findElements(By.xpath("//div[@class='compute-engine-block']/descendant::*[@ng-required='true' and @id='input_60']"));
        instanceInputField.get(0).click();



driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);





        driver.quit();
    }

    private static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
       WebElement searchInput;
        searchInput = new WebDriverWait(driver, 10)
              .until(ExpectedConditions.presenceOfElementLocated(by));
       return searchInput;
    }

}
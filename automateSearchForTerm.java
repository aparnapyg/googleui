package googleui.com.googleui;

import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

public class automateSearchForTerm {
	
	 private WebDriver driver; 
	 String appURL = "http://google.com";
	 
	@BeforeClass
	public void testSetUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Aparna\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to(appURL);
	}

  @DataProvider (name = "TermstoSearchFor")
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "test automation is awsome" }
    };
  }
  
  @Test(dataProvider = "TermstoSearchFor")
  public void searchForTermTest(String searchTerm) {
	  driver.navigate().to(appURL);
		String getTitle = driver.getTitle();

		WebElement srchBox = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input"));
		srchBox.sendKeys(searchTerm);
		srchBox.submit();
		
		//List<WebElement> allSearchResults=driver.findElements(By.cssSelector("ol li h3>a"));
		
		String allSearchResults=driver.getTitle();
		
        System.out.println(allSearchResults);
        
		//iterate the above list to get all the search titles & links from that page
//		for(WebElement eachResult : allSearchResults) {
//		System.out.println("Title : "+eachResult.getText()+", Link : "+eachResult.getAttribute("href"));
		}
		
//  }
}

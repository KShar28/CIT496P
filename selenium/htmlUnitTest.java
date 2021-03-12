import java.io.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.MalformedURLException;
import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;	
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.junit.Assert;

public class htmlUnitTest {				

	public static void main(String[] args) {

		// Creating a new instance of the HTML unit driver
		WebDriver driver = new HtmlUnitDriver(true); //enable JavaScript
		              
		// Navigate to local Jekyll site
		driver.get("http://localhost:4000");					
          
		// This code will test and print the page title
		String pageTitle = driver.getTitle();
		Assert.assertNotEquals(pageTitle, "");
		//Assert.assertFalse(pageTitle.matches("^\\s*$")); // uses regexp
		System.out.println("Page title is: " + pageTitle);

		// This code will check the HTML source for Jekyll 404 errors
		String pageSource = driver.getPageSource();
		Assert.assertFalse(pageSource.contains("404.html")); 
		Assert.assertFalse(pageSource.contains("requested page could not be found")); 

		// Create a test that is specific to YOUR Jekyll site here -->

	            HttpURLConnection huc = null;
	            int respCode = 1;
		   
		    String url = "https://github.com/KShar2892929292";
		    try {
                    	huc = (HttpURLConnection)(new URL(url).openConnection());
                        huc.setRequestMethod("HEAD");                
                        huc.connect();                
                        respCode = huc.getResponseCode();                
                        if(respCode >= 400){
                        	System.out.println(url+" is a broken link");
                        }
                        else{
                        	System.out.println(url+" is a valid link");
                        }
                    
                        } 
			catch (MalformedURLException e) {                          
                        	e.printStackTrace();
                        } catch (IOException e) {                          
                        	e.printStackTrace();
                        }
	
		// <-- End of your test code

		driver.quit();			
	}		
}

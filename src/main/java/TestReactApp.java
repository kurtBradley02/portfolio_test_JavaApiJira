import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import api.RunApi;

public class TestReactApp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		try {
	        // Setup ChromeDriver using WebDriverManager
	        WebDriverManager.chromedriver().setup();

	        // Create WebDriver instance
			WebDriver driver = new ChromeDriver();
			
			// Maximize the browser window
	        driver.manage().window().maximize();
			
	        // Navigate to JIRA
	        driver.get("http://localhost:3000/");
	        
	        Thread.sleep(2000);
	        //Click Sign In
	        driver.findElement(By.xpath("//*[@id=\"main-nav\"]/ul/li[4]/button")).click();
	        
	        Thread.sleep(2000);
	        //Enter Username
	        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("test username");
	        
	        Thread.sleep(2000);
	        //Enter Password
	        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("test password");
	        
	        Thread.sleep(2000);
	        driver.navigate().back();
	        
	        RunApi runApi = new RunApi();
	        
	        runApi.postCommentSuccess("all goods!","C:/Users/OneDrive/Desktop/report.html");
			
		}catch(Exception e) {
			RunApi runApi = new RunApi();
			
		}

	}

}

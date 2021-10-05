  package variousConcepts;



import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LearnTestNG {
  
  
	  WebDriver driver;
	 // String browser = "chrome";             *in selunium we can't run both browsers so we use  =>if(){}else if(){}
	 //String browser = "Firefox"; 
	  String browser = null;
	// String = url = null;
	
	  @BeforeSuite public void beforeSuite() {
	  System.out.println("I AM BEFORE SUITE"); }
	  
	  @BeforeTest public void beforeClass() {
	  System.out.println("I AM BEFORE CLASS"); }
	  
	  @BeforeClass public void readconfig() {
	  
	  Properties prop = new Properties(); 
	  //FileReader //InputStream
	  //BufferedReader //Scanner =>this four classes can read any type of file
	  
	  try { InputStream input = new FileInputStream("src\\main\\java\\config\\config.properties");
	  prop.load(input); 
	  browser = prop.getProperty("browser");
	  System.out.println("Used Browser: "+ browser);
	 // url = prop.getProperty("url");
	 // System.out.println("Used environment: " + url);
	  }catch(IOException e) { e.printStackTrace(); }
	  
	  
	  }
	 
	  
	  @BeforeMethod
	  
		public void init() {
		  
		  if(browser.equalsIgnoreCase("chrome")) {
			  
			  System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
				driver = new ChromeDriver(); 
			  
		  }else if(browser.equalsIgnoreCase("firefox")) {
			  
			  System.setProperty("webdriver.gecko.driver",".\\driver\\geckodriver.exe");
			    driver = new FirefoxDriver();
		  }
			
			    
			driver.get("https://techfios.com/billing/?ng=admin/");
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		}
		
		@Test(priority=2)
		public void loginTest1() {
			
			Assert.assertEquals("Login page not found!!", "Login - iBilling", driver.getTitle());
			
			//element liberary
			//1,storing web element
			WebElement USERNAME_FIELD_ELEMENT = driver.findElement(By.xpath("//input[@id='username']"));
			WebElement PASSWORD_FIELD_ELEMENT = driver.findElement(By.xpath("//*[@id=\"password\"]"));
			WebElement SIGNIN_BUTTON_ELEMENT = driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button"));
			
			 
			//driver.findElement(USERNAME_FIELD_LOCATER).sendKeys("demo@techfios.com");
			USERNAME_FIELD_ELEMENT.clear();
			USERNAME_FIELD_ELEMENT.sendKeys("demo@techfios.com");
		    PASSWORD_FIELD_ELEMENT.clear();
			PASSWORD_FIELD_ELEMENT.sendKeys("abc123");
			SIGNIN_BUTTON_ELEMENT.click();
			
			WebElement DASHBOARD_BUTTON_ELEMENT = driver.findElement(By.linkText("Dashboard"));
			String actualDashboardElement =  DASHBOARD_BUTTON_ELEMENT.getText();
		    Assert.assertEquals("Dashboard page not found!!", "Dashboard", actualDashboardElement);
			
			
		}	
		
		//@Test(priority=1)
		public void loginTest2() {
			
			Assert.assertEquals("Login page not found!!", "Login - iBilling", driver.getTitle());
			
			//element liberary
			//1,storing web element
			WebElement USERNAME_FIELD_ELEMENT = driver.findElement(By.xpath("//input[@id='username']"));
			WebElement PASSWORD_FIELD_ELEMENT = driver.findElement(By.xpath("//*[@id=\"password\"]"));
			WebElement SIGNIN_BUTTON_ELEMENT = driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button"));
			
			 
			//driver.findElement(USERNAME_FIELD_LOCATER).sendKeys("demo@techfios.com");
			USERNAME_FIELD_ELEMENT.clear();
			USERNAME_FIELD_ELEMENT.sendKeys("demo@techfios.com");
		    PASSWORD_FIELD_ELEMENT.clear();
			PASSWORD_FIELD_ELEMENT.sendKeys("abc123");
			SIGNIN_BUTTON_ELEMENT.click();
			
			WebElement DASHBOARD_BUTTON_ELEMENT = driver.findElement(By.linkText("Dashboard"));
			String actualDashboardElement =  DASHBOARD_BUTTON_ELEMENT.getText();
		    Assert.assertEquals("Dashboard page not found!!", "Dashboard", actualDashboardElement);
			
			
		}	
		
		
		@AfterMethod
		public void tearDown() {
			driver.close();
			driver.quit();
			
			
		
		
	
			
		}
		
		
		
	}
  
  
  
  
  
  
 
package basepack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseTest {
	
	static WebDriver driver;
	public static FileInputStream fis;
	public static String projectpath=System.getProperty("user.dir");
	public static Properties orprop;
	
	public static void init() throws IOException {
		
		fis=new FileInputStream(projectpath+"//or.properties");
		orprop=new Properties();
		orprop.load(fis);
		
	}
	
	
	public static void lunch(String browser) {
		
		if(browser.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver","E:\\SeleniumResource\\chromedriver.exe");
		 driver=new ChromeDriver();
		}
		else if(browser.equals("firefox")){
		System.setProperty("webdriver.gecko.driver","E:\\SeleniumResource\\geckodriver.exe");
		 driver=new FirefoxDriver();
		}
		else if(browser.equals("ie")) {
		
		System.setProperty("webdriver.ie.driver","E:\\SeleniumResource\\IEDriverServer.exe");
		driver=new InternetExplorerDriver();
		}
		else if(browser.equals("edge")) {
		System.setProperty("webdriver.edge.driver","E:\\SeleniumResource\\msedgedriver.exe");
		driver=new EdgeDriver();

		}
		
	}
	
		public static void navigateurl(String url) {
		
		
		driver.get("https://www.amazon.in/");
		
	}
		
		public static void SelecClick(String text) {
			getElement(text);
			
		}
		
		public static void Type(String loctorkey,String text) {
			getElement(loctorkey).sendKeys(text);
			
		}
		
		public static void SelectItem(String loctorkey,String value) {
			getElement(loctorkey).sendKeys(value);
			
		}
	
		
		public static WebElement getElement(String loctorkey) {
			
			WebElement element=null;
			
			if(loctorkey.endsWith("_id")) {
			element=driver.findElement(By.id(orprop.getProperty(loctorkey)));
			} 
			else if(loctorkey.endsWith("_name")) {
			element=driver.findElement(By.name(orprop.getProperty(loctorkey)));
			}
			else if(loctorkey.endsWith("_className")) {
			element=driver.findElement(By.className(orprop.getProperty(loctorkey)));
			}
			else if(loctorkey.endsWith("_xpath")) {
				element=driver.findElement(By.xpath(orprop.getProperty(loctorkey)));
			}
			else if(loctorkey.endsWith("_cssSelector")) {
				element=driver.findElement(By.cssSelector(orprop.getProperty(loctorkey)));
			}
			else if(loctorkey.endsWith("_linktext")) {
			
			element=driver.findElement(By.linkText(orprop.getProperty(loctorkey)));
			}
			else if(loctorkey.endsWith("_partiallinktext")) {
			element=driver.findElement(By.partialLinkText(orprop.getProperty(loctorkey)));
			}
	
			return element;
			
		}
		
		
}

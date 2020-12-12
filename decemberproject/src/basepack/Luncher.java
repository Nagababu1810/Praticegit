package basepack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Luncher {

	static WebDriver driver;
	public static String projectpath=System.getProperty("user.dir");
	
	
	public static void main(String[] args) {
	
		
		System.setProperty("webdriver.chrome.driver","E:\\SeleniumResource\\chromedriver.exe");
		 driver=new ChromeDriver();
		
		System.setProperty("webdriver.gecko.driver","E:\\SeleniumResource\\geckodriver.exe");
		 driver=new FirefoxDriver();
		
		System.setProperty("webdriver.ie.driver","E:\\SeleniumResource\\IEDdriverServer.exe");
		driver=new InternetExplorerDriver();
		
		System.setProperty("webdriver.edge.driver","E:\\SeleniumResource\\msedgedriver.exe");
		driver=new EdgeDriver();

	}

}

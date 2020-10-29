package praticelinks;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;





public class RahulShettyPratice {

	
	static WebDriver driver;
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "E:\\SeleniumResource\\Chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		System.out.println("sucessful browser lanuched");
	}
	
	@Test(priority=01)
	public void radioButton() {
		
	
		WebElement rbtn=driver.findElement(By.xpath("//label[@for='radio2']/input[@name='radioButton']"));
	
		rbtn.click();
		
		if(rbtn.isSelected())
		{
			System.out.println("radio button clicked");
		}
	
		else {
			System.out.println("radio button not clicked");
	
		}
	}
	@Test(priority=02)
	public void textwrite() {
		
		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("nagababu");
	}
	@Test
	public void dropdown() {
		
		Select dp=new Select(driver.findElement(By.xpath("//select[@id='dropdown-class-example']")));
	
		dp.selectByVisibleText("Option3");
		
		
	}
	@Test(priority=03)
	public void checkbox() {
		
		WebElement chk=driver.findElement(By.xpath("//label[@for='honda']/input[@name='checkBoxOption3']"));
		
		chk.click();
		
		if(chk.isSelected()) {
			System.out.println("check box clicked");
		}
		else {
			System.out.println("check box not clicked");
		}
	}
	@Test(priority=04)
	public void window() {
		
		driver.findElement(By.xpath("//button[@id='openwindow']")).click();
		
	}
	
	@Test(priority=05)
	public void newtab() {
		
		driver.findElement(By.linkText("Open Tab")).click();
	}
	@Test(priority=06)
	public void alert() {
		
		driver.switchTo().defaultContent();
		driver.findElement(By.cssSelector("input[id='name']")).sendKeys("nagababu");
		
		driver.findElement(By.id("alertbtn")).click();
		driver.switchTo().alert().accept();
		//driver.switchTo().alert().getText();
		
		driver.findElement(By.id("confirmbtn")).click();
		driver.switchTo().alert().dismiss();
		
	}
	@Test(priority=07)
	public void webtable()
	{
		
		WebElement table=driver.findElement(By.xpath("//table[@id='product']"));
	
		List<WebElement> rows=table.findElements(By.tagName("tr"));
		
		for( WebElement row:rows)
		{
			System.out.println(row.getText());
		}
	}
	@Test(priority=8)
	public void elementdisplayed() {
		
		driver.findElement(By.id("displayed-text")).sendKeys("my message");
		driver.findElement(By.id("show-textbox")).click();
		driver.findElement(By.id("hide-textbox")).click();
		
	}
	@Test(priority=9)
	public void mouseover() throws Exception {
		
		driver.findElement(By.xpath("//button[@id='mousehover']")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Top")).click();
		System.out.println("successful mouse overed");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='mousehover']")).click();
		driver.findElement(By.linkText("Reload")).click();
		
	}
	@Test(priority=10)
	public void iframes() {
		driver.switchTo().frame("courses-iframe");
		WebElement course=driver.findElement(By.linkText("Courses"));
		JavascriptExecutor js=(JavascriptExecutor)(driver);
		js.executeScript("arguments[0].click()",course);
		driver.navigate().refresh();
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		//driver.navigate().back();
		//WebElement course1=driver.findElement(By.cssSelector("img[alt*='Mobile Automation Testing from Scratch']"));
		//js.executeScript("arguements[0].click()",course1);
		//driver.navigate().refresh();
		
		///html/body/app-root/div/app-home/div/section[2]/div[1]/div[2]/div[6]/div/div[2]/div[1]/h2/a
//		WebDriverWait wait=new WebDriverWait(driver,30);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text()='VIEW ALL COURSES')]")));
//		Actions act=new Actions(driver);
//		
//		WebElement ele=driver.findElement(By.xpath("//a[contains(text(),'VIEW ALL COURSES')]"));
//		act.moveToElement(ele).click().perform();
	}
	@AfterClass
	public void teardown() {
		driver.quit();
		System.out.println("successful closed");
	}
}

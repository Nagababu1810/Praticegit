package praticelinks;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class Automationpratice {

	public static WebDriver driver;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "E:\\SeleniumResource\\Chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/?m=1");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		System.out.println("sucessful browser lanuched");
	}

	 //@Test(priority=01)
	public void newwindow() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("selenium");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String win = driver.getWindowHandle();
		driver.switchTo().window(win);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Selenium dioxide")).click();
		driver.switchTo().defaultContent();
		System.out.println("successful forward another window");

	}

	 //@Test(priority=02)
	public void alert() {

		// WebDriverWait wait=new WebDriverWait(driver,40);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Click
		// Me")));
		driver.findElement(By.xpath("//button[text()='Click Me']")).click();
		driver.switchTo().alert().accept();
		// System.out.println(al.getText());

		System.out.println("successful clicked");

	}

	 //@Test(priority=03)
	public void datepicker() {

		// driver.switchTo().defaultContent();
		driver.findElement(By.id("datepicker")).click();
		// driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();
		driver.findElement(By.linkText("30")).click();
		System.out.println("successful date selected");

	}

	//@Test(priority=04)
	public void selectmenu() throws InterruptedException {

		Select s1 = new Select(driver.findElement(By.id("speed")));
		s1.selectByVisibleText("Fast");

		s1.getFirstSelectedOption().getText();

		Thread.sleep(3000);

		Select s2 = new Select(driver.findElement(By.id("files")));
		s2.selectByIndex(3);
		s2.getFirstSelectedOption().getText();

		Thread.sleep(3000);
		Select s3 = new Select(driver.findElement(By.id("products")));
		s3.selectByVisibleText("Iphone");
		s3.getFirstSelectedOption().getText();

		Thread.sleep(3000);
		Select s4 = new Select(driver.findElement(By.id("animals")));
		s4.selectByVisibleText("Big Baby Cat");

		s4.getFirstSelectedOption().getText();

	}

	 //@Test(priority=05)
	public void textlables() throws InterruptedException {

		System.out.println(driver.findElement(By.xpath("//span[text()='Message_12']")).getText());
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath("//span[text()='Message-123']")).getText());
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath("//span[text()='Message $ 1234']")).getText());
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath("//span[text()='Message **** 12345']")).getText());
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath("//span[text()='Message &&&123456']")).getText());
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath("//span[text()='Message#### 1234567']")).getText());

	}

	 //@Test(priority=06)
	public void xpathaxes() throws Exception {

		driver.findElement(By.xpath("//empid[text()='101']")).getText();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//name[text()='David']")).getText();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//designation[text()='Senior Engineer']")).getText();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//email[text()='david@myemail.com']")).getText();
		Thread.sleep(3000);

		System.out.println(driver.findElement(By.xpath("//employee[@id='2']/empid[text()='102']")).getText());
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//employee[@id='2']/name[text()='John']")).getText());
		Thread.sleep(2000);
		System.out.println(
				driver.findElement(By.xpath("//employee[@id='2']/designation[text()='DBA Engineer']")).getText());
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//email[text()='john@email.com']")).getText());
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//empid[text()='103']")).getText());
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//employee[@id='3']/name[text()='Marry']")).getText());
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//designation[text()='Application Developer']")).getText());
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//email[text()='marry@email.com']")).getText());

	}

	 //@Test(priority=07)
	public void signup() throws InterruptedException, IOException {

		driver.switchTo().frame("frame-one1434677811");

		driver.findElement(By.xpath("//input[@id='RESULT_TextField-1']")).sendKeys("naga");
		

		driver.findElement(By.xpath("//input[@id='RESULT_TextField-2']")).sendKeys("babu");
		
		driver.findElement(By.xpath("//input[@id='RESULT_TextField-3']")).sendKeys("839873938");
	
		driver.findElement(By.xpath("//input[@id='RESULT_TextField-4']")).sendKeys("India");
		
		driver.findElement(By.xpath("//input[@id='RESULT_TextField-5']")).sendKeys("kakinada");
		
		driver.findElement(By.xpath("//input[@name='RESULT_TextField-6']")).sendKeys("mdd@gmail.com");
		driver.findElement(By.xpath("//label[@for='RESULT_RadioButton-7_0']")).click();
		
		driver.findElement(By.xpath("//label[@for='RESULT_CheckBox-8_0']")).click();
		
		driver.findElement(By.xpath("//label[@for='RESULT_CheckBox-8_4']")).click();
		
		WebElement btime = driver.findElement(By.xpath("//select[@id='RESULT_RadioButton-9']"));

		Select sle = new Select(btime);
		sle.selectByVisibleText("Afternoon");
	}

	@Test(priority=8)
	public void upload() throws Exception {

		driver.findElement(By.className("file_upload")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\Nag\\Documents\\fileupload1.exe");

	}

	 //@Test(priority=9)
	public void clink() throws InterruptedException {

		
		driver.findElement(By.linkText("Software Testing Tutorials")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.linkText("Software Testing Tools Training")).click();
	
		driver.findElement(By.id("FSsubmit")).click();
	}

	 //@Test(priority=10)
	public void doubleclk() {
		 driver.switchTo().defaultContent();
		 //driver.switchTo().frame("frame-one1434677811");
		Actions act = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//button[text()='Copy Text']"));

		act.moveToElement(ele).click().build().perform();
		System.out.println("sucessful clicked");
	}

	// @Test(priority=11)
	public void dranganddrop() {

		Actions act = new Actions(driver);
		WebElement ele1 = driver.findElement(By.id("draggable"));

		WebElement ele2 = driver.findElement(By.id("droppable"));

		act.dragAndDrop(ele1, ele2).build().perform();
		System.out.println("successful droped");

	}

	 //@Test(priority=12)
	public void dranganddropimg() throws InterruptedException {

		WebElement img1 = driver.findElement(By.xpath("//img[@alt='the peaks of high tatras']"));
		WebElement img2 = driver.findElement(By.cssSelector("img[alt$='mountain lake']"));

		//WebElement targetplace = driver.findElement(By.id("trash"));
		WebElement drop = driver.findElement(By.xpath("//div[@id='trash']"));

		Actions act = new Actions(driver);
		act.dragAndDrop(img1, drop).build().perform();
		Thread.sleep(2000);
		act.dragAndDrop(img2, drop).build().perform();
		System.out.println("successful trashed");

	}

	 //@Test(priority=13)
	public void slider() {

		WebElement slide = driver.findElement(By.id("slider"));

		Actions act = new Actions(driver);

		act.dragAndDropBy(slide, 100, 0);
		System.out.println("successful moved");
	}

	 //@Test(priority=14)
	public void resize() {
		Actions act = new Actions(driver);
		WebElement size = driver
				.findElement(By.xpath("//div[@id='resizable']/div[contains(@class,'gripsmall-diagonal-se')]"));

		// act.moveToElement(size).build().perform();
		act.dragAndDropBy(size, 100, 0).build().perform();
		System.out.println("sucessful resized");

	}

	//@Test(priority = 15)
	public void htmltable() {
		
		driver.switchTo().defaultContent();
		//System.out.println(driver.findElement(By.xpath("//*[@id=\"HTML1\"]/div[1]/table/tbody/tr[5]/td[1]")).getText());
		//System.out.println(driver.findElement(By.xpath("//table/tbody/tr[5]")).getText());

		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");

		WebElement mytable = driver.findElement(By.id("HTML1"));

		List<WebElement> tds = mytable.findElements(By.tagName("tr"));

		for (WebElement td : tds) {
			System.out.println(td.getText());
		}

	}

	//@Test(priority = 16)
	public void tooltip() {

		String emsg = driver.findElement(By.id("age")).getAttribute("title");
		System.out.println(emsg);

	}

	//@Test(priority = 17)
	public void barcode() throws Exception {

		String barcodeurl = driver.findElement(By.xpath("//div[@class='widget-content']//img[2]")).getAttribute("src");

		// String barcodeurl =
		// driver.findElement(By.xpath("//div[@id='HTML12']/div/img[1]")).getAttribute("src");
		System.out.println(barcodeurl);

		URL url = new URL(barcodeurl);

		BufferedImage bufferedimage = ImageIO.read(url);

		LuminanceSource luminancesource = new BufferedImageLuminanceSource(bufferedimage);

		BinaryBitmap binarybitmap = new BinaryBitmap(new HybridBinarizer(luminancesource));

		Result result = new MultiFormatReader().decode(binarybitmap);

		System.out.println(result.getText());

	}

	//@Test(priority = 18)
	public void qrcode() throws Exception {

		String qrcodeurl = driver
				.findElement(By.xpath("//div[@class='widget-content']/img[contains(@src,'qrcode.png')]"))
				.getAttribute("src");

		System.out.println(qrcodeurl);

		URL url = new URL(qrcodeurl);

		BufferedImage bufferedimage = ImageIO.read(url);

		LuminanceSource luminasource = new BufferedImageLuminanceSource(bufferedimage);

		BinaryBitmap binarybitmap = new BinaryBitmap(new HybridBinarizer(luminasource));

		Result result = new MultiFormatReader().decode(binarybitmap);
		System.out.println(result);

	}

	@AfterClass
	public void teardown() {
		driver.quit();
		System.out.println("successful closed");
	}

}

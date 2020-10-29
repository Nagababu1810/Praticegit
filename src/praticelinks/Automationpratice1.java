package praticelinks;

import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class Automationpratice1{
	WebDriver driver;
	
	
	@BeforeClass
	public void setup() {
	System.setProperty("webdriver.chrome.driver","E:\\SeleniumResource\\Chromedriver.exe");
	driver=new ChromeDriver();
	driver.get("https://testautomationpractice.blogspot.com/?m=1");
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
	System.out.println("sucessful browser lanuched");
	}
	
	
	
	@Test(priority=01)
	public void htmltable() {
		
		System.out.println(driver.findElement(By.xpath("//*[@id=\"HTML1\"]/div[1]/table")).getText());
		System.out.println(driver.findElement(By.xpath("//table/tbody/tr[5]")).getText());
		
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
		
		WebElement mytable=driver.findElement(By.id("HTML1"));
		
		List <WebElement> tds=mytable.findElements(By.tagName("tr"));
		
		for(WebElement td:tds) {
			System.out.println(td.getText());
		}
		
	}
	@Test(priority=02)
	public void tooltip() {
		
		String emsg=driver.findElement(By.id("age")).getAttribute("title");
		System.out.println(emsg);
		
		
	}
	
	@Test(priority=03)
	public void barcode() throws Exception  {
	
		
		 String barcodeurl=driver.findElement(By.xpath("//div[@class='widget-content']//img[2]")).getAttribute("src");

		//String barcodeurl = driver.findElement(By.xpath("//div[@id='HTML12']/div/img[1]")).getAttribute("src");
		System.out.println(barcodeurl);

		URL url = new URL(barcodeurl);

		BufferedImage bufferedimage = ImageIO.read(url);

		LuminanceSource luminancesource = new BufferedImageLuminanceSource(bufferedimage);

		BinaryBitmap binarybitmap = new BinaryBitmap(new HybridBinarizer(luminancesource));

		Result result = new MultiFormatReader().decode(binarybitmap);

		System.out.println(result.getText());
	
	}
	@Test(priority=04)
	public void qrcode() throws Exception {
		
		
		String qrcodeurl=driver.findElement(By.xpath("//div[@class='widget-content']/img[contains(@src,'qrcode.png')]")).getAttribute("src");
		
		System.out.println(qrcodeurl);
		
		
		URL url=new URL(qrcodeurl);
		
		BufferedImage bufferedimage=ImageIO.read(url);
		
		LuminanceSource luminasource=new BufferedImageLuminanceSource(bufferedimage);
		
		BinaryBitmap binarybitmap=new BinaryBitmap(new HybridBinarizer(luminasource));
		
		Result result=new MultiFormatReader().decode(binarybitmap);
		System.out.println(result);
		
	}
	
	
	
	//@Test(priority=05)
	public void upload() throws Exception {

		driver.switchTo().frame("frame-one1434677811");
		driver.findElement(By.xpath("//div[@class='inline_answer']/input[@id='RESULT_FileUpload-10']")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\Nag\\Documents\\fileupload1.exe");
	
	}
	@AfterClass
	public void teardown() {
	driver.quit();
	System.out.println("successful closed");
	}
	
}

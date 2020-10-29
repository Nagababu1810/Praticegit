package Fileuploading;

import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Fupload {

	public static void main(String[] args) throws IOException, InterruptedException {
	
		System.setProperty("webdriver.chrome.driver","E:\\SeleniumResource\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://demo.automationtesting.in/FileUpload.html");
		driver.manage().window().maximize();
		
		//driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		
		//driver.findElement(By.xpath("//*[@id='input-4']")).click();
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("document.getElementById('input-4').click()");
		System.out.println("it is click on the element");
		
		Thread.sleep(3000);
		
		Runtime.getRuntime().exec("C:\\Users\\Nag\\Documents\\fileupload.exe");
		System.out.println("succeful upload file");

	}

}

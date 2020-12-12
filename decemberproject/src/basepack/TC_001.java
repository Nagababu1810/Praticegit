package basepack;

import java.io.IOException;

import org.openqa.selenium.By;

public class TC_001 extends BaseTest {

	public static void main(String[] args) throws IOException {
	
		init();
		
		lunch("chrome");
		
		navigateurl("url");
		
		
		driver.manage().window().maximize();
		
		String title=driver.getTitle();
		System.out.println(title);
		
		
		
		
		SelectItem("amazonsearchdropdown_id","Books");
		//driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
		Type("amazonsearchtextbox_xpath","Novels");
		//driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Novels");
		
		SelecClick("amazonclick_xpath");
		//driver.findElement(By.xpath("//span[@id='nav-search-submit-text']//input[@class='nav-input']")).click();
		
		
	}



}

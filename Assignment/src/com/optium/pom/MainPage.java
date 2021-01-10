package com.optium.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class MainPage {

	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']") public WebElement serchbox;
	@FindBy(xpath="//input[@id='nav-search-submit-button']") public WebElement serchtext;
	@FindBy(xpath="//span[text()='Samsung Galaxy M21 (Midnight Blue, 4GB RAM, 64GB Storage)']") public WebElement selectlink;
	
	@FindBy(xpath="(//div[@class='a-section a-spacing-none']/h2/a//span[text()='Samsung Galaxy M51 (Celestial Black, 8GB RAM, 128GB Storage)'])[1]") public WebElement title_section;
	@FindBy(xpath="((//div[@id='averageCustomerReviews'])[1]//span[@id='acrPopover']//span)[1]") public WebElement rating;
	
	//@FindBy(id="averageCustomerReviews_feature_div") public WebElement reviewmsg;
	public MainPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	


	public void SearchAmozenProduct() throws InterruptedException {
	
	serchbox.click();	
	serchbox.sendKeys("sumsung");
	serchtext.click();
	Thread.sleep(2000);
	
	
	selectlink.click();
	Thread.sleep(5000);
	String titletxt=title_section.getText();
	System.out.println(titletxt);
	
	
	}
	
	
	
	

}
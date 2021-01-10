package com.optium.BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.optium.pom.MainPage;

public class BaseTest {
	
	public static WebDriver driver;
	public static String Projectpath = System.getProperty("user.dir");
	
	public static void lunchbrowser()
	{
	
	System.setProperty("webdriver.chrome.driver",Projectpath +"//Drivers//chromedriver.exe");
	driver=new ChromeDriver();
	
	}
	public static void navigateurl() 
	{
		
	driver.get("https://www.amazon.in/");	
	
	driver.manage().window().maximize();
	}
	
	public static void MainTest() throws InterruptedException
	{
		MainPage mp=new MainPage(driver);
		mp.SearchAmozenProduct();
		
	}
	
	}

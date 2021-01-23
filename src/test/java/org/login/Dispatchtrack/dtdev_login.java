/**
 * 
 */
package org.login.Dispatchtrack;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import packages.Login;

/**
 * @author acer
 *
 */
public class dtdev_login {
	WebDriver wd;
	String sheeturl="G://DTD_Project//Excel//Login.xlsx";
	Login lo=new Login();
	@Parameters("Browser")
	@Test(priority=1)
	public void browser_launch(String browsername)
	{
		if (browsername.equalsIgnoreCase("Chrome")) {
			ChromeOptions co = new ChromeOptions();
			co.addArguments("disable-extensions");
			co.addArguments("disable-infobars");
			co.addArguments("--start-maximized");
			System.setProperty("webdriver.chrome.driver",
					"G://Selenium_Setup//chromedriver//chromedriver_2.33//chromedriver.exe");
			wd = new ChromeDriver(co);
			wd.manage().window().maximize();
		} else if (browsername.equalsIgnoreCase("Firefox")) {
			ProfilesIni p = new ProfilesIni();
			FirefoxProfile fo = p.getProfile("SocialNetwork");
			wd = new FirefoxDriver(fo);
			wd.manage().window().maximize();
		} else if (browsername.equalsIgnoreCase("MicrosoftEdige")) {
			System.setProperty("webdriver.edge.driver",
					"G://Selenium_Setup//Microsoft_Edge//5.1//MicrosoftWebDriver.exe");
			wd = new EdgeDriver();
			wd.manage().window().maximize();
			System.out.println("Develop_Branch_1");
			System.out.println("Develop_Branch_2");
			System.out.println("Develop_Branch_3");
			System.out.println("Develop_Branch_4");
		}
	}
	@Parameters("instance_dtd")
	@Test(priority=2,enabled=false)
	public void DTD_Login_multiplelogins(String instance) throws IOException, InterruptedException
	{
		String sheetname="dtdev";
		lo.open_Exccel(sheeturl);
		int users_count=lo.totl_no_of_users("dtdev");
		
		if (instance.equalsIgnoreCase("dtdev")) {
			for(int i=1;i<(users_count-5);i++)
			{
			wd.navigate().to("https://dtdev.dispatchtrack.com");
			String login=lo.read_Data(sheetname,i,0);
			String pwd=lo.read_Data(sheetname,i,1);
			wd.findElement(By.id("email")).sendKeys(login);
			wd.findElement(By.id("password")).sendKeys(pwd);
			wd.findElement(By.name("commit")).sendKeys(Keys.RETURN);
			WebDriverWait wdw=new WebDriverWait(wd, 10);
			WebElement login_name=wdw.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='navbar']/ul[2]/li/a/p")));
			String lname=login_name.getText();
			lo.write_data("dtdev", i, 2, lname);
			wd.findElement(By.className("profile-link")).click();
			new WebDriverWait(wd,3).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='navbar']/ul[2]/ul/li[2]/a")));
			wd.findElement(By.xpath("//*[@id='navbar']/ul[2]/ul/li[2]/a")).click();
			/*new WebDriverWait(wd,3).until(ExpectedConditions.presenceOfElementLocated(By.id("email")));*/
			}
			lo.close_excel(sheeturl);
		} else if (instance.equalsIgnoreCase("dtrelease")) {
			String login=lo.read_Data(sheetname,1,0);
			String pwd=lo.read_Data(sheetname,1,1);
			wd.navigate().to("https://dtrelease.dispatchtrack.com");
			wd.findElement(By.id("email")).sendKeys(login);
			wd.findElement(By.id("password")).sendKeys(pwd);
			wd.findElement(By.name("commit")).sendKeys(Keys.RETURN);
			lo.close_excel(sheeturl);
		} else if (instance.equalsIgnoreCase("dtmaster")) {
			String login=lo.read_Data(sheetname,1,0);
			String pwd=lo.read_Data(sheetname,1,1);
			wd.navigate().to("https://dtmaster.dispatchtrack.com");
			wd.findElement(By.id("email")).sendKeys(login);
			wd.findElement(By.id("password")).sendKeys(pwd);
			wd.findElement(By.name("commit")).sendKeys(Keys.RETURN);
			lo.close_excel(sheeturl);
		}
		
	}
	@Parameters("instance_dtd")
	@Test
	public void DTLogin() throws IOException
	{
		String sheetname="dtdev";
		lo.open_Exccel(sheeturl);
		int users_count=lo.totl_no_of_users("dtdev");
		wd.navigate().to("https://dtdev.dispatchtrack.com");
		String login=lo.read_Data(sheetname,1,0);
		String pwd=lo.read_Data(sheetname,1,1);
		wd.findElement(By.id("email")).sendKeys(login);
		wd.findElement(By.id("password")).sendKeys(pwd);
		wd.findElement(By.name("commit")).sendKeys(Keys.RETURN);
		WebDriverWait wdw=new WebDriverWait(wd, 10);
		WebElement login_name=wdw.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='navbar']/ul[2]/li/a/p")));
	}

}

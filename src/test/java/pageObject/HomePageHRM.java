package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageHRM extends Basepage {

	public HomePageHRM(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	// 
	@FindBy(xpath="//button[@type='submit']")
	WebElement sign;
	
	public void Enterusername(String user) {
		username.sendKeys(user);
	}
	
	public void Enterpassword(String pwd) {
		password.sendKeys(pwd);
	}
	public void Sign() {
		sign.click();
	}
	
	
}

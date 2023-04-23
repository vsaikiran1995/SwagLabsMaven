package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver pageDriver;
	
	
	@FindBy(id = "user-name")
	WebElement userName;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(id = "login-button")
	WebElement loginBtn;
	
	public LoginPage(WebDriver driver) {
		pageDriver = driver;
		PageFactory.initElements(pageDriver, this);
	}

	public void LoginFunction(String userName, String pwd) {
		
		this.userName.sendKeys(userName);
		password.sendKeys(pwd);
		loginBtn.click();
	}


}

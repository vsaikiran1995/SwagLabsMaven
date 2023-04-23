package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import pages.LoginPage;

public class LoginTest extends BaseClass {

	@Test
	public void validLogin() throws FilloException, InterruptedException {
		Recordset recordset = connection.executeQuery("select *from data where TestName='validLogin'");
		recordset.next();
		String UserName = recordset.getField("UserName");
		String Password = recordset.getField("Password");
		
		LoginPage login = new LoginPage(driver);
		login.LoginFunction(UserName, Password);
		WebElement homePage = driver.findElement(By.xpath("//span[text()='Products']"));
		String actual = homePage.getText();
		String expected = "Products";
		Assert.assertEquals(actual, expected);

	}

	@Test
	public void invalidLogin() throws FilloException {
		Recordset recordset = connection.executeQuery("select *from data where TestName='invalidLogin'");
		recordset.next();
		String UserName = recordset.getField("UserName");
		String Password = recordset.getField("Password");
		LoginPage login = new LoginPage(driver);
		login.LoginFunction(UserName, Password);
		WebElement error = driver.findElement(By.xpath("//*[text()='Epic sadface: Username and password do not match any user in this service']"));
		String actual = error.getText();
		String expected = "Epic sadface: Username and password do not match any user in this service";
		Assert.assertEquals(actual, expected);
	}

}

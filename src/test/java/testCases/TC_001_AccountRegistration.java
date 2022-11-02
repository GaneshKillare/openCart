package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistration extends BaseClass {

	@Test
	public void test_accout_Registration() throws Exception {
		logger.info(" Starting TC_001_AccountRegistration ");

		driver.get("https://demo.opencart.com/index.php");
		logger.info("Home Page Displayed ");

		driver.manage().window().maximize();

		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My Account ");
		hp.clickRegister();
		logger.info("Clicked on Register ");

		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		regpage.setFirstName("John");
		logger.info("Provided First Name ");

		regpage.setLastName("Canedy");
		logger.info("Provided Last Name ");

		regpage.setEmail(randomestring() + "@gmail.com");
		logger.info("Provided Email ");

		// regpage.setTelephone("65656565");
		// logger.info("Provided Telephone ");

		regpage.setPassword("abcxyz");
		logger.info("Provided Password ");
		scrollDownPage(driver);
		Thread.sleep(3000);
		// regpage.setConfirmPassword("abcxyz");
		// logger.info("Provided Confrmed Password ");
		regpage.setPrivacyPolicy();
		logger.info("Set Privacy Policy ");

		regpage.clickContinue();
		logger.info("Clicked on Continue ");

		String confmsg = regpage.getConfirmationMsg();
		String expted = "My Account";

		Assert.assertEquals(confmsg, expted);

	}
}

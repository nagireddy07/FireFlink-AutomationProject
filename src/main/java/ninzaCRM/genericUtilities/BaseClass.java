package ninzaCRM.genericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.BeforeTest;
//import org.testng.xml.XmlTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import ninzaCRM.objectRepository.DashboardPage;
import ninzaCRM.objectRepository.LoginPage;

/**
 * This class consists of basic configuration annotations of testNG
 * 
 * @author Bobbala Venkata Nagi
 */
public class BaseClass {

	public FileUtility fileu = new FileUtility();
	public WebDriverUtility webUty = new WebDriverUtility();
	public WebDriver driver;

	// for Listeners class
	public static WebDriver sdriver;

	@BeforeSuite(alwaysRun = true)
	public void openDB() {
		System.out.println("DB opened");
	}

	@BeforeClass(alwaysRun = true)
	// @Parameters("browser") // Instead of XMLTest
//	@BeforeTest //Parallel Execution
	public void LaunchBrowser() throws Exception {

		String BROWSER = fileu.readDataFromPropertyFile("browser");
//		BROWSER = test.getParameter("browser");
		String URL = fileu.readDataFromPropertyFile("url");
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		webUty.maximizeWindow(driver);
		webUty.waitImplicitly(driver);
		driver.get(URL);
		System.out.println("Browser launched");

		// for Listeners class
		sdriver = driver;
	}

	@BeforeMethod(alwaysRun = true)
	public void loginNinzaCRM() throws Exception {
		String USERNAME = fileu.readDataFromPropertyFile("un");
		String PASSWORD = fileu.readDataFromPropertyFile("pass");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("Log in successful");
	}

	@AfterMethod(alwaysRun = true)
	public void logoutNinzaCRM() {
		DashboardPage d = new DashboardPage(driver);
		d.logOut();
		System.out.println("Logout success");
	}

	@AfterClass(alwaysRun = true)
//	@AfterTest //Parallel Execution
	public void closeBrowser() {
		driver.quit();
		System.out.println("Browser closed");
	}

	@AfterSuite(alwaysRun = true)
	public void closeDB() {
		System.out.println("DB closed");
	}
}

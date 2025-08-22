package practise;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import ninzaCRM.genericUtilities.FileUtility;
import ninzaCRM.genericUtilities.WebDriverUtility;
import ninzaCRM.objectRepository.AddProductPage;
import ninzaCRM.objectRepository.ContactsPage;
import ninzaCRM.objectRepository.CreateContactPage;
import ninzaCRM.objectRepository.DashboardPage;
import ninzaCRM.objectRepository.LoginPage;
import ninzaCRM.objectRepository.ProductPage;

public class E2ETC_01Test {
	@Test
	public void Run1stTest() throws Exception {
		WebDriverManager.edgedriver().setup();
		FileUtility fileu = new FileUtility();
		WebDriverUtility webUty = new WebDriverUtility();
		String BROWSER=fileu.readDataFromPropertyFile("browser");
		String URL = fileu.readDataFromPropertyFile("url");
		String USERNAME = fileu.readDataFromPropertyFile("un");
		String PASSWORD = fileu.readDataFromPropertyFile("pass");
				
		WebDriver driver = null;
		if(BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		}else {
			driver = new ChromeDriver();
		}
		webUty.maximizeWindow(driver);
		webUty.waitImplicitly(driver);
		driver.get(URL);
		
		//POM Class
		//Login
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		//Create Contact
		
		DashboardPage db = new DashboardPage(driver);
		db.getContactsLink().click();
//		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		ContactsPage c=new ContactsPage(driver);
		c.getCreateContactsbtn().click();
//		driver.findElement(By.xpath("//span[.='Create Contact']")).click();
		CreateContactPage cp = new CreateContactPage(driver);
		cp.createContact(driver,fileu.readDataFromExcel("E2E", 4, 2) ,fileu.readDataFromExcel("E2E", 4, 3),fileu.readDataFromExcel("E2E", 4, 5) ,fileu.readDataFromExcel("E2E", 4, 4) , fileu.readDataFromExcel("E2E", 4, 6));

		String currId = driver.getWindowHandle();
		
		//Add Product
		db.getProductsLink().click();
//		driver.findElement(By.xpath("//a[.='Products']")).click();
		ProductPage p =new ProductPage(driver);
		WebElement productVerify = p.getAddProductBtn();
		
		try {
			db.getPopupClose().click();
		}catch (Exception e) {
			Thread.sleep(5000);
		}
		
		if(productVerify.isDisplayed()) {
			System.out.println("status---> PASS");
			productVerify.click();
		}

//		driver.findElement(By.name("quantity")).sendKeys(fileu.readDataFromExcel("E2E", 4, 7));
//		driver.findElement(By.name("productName")).sendKeys(fileu.readDataFromExcel("E2E", 4, 8));//col.getCell(8).toString()
//		WebElement pricePerUnEle = driver.findElement(By.name("price"));
//		pricePerUnEle.clear();
//		pricePerUnEle.sendKeys(fileu.readDataFromExcel("E2E", 4, 9));
//		WebElement prodCategEle = driver.findElement(By.name("productCategory"));
//		Select catgSel = new Select(prodCategEle);
//		catgSel.selectByValue(fileu.readDataFromExcel("E2E", 4, 10));
//		Select venderSel = new Select(driver.findElement(By.name("vendorId")));
//		venderSel.selectByVisibleText(fileu.readDataFromExcel("E2E", 4, 11));
//		driver.findElement(By.xpath("//button[.='Add']")).click();
		
		AddProductPage ap = new AddProductPage(driver);
		ap.AddProduct(fileu.readDataFromExcel("E2E", 4, 7),fileu.readDataFromExcel("E2E", 4, 8) ,fileu.readDataFromExcel("E2E", 4, 9),fileu.readDataFromExcel("E2E", 4, 10) , fileu.readDataFromExcel("E2E", 4, 11));
		
		try {
			db.getPopupClose().click();
		}catch(Exception e) {
			Thread.sleep(5000);
		}

		
		//Purchase Order
		driver.findElement(By.xpath("//a[.='Purchase Order']")).click();
		driver.findElement(By.xpath("//span[.='Create Order']")).click();
		driver.findElement(By.name("dueDate")).sendKeys(fileu.readDataFromExcel("E2E", 4, 12));
		driver.findElement(By.name("subject")).sendKeys(fileu.readDataFromExcel("E2E", 4, 13));
		driver.findElement(By.xpath("//div[@style='display: flex; align-items: center;']/child::button[@class='action-button']")).click();

		webUty.toWindow(driver);

		driver.findElement(By.id("search-input")).sendKeys("Sumit Ghosh");

		driver.findElement(By.xpath("//button[.='Select']")).click();

		driver.switchTo().window(currId);

		driver.findElement(By.name("address")).sendKeys(fileu.readDataFromExcel("E2E", 4, 14));
		driver.findElement(By.xpath("(//textarea[@name='address'])[2]")).sendKeys(fileu.readDataFromExcel("E2E", 4, 14));
		driver.findElement(By.xpath("(//input[@name='poBox'])[1]")).sendKeys(fileu.readDataFromExcel("E2E", 4, 15));
		driver.findElement(By.xpath("(//input[@name='poBox'])[2]")).sendKeys(fileu.readDataFromExcel("E2E", 4, 15));
		driver.findElement(By.xpath("(//input[@name='city'])[1]")).sendKeys(fileu.readDataFromExcel("E2E", 4, 16));
		driver.findElement(By.xpath("(//input[@name='city'])[2]")).sendKeys(fileu.readDataFromExcel("E2E", 4, 16));
		driver.findElement(By.xpath("(//input[@name='state'])[1]")).sendKeys(fileu.readDataFromExcel("E2E", 4, 17));
		driver.findElement(By.xpath("(//input[@name='state'])[2]")).sendKeys(fileu.readDataFromExcel("E2E", 4, 17));
		driver.findElement(By.xpath("(//input[@name='postalCode'])[1]")).sendKeys(fileu.readDataFromExcel("E2E", 4, 18));
		driver.findElement(By.xpath("(//input[@name='postalCode'])[2]")).sendKeys(fileu.readDataFromExcel("E2E", 4, 18));
		driver.findElement(By.xpath("(//input[@name='country'])[1]")).sendKeys(fileu.readDataFromExcel("E2E", 4, 19));
		driver.findElement(By.xpath("(//input[@name='country'])[2]")).sendKeys(fileu.readDataFromExcel("E2E", 4, 19));
		driver.findElement(By.xpath("//div[@style='margin-top: 20px;']/child::button")).click();	
		webUty.toWindow(driver);
		WebElement searchEle = driver.findElement(By.id("search-criteria"));
		webUty.handleDropDown( "productName",searchEle);
		driver.findElement(By.id("search-input")).sendKeys(fileu.readDataFromExcel("E2E", 4, 8));
		driver.findElement(By.xpath("//button[.='Select']")).click();
		driver.switchTo().window(currId);
		driver.findElement(By.xpath("//button[.='Create Purchase Order']")).click();
		try {
			driver.findElement(By.xpath("//button[@aria-label='close']")).click();
			}catch(Exception e) {Thread.sleep(6000);}
		
		driver.findElement(By.className("user-icon")).click();
		driver.findElement(By.xpath("//div[.='Logout ']")).click();
	}
}
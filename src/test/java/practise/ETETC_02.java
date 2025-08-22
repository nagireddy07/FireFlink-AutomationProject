package practise;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
import ninzaCRM.genericUtilities.FileUtility;
import ninzaCRM.genericUtilities.WebDriverUtility;

public class ETETC_02{
	public static void main(String[] args) throws Exception {
		
		WebDriverManager.edgedriver().setup();
		FileUtility fu = new FileUtility();
		WebDriverUtility wu = new WebDriverUtility();

//		FileInputStream fis = new FileInputStream("C:\\Users\\User\\Downloads\\Nagireddy\\Selenium\\Fireflink.NinzaCRM.AutomationFramework\\src\\test\\resources\\CommonData.properties");
//
//		Properties prop = new Properties();
//
//		prop.load(fis);

		String BROWSER =fu.readDataFromPropertyFile("browser");

		String URL = fu.readDataFromPropertyFile("url");

		String USERNAME = fu.readDataFromPropertyFile("un");

		String PASSWORD = fu.readDataFromPropertyFile("pass");
		
		
		

		WebDriver driver = null;
		WebDriverManager.edgedriver().setup();

		if(BROWSER.equals("chrome")) {

			driver = new ChromeDriver();

		}else if(BROWSER.equals("firefox")) {

			driver = new FirefoxDriver();

		}else if (BROWSER.equals("edge")) {

			driver = new EdgeDriver();

		}else {

			driver = new ChromeDriver();

		}

	

//		1)Login to App with valid Credentials

//		driver.manage().window().maximize();
		wu.maximizeWindow(driver);

//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wu.waitImplicitly(driver);

		driver.get(URL);

		driver.findElement(By.id("username")).sendKeys(USERNAME);

		driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);

		driver.findElement(By.xpath("//button[.='Sign In']")).click();

		

//		FileInputStream exceldata = new FileInputStream("C:\\Users\\User\\Downloads\\Nagireddy\\Selenium\\Fireflink.NinzaCRM.AutomationFramework\\src\\test\\resources\\TestData.xlsx");
//
//		Workbook wb = WorkbookFactory.create(exceldata);
//
//		Sheet sheet = wb.getSheet("E2E");
//
//		Row col = sheet.getRow(4);

		

//		2)Click on Purchase Order Button

		driver.findElement(By.xpath("//a[.='Purchase Order']")).click();
		String currId = driver.getWindowHandle();
		

//		3)Click on Create Order Button

		driver.findElement(By.xpath("//span[.='Create Order']")).click();

		

//		4)Create Purchase order with Product and contact

//		driver.findElement(By.name("dueDate")).sendKeys(col.getCell(12).toString());
		driver.findElement(By.name("dueDate")).sendKeys(fu.readDataFromExcel("E2E", 4, 12));

//		driver.findElement(By.name("subject")).sendKeys(col.getCell(13).toString());
		driver.findElement(By.name("subject")).sendKeys(fu.readDataFromExcel("E2E", 4, 13));

		driver.findElement(By.xpath("//div[@style='display: flex; align-items: center;']/child::button[@class='action-button']")).click();

		

		Set<String> allIds1 = driver.getWindowHandles();

		for(String id:allIds1) {

			if(!currId.equals(id)) {

				driver.switchTo().window(id);

			}

		}

		driver.findElement(By.id("search-input")).sendKeys("Sumit Ghosh");

		driver.findElement(By.xpath("//button[.='Select']")).click();

		driver.switchTo().window(currId);

		driver.findElement(By.name("address")).sendKeys(fu.readDataFromExcel("E2E", 4, 14));

		driver.findElement(By.xpath("(//textarea[@name='address'])[2]")).sendKeys(fu.readDataFromExcel("E2E", 4, 14));

		driver.findElement(By.xpath("(//input[@name='poBox'])[1]")).sendKeys(fu.readDataFromExcel("E2E", 4, 15));

		driver.findElement(By.xpath("(//input[@name='poBox'])[2]")).sendKeys(fu.readDataFromExcel("E2E", 4, 15));

		driver.findElement(By.xpath("(//input[@name='city'])[1]")).sendKeys(fu.readDataFromExcel("E2E", 4, 16));

		driver.findElement(By.xpath("(//input[@name='city'])[2]")).sendKeys(fu.readDataFromExcel("E2E", 4, 16));

		driver.findElement(By.xpath("(//input[@name='state'])[1]")).sendKeys(fu.readDataFromExcel("E2E", 4, 17));

		driver.findElement(By.xpath("(//input[@name='state'])[2]")).sendKeys(fu.readDataFromExcel("E2E", 4, 17));

		driver.findElement(By.xpath("(//input[@name='postalCode'])[1]")).sendKeys(fu.readDataFromExcel("E2E", 4, 18));

		driver.findElement(By.xpath("(//input[@name='postalCode'])[2]")).sendKeys(fu.readDataFromExcel("E2E", 4, 18));

		driver.findElement(By.xpath("(//input[@name='country'])[1]")).sendKeys(fu.readDataFromExcel("E2E", 4, 19));

		driver.findElement(By.xpath("(//input[@name='country'])[2]")).sendKeys(fu.readDataFromExcel("E2E", 4, 19));		

		driver.findElement(By.xpath("//div[@style='margin-top: 20px;']/child::button")).click();	

		Set<String> allIds2 = driver.getWindowHandles();

		for(String id:allIds2) {

			if(!currId.equals(id)) {

				driver.switchTo().window(id);

			}

		}

		Select prodSel = new Select(driver.findElement(By.id("search-criteria")));

		

		prodSel.selectByValue("productName");

		driver.findElement(By.id("search-input")).sendKeys(fu.readDataFromExcel("E2E", 7, 5));

		driver.findElement(By.xpath("//button[.='Select']")).click();

		driver.switchTo().window(currId);

		driver.findElement(By.xpath("//button[.='Create Purchase Order']")).click();

		try {

			driver.findElement(By.xpath("//button[@aria-label='close']")).click();

			}catch(Exception e) {
				Thread.sleep(6000);
			}

//		Row col2 = sheet.getRow(7);

//		5)Click on Products and search that product by it's name

		driver.findElement(By.xpath("//a[.='Products']")).click();

		Select prodIdEle = new Select(driver.findElement(By.xpath("//select[@class='form-control']")));

		prodIdEle.selectByValue("productName");

		driver.findElement(By.xpath("//input[@placeholder='Search by product Name']")).sendKeys(fu.readDataFromExcel("E2E", 7, 5));

		driver.findElement(By.xpath("//i[@class='material-icons' and @title='Edit']")).click();

		WebElement priceEle = driver.findElement(By.name("price"));

		priceEle.clear();

		priceEle.sendKeys(fu.readDataFromExcel("E2E", 7, 6));

		driver.findElement(By.xpath("//button[.='Update']")).click();

		try {

		driver.findElement(By.className("Toastify__close-button Toastify__close-button--success")).click();

		}catch(Exception e) {
			Thread.sleep(5000);
		}

		driver.findElement(By.xpath("//a[.='Purchase Order']")).click();

//		Select orderEle = new Select(driver.findElement(By.xpath("//select[@class='form-control']")));

//		orderEle.selectByValue("subject");
		
		wu.handleDropDown("subject",driver.findElement(By.xpath("//select[@class='form-control']")));
		
		driver.findElement(By.xpath("//input[@placeholder='Search by Subject']")).sendKeys(fu.readDataFromExcel("E2E", 4, 13));

		driver.findElement(By.xpath("//i[@class='material-icons' and @title='Edit']")).click();

		driver.findElement(By.name("dueDate")).sendKeys(fu.readDataFromExcel("E2E", 4, 12));

		driver.findElement(By.xpath("//button[.='Update Purchase Order']")).click();

		try {

			driver.findElement(By.className("Toastify__close-button Toastify__close-button--success")).click();

			}catch(Exception e) {Thread.sleep(5000);}

		driver.findElement(By.className("user-icon")).click();

		driver.findElement(By.xpath("//div[.='Logout ']")).click();

	}
}
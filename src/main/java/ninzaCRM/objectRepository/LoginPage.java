package ninzaCRM.objectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage { //Rule 1:Class for page
	//Rule 2 : Identify elements @FindBy , @FindAll , @FindBys
	@FindBy(id = "username") private WebElement userNameTF;
	
	@FindBy(name = "password")
	private WebElement passwordTF;
	
	@FindBy(xpath = "//button[.='Sign In']") private WebElement signInbtn;
	
	//Rule 3 : Initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		//this.driver = driver;
	}
	
	//Step : 4 - Getters Methods
	public WebElement getUserNameTF() {
		return userNameTF;
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public WebElement getSignInbtn() {
		return signInbtn;
	}
	
	//Rule:5-Business Library
	public void loginToApp(String un,String pass) {	
		userNameTF.sendKeys(un);
		passwordTF.sendKeys(pass);
		signInbtn.click();
	}
}

package ninzaCRM.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	@FindBy(xpath = "//a[.='Contacts']") private WebElement contactsLink;
	@FindBy(xpath = "//span[.='Create Contact']") private WebElement createContactsbtn;
	@FindBy(xpath = "//select[@class=\"form-control\"]") private WebElement searchContactsType;
	
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getCreateContactsbtn() {
		return createContactsbtn;
	}

	public WebElement getSearchContactsType() {
		return searchContactsType;
	}	
}

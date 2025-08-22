package ninzaCRM.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	@FindBy(xpath = "//a[.='Campaigns']") private WebElement campaignsLink;
	@FindBy(xpath = "//a[.='Contacts']") private WebElement contactsLink;
	@FindBy(xpath = "//a[.='Leads']") private WebElement leadsLink;
	@FindBy(xpath = "//a[.='Opportunities']") private WebElement opportunitiesLink;
	@FindBy(xpath = "//a[.='Products']") private WebElement productsLink;
	@FindBy(xpath = "//a[.='Quotes']") private WebElement quotesLink;
	@FindBy(xpath = "//a[.='Purchase Order']") private WebElement purchaseOrderLink;
	@FindBy(xpath = "//a[.='Sales Order']") private WebElement salesOrderLink;
	@FindBy(xpath = "//a[.='Invoice']") private WebElement invoiceLink;
	@FindBy(xpath = "//a[.='Admin Console']") private WebElement adminConsoleLink;
	
	@FindBy(xpath = "//div[@class=\"user-icon\"]") private WebElement userIconBtn;
	@FindBy(xpath = "//div[@class=\"dropdown-item logout\"]") private WebElement logOutBtn;
	
	@FindBy(xpath = "//button[@aria-label='close']") private WebElement popupClose;
	
	public WebElement getPopupClose() {
		return popupClose;
	}

	public DashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getLeadsLink() {
		return leadsLink;
	}

	public WebElement getOpportunitiesLink() {
		return opportunitiesLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getQuotesLink() {
		return quotesLink;
	}

	public WebElement getPurchaseOrderLink() {
		return purchaseOrderLink;
	}

	public WebElement getSalesOrderLink() {
		return salesOrderLink;
	}

	public WebElement getInvoiceLink() {
		return invoiceLink;
	}

	public WebElement getAdminConsoleLink() {
		return adminConsoleLink;
	}

	public WebElement getUserIconBtn() {
		return userIconBtn;
	}

	public WebElement getLogOutBtn() {
		return logOutBtn;
	}
	public void logOut() {
		userIconBtn.click();
		logOutBtn.click();
	}
	
}

package ninzaCRM.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseOrderPage {
	@FindBy(xpath = "//span[.='Create Order']") private WebElement createOrderBtn;
	@FindBy(xpath = "//select[@class=\"form-control\"]") private WebElement searchOrderSelect;
	@FindBy(xpath = "//div[@class=\"col-sm-6\"]/input") private WebElement searchOrderInput;
	
	public PurchaseOrderPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getCreateOrderBtn() {
		return createOrderBtn;
	}

	public WebElement getSearchOrderSelect() {
		return searchOrderSelect;
	}

	public WebElement getSearchOrderInput() {
		return searchOrderInput;
	}
}

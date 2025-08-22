package ninzaCRM.objectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateLeadPage {

    @FindBy(name="leadStatus")
    private WebElement leadStatusTF;
    
    @FindBy(name="name")
    private WebElement leadNameTF;
    
    @FindBy(name ="company")
    private WebElement companyTF;
    
    @FindBy(name="leadSource")
    private WebElement leadSourceTF;
    
    @FindBy(name="industry")
    private WebElement industryTF;
    
    @FindBy(name ="phone")
    private WebElement phoneTF;
    
    @FindBy(xpath = "//button[@type='button' and not(@aria-controls='navbarNav')]")
    private WebElement campainADDbtn;
    
    
    @FindBy(id = "search-criteria")
    private WebElement IdDropDown;
    
    @FindBy(id = "search-input")
    private WebElement searchInputTF;
    public CreateLeadPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public WebElement getLeadStatusTF() {
        return leadStatusTF;
    }
    public WebElement getLeadNameTF() {
        return leadNameTF;
    }
    public WebElement getCompanyTF() {
        return companyTF;
    }
    public WebElement getLeadSourceTF() {
        return leadSourceTF;
    }
    public WebElement getIndustryTF() {
        return industryTF;
    }
    public WebElement getPhoneTF() {
        return phoneTF;
    }
    public WebElement getCampainADDbtn() {
        return campainADDbtn;
    }
    public WebElement getIdDropDown() {
        return IdDropDown;
    }
    public WebElement getSearchInputTF() {
        return searchInputTF;
    }
    
}
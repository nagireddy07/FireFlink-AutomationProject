package ninzaCRM.objectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Campaignspage {
    
    @FindBy(xpath="//span[.='Create Campaign']")
    private WebElement createCampaignBtn;
    
    @FindBy(xpath="//select[@class='form-control']")
    private WebElement searchByCampaignIdDD;
    
    @FindBy(xpath="//input[@placeholder='Search by Campaign Id']")
    private WebElement searchCampaignIdTF;
    
    //constructor
    public Campaignspage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    
    //getters
    public WebElement getCreateCampaignBtn() {
        return createCampaignBtn;
    }
    public WebElement getSearchByCampaignIdDD() {
        return searchByCampaignIdDD;
    }
    public WebElement getSearchCampaignIdTF() {
        return searchCampaignIdTF;
    }
    
    
    

}
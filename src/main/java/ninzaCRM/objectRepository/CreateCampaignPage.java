package ninzaCRM.objectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage extends ninzaCRM.genericUtilities.WebDriverUtility {
    
    
    @FindBy(xpath="//input[@name='campaignName']")
    public WebElement campaignNameTF;
    @FindBy(xpath="//input[@name='targetSize']")
    public WebElement targetSizeTF;
    @FindBy(xpath="//button[.='Create Campaign']")
    public WebElement createCampaginBtn;
    
    
    public CreateCampaignPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public WebElement getCampaignNameText() {
        return campaignNameTF;
    }


    public WebElement getTargetSizeText() {
        return targetSizeTF;
    }
    
    public WebElement getCreateCampaginBtn() {
        return createCampaginBtn;
    }
    
    
    //business logic


    public void creatingCampaign(String campaginName,String targetSize,WebDriver driver)
    {
        campaignNameTF.sendKeys(campaginName);
        targetSizeTF.sendKeys(targetSize);
        ScrollToElementActions(driver, createCampaginBtn);
        createCampaginBtn.click();
        
        
    }
    
    
}
package ninzaCRM.objectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {
    
    @FindBy(xpath="//b[.='Leads']")
    private WebElement LeadsText;
    
    @FindBy(xpath="//span[.='Create Lead']")
    private WebElement createLeadsBtn;

    @FindBy(xpath="//select[@class=\"form-control\"]")
    private WebElement SearchByDropdown;


    @FindBy(xpath="//input[@placeholder='Search by Lead Id']")
    private WebElement SearchByTextField;

//constructur
    public LeadsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    //getters

    public WebElement getLeadsText() {
        return LeadsText;
    }


    public WebElement getCreateLeadsBtn() {
        return createLeadsBtn;
    }


    public WebElement getSearchByDropdown() {
        return SearchByDropdown;
    }


    public WebElement getSearchByTextField() {
        return SearchByTextField;
    }
}
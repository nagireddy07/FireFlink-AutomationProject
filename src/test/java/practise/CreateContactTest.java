package practise;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
//import org.testng.Assert;
//import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ninzaCRM.genericUtilities.BaseClass;
import ninzaCRM.objectRepository.ContactsPage;
import ninzaCRM.objectRepository.CreateContactPage;
import ninzaCRM.objectRepository.DashboardPage;
@Listeners(ninzaCRM.genericUtilities.ListenerImplementation.class)
public class CreateContactTest extends BaseClass {
	@Test (groups = "SmokeSuite")
	public void contact() throws EncryptedDocumentException, InterruptedException, IOException {
		DashboardPage db = new DashboardPage(driver);
		db.getContactsLink().click();
//		Reporter.log("Clicked on contacts link",true);
//		Assert.fail();
		ContactsPage c=new ContactsPage(driver);
		c.getCreateContactsbtn().click();
//		Reporter.log("Clicked on create Contact");
		CreateContactPage cp = new CreateContactPage(driver);
		cp.createContact(driver,fileu.readDataFromExcel("E2E", 4, 2) ,fileu.readDataFromExcel("E2E", 4, 3),fileu.readDataFromExcel("E2E", 4, 5) ,fileu.readDataFromExcel("E2E", 4, 4) , fileu.readDataFromExcel("E2E", 4, 6));
		try {
			db.getPopupClose().click();
		}catch (Exception e) {
			Thread.sleep(5000);
		}
	}
}


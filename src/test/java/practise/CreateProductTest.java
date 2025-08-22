package practise;

import org.testng.annotations.Test;

import ninzaCRM.genericUtilities.BaseClass;
import ninzaCRM.objectRepository.AddProductPage;
import ninzaCRM.objectRepository.DashboardPage;
import ninzaCRM.objectRepository.ProductPage;

public class CreateProductTest extends BaseClass {
	@Test(groups = "RegressionSuite")
	public void product() throws Exception {
		DashboardPage db = new DashboardPage(driver);
		db.getProductsLink().click();
		ProductPage p = new ProductPage(driver);
		p.getAddProductBtn().click();
		AddProductPage ap = new AddProductPage(driver);
		ap.AddProduct(fileu.readDataFromExcel("E2E", 4, 7),fileu.readDataFromExcel("E2E", 4, 8) ,fileu.readDataFromExcel("E2E", 4, 9),fileu.readDataFromExcel("E2E", 4, 10) , fileu.readDataFromExcel("E2E", 4, 11));
		
		try {
			db.getPopupClose().click();
		}catch(Exception e) {
			Thread.sleep(5000);
		}
	}
}

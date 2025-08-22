package practise;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
//import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ninzaCRM.genericUtilities.FileUtility;

public class TestNgPractice extends FileUtility {
//	@Test(enabled = false)
//	public void create() {
//		System.out.println("Create");
//	}
//	@Test (invocationCount = 2,dependsOnMethods = "delete")
//	public void modify(){
//		System.out.println("Modify");
//	}
//	@Test (priority=-1)
//	public void delete() {
//		Assert.fail();
//		System.out.println("Delete");
//	}
	
	@Test(dataProvider = "getData")
	public void practiseDataProvider(String name,String id) {
		System.out.println("something");
		System.out.println(id + " "+name);
	}
	
//	@DataProvider
//	public Object[][] getData() throws EncryptedDocumentException, IOException{
//		//4 rows , 2 cols - 4 sets of data with 2 attributes.
////		Object[][] data = new Object[3][2];
////		
////		data[0][0] = "SSMB";
////		data[0][1] = 1;
////		data[1][0] = "PSPK";
////		data[1][1] = 2;
////		data[2][0] = "NTR";
////		data[2][1] = 3;
////				
////		return data;
//		System.out.println("Data provider");
//		return readMultipleDataFromExcel(4, 2, "E2E");
//	}	
	
	@Test
	public void sample() {
		
		
		
		System.out.println("Just for a sample push to git hub");
	}
}

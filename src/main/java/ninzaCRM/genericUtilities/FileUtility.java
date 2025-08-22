package ninzaCRM.genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * This Class consists of generic methods related to File Operations Like Property file , Excel File
 * @author Bobbala Venkata Nagi
 */

public class FileUtility {
	
	/**
	 * This Method will read data from property file.
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public String readDataFromPropertyFile(String key) throws Exception {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		return p.getProperty(key);
	}
	
	
	/**
	 * This method will read data from excel file and return the value to caller
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcel(String sheet,int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		return WorkbookFactory.create(fis).getSheet(sheet).getRow(row).getCell(cell).toString();
	}
	
	
	/**
	 * This method return multiple data present in a row
	 * @param sheet
	 * @param row
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public List<String> readRowDataFromExcel(String sheet,int row) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Row row1 = WorkbookFactory.create(fis).getSheet(sheet).getRow(row);
		List<String> list = new ArrayList<String>();
		for(int i=0;i<row1.getLastCellNum();i++) {
			list.add(row1.getCell(i).toString());
		}
		return list;
	}
	
	public Object[][] readMultipleDataFromExcel(int rows,int cols,String sheet) throws EncryptedDocumentException, IOException{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Sheet s = WorkbookFactory.create(fis).getSheet(sheet);
		Object[][] data = new Object[rows][cols];
		for(int i=0;i<rows;i++) {
			for(int j=0;i<cols;j++) {
				try {
					System.out.println("-----");
				data[i][j]=s.getRow(i).getCell(j).toString();
				}catch (Exception e) {
					System.out.println("+++++++++++++++++++++");
				}
			}
		}
		return data;
	}
	
}

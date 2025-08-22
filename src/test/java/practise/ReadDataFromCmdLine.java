package practise;

import org.testng.annotations.Test;

public class ReadDataFromCmdLine {
	@Test
	public void readData() {
		String BROWSER = System.getProperty("browser");
		System.out.println(BROWSER);
		String URL = System.getProperty("url");
		System.out.println(URL);
		String UN = System.getProperty("un");
		System.out.println(UN);
		String PASS = System.getProperty("pass");
		System.out.println(PASS);
	}
}

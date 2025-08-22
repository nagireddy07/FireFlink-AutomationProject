package ninzaCRM.genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * This class provides implementation to IRetryAnalyser
 * @author Bobbala Venkata Nagi
 */
public class RetryAnalyserImplementationClass implements IRetryAnalyzer{
	int count = 1;
	int retryCount = 3; //Manual Analysis
	@Override
	public boolean retry(ITestResult result) {
		
		while (count <= retryCount) {
			count++;
			return true; //Retry
		}
		return false; //Stop Retry 
	}
	
}

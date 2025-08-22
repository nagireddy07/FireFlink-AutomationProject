package practise;

import org.junit.Assert;
import org.testng.annotations.Test;

public class RetryAnalyzerPractise {
	@Test(retryAnalyzer = ninzaCRM.genericUtilities.RetryAnalyserImplementationClass.class)
	public void Sample() {
		System.out.println("Retry");
		Assert.fail();
	}
}

package practise;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsPractice {
	@Test
	public void practice() {
		System.out.println("Start");
		Assert.assertEquals(1, 1);
		System.out.println("End");
	}
}

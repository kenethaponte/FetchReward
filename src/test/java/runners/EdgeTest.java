package runners;

import org.testng.annotations.AfterTest;

import base.MainBase;
import utils.BrowserConfig;

public class EdgeTest {
	
	@org.testng.annotations.Test
	public void testing() {
		BrowserConfig.getEdgeDriver().get("http://ec2-54-208-152-154.compute-1.amazonaws.com/");
		MainBase base = new MainBase(BrowserConfig.getDriver());
		
		base.populateBowlsFirstTime();
		base.checkFakeBar();
	}
	
	@AfterTest
	public void tearDown() {
		BrowserConfig.closeDriver();
	}

}

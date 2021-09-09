package utils;

import org.openqa.selenium.Alert;

public class GeneralUtils {

	public static void readAlert() {
		Alert alert = BrowserConfig.getDriver().switchTo().alert();
		System.out.println("*********** ALERT ***********");
		System.out.println(alert.getText());
		alert.accept();
	}

	public static void forceWait(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

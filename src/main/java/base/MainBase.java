package base;

import org.openqa.selenium.WebDriver;

import pageObjects.MainPO;
import utils.GeneralUtils;

public class MainBase {
	private WebDriver driver;
	private static int start, end;

	public MainBase(WebDriver driver) {
		this.driver = driver;
	}

	public void populateBowls(int start, int end) {
		MainPO po = new MainPO(driver);

		po.getResetBtn().click();
		int qty = end - start + 1;

		for (int i = start; i < (start + qty / 2); i++) {
			po.getLeftBowlPos(i).sendKeys(i + " ");
		}

		for (int i = (start + qty / 2); i <= end; i++) {
			po.getRightBowlPos(i).sendKeys(i + "");
		}
	}

	public void populateBowlsFirstTime() {
		populateBowls(0, 7);
		clickWeigh();
	}

	public void clickWeigh() {
		MainPO po = new MainPO(driver);
		po.getWeighBtn().click();
		GeneralUtils.forceWait(2);
	}

	public void printWeighings() {
		MainPO po = new MainPO(driver);

		for (int i = 0; i < po.getListWeighings().size(); i++) {
			System.out.println(po.getListWeighings().get(i).getText());
		}
	}

	public void selectFake(int pos) {
		MainPO po = new MainPO(driver);
		printWeighings();
		System.out.println("No more Weighings needed. Fake bar is #" + pos);
		po.getCoins(pos).click();
		GeneralUtils.readAlert();
	}

	public void checkFakeBar() {
		MainPO po = new MainPO(driver);
		String lastWeighings = po.getListWeighings().get(po.getListWeighings().size() - 1).getText();

		if (lastWeighings.contains("=")) {
			selectFake(8);
		} else {
			getRangeLessWeight();
			if (start == end) {
				selectFake(start);
			} else {
				populateBowls(start, end);
				clickWeigh();
				checkFakeBar();
			}

		}
	}

	public void getRangeLessWeight() {
		MainPO po = new MainPO(driver);
		String lastWeighings = po.getListWeighings().get(po.getListWeighings().size() - 1).getText();

		if (lastWeighings.contains(">")) {
			lastWeighings = lastWeighings.substring(lastWeighings.indexOf(">") + 2);
		}
		start = Integer.valueOf(lastWeighings.charAt(1) + "");
		end = Integer.valueOf(lastWeighings.charAt(lastWeighings.indexOf("]") - 1) + "");
	}



}

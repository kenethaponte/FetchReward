package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPO {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public MainPO(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
	}
	
	public WebElement getLeftBowlPos(int pos) {
		return driver.findElement(By.xpath("//input[@id='left_"+pos+"']"));
	}
	
	public WebElement getRightBowlPos(int pos) {
		return driver.findElement(By.xpath("//input[@id='right_"+pos+"']"));
	}
	
	public WebElement getCoins(int pos) {
		return driver.findElement(By.xpath("//button[@id='coin_"+pos+"']"));
	}
	
	public WebElement getResetBtn() {
		return driver.findElement(By.xpath("//button[text()='Reset']"));
	}
	
	public WebElement getWeighBtn() {
		return driver.findElement(By.id("weigh"));
	}
	
	public WebElement getWeighingsLabel(int pos) {
		return driver.findElement(By.xpath("//button[@id='coin_"+pos+"']"));
	}
	
	public List<WebElement> getListWeighings() {
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ol/li")));
	}
	
}

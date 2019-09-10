package pageobjects.mobile;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import core.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class IMDBPageObject extends BasePage{

	public IMDBPageObject(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h4[text()='Director:']/following-sibling::a")
	private WebElement lnk_director;
	
	@FindBy(xpath="//div/cite[contains(text(),'www.imdb.com')]")
	private WebElement lnk_imdb;
	
	public String getDirector() throws Exception {
		return pageWebDriverClient.getText(lnk_director);
	}
	
	public boolean goToImdbLink() throws Exception {
		return pageWebDriverClient.click(lnk_imdb);
	}
	

}

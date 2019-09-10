package pageobjects.mobile;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import core.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class GoogleMobilePageObject extends BasePage{

	public GoogleMobilePageObject(AppiumDriver<MobileElement> appiumDriver) {
		super(appiumDriver);
	}
	
	@FindBy(xpath="//*/input[@title='Search']")
	private WebElement search_text;
	
	@FindBy(xpath="//cite[contains(text(),'wikipedia')]")
	private WebElement wikitxt;
	
	@FindBy(xpath="(//*[@id=\"search\"]//div[@class='exp-outline']/following-sibling::div//a)[1]")
	private WebElement wikiLink;
	
	public boolean searchMovie(String moviename) throws Exception {
		return pageWebDriverClient.setText(search_text, moviename);
	}
	
	public String getWikiLink() throws Exception {
		return pageWebDriverClient.getText(wikitxt);
	}
	
	public boolean goToWikiLink() throws Exception {
		return pageWebDriverClient.click(wikiLink);
	}
	
	public void setUrl(String Url) {
		pageWebDriverClient.setURL(Url);
		}


}

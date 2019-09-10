package pageobjects.mobile;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import core.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class WikipediaPageObject extends BasePage{

	public WikipediaPageObject(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	@FindBy(xpath="//th[text()='Directed by']/following-sibling::td/a")
	private WebElement lnk_director;
	
	@FindBy(xpath="//div/cite[contains(text(),'en.wikipedia.org')]")
	private WebElement lnk_wikipedia;
	
	public String getDirector() throws Exception {
		return pageWebDriverClient.getAttribute(lnk_director, "title");
		
	}
	
	public boolean goToWikipediaLink() throws Exception {
		return pageWebDriverClient.click(lnk_wikipedia);
	}
	

}

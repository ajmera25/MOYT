package pageobjects.desktop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import core.BasePage;

public class IMDBPageObject extends BasePage{

	public IMDBPageObject(WebDriver driver) {
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

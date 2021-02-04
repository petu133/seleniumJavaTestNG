package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageHome {

	private WebDriver driver;
	private By idCont;
	private By linkFrame;
	private By xpathCDTitle;
	private By xpathCDSub;
	private By xpathCDtext;
	private String expectedColorBlock;
	private String expectedColorFrame;
	private String expectedPxCBTitle;
	private String expectedPxCBSub;
	private String expectedColorCBSub;
	private WebElement titleCB;
	private WebElement subTitleCB;
	private WebElement block;
	private WebElement frame;
	private String blockColor;
	private String frameColor;
	
	
	public PageHome (WebDriver driver) {
		this.driver = driver;
		idCont = By.id("cmsinfo_block");
		linkFrame = By.linkText("http://www.seleniumframework.com");
		xpathCDTitle = By.xpath("//*[@id=\"cmsinfo_block\"]/div[2]/h3");
		xpathCDSub = By.xpath("//*[@id=\"cmsinfo_block\"]/div[2]/p[1]/strong");
		
	}
	
	public void setupCmsInfo(String colorBlock, String colorFrame) {
		expectedColorBlock = colorBlock;
		expectedColorFrame = colorFrame;
		block = driver.findElement(idCont);
		frame = driver.findElement(linkFrame);
		blockColor = block.getCssValue("background");
		frameColor = frame.getCssValue("background");
		
	}
	
    public void setupCmsInfo(String pxCBTitle, String pxCBSub, String colorCBSub) {
			expectedPxCBTitle = pxCBTitle;
			expectedPxCBSub = pxCBSub;
			expectedColorCBSub = colorCBSub;
			titleCB = driver.findElement(xpathCDTitle);
			subTitleCB = driver.findElement(xpathCDSub);
	}
    
    public WebElement titleCB() {return titleCB;}
    public WebElement subTitleCB() {return subTitleCB;}
    public String pxTitle() {return expectedPxCBTitle;}
    public String pxSub() {return expectedPxCBSub;}
    public String colorFontSub() {return expectedColorCBSub;}
}

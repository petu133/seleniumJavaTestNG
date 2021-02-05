package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
public class PageHome {

	private WebDriver driver;
	private By idCont;
	private By xpathFrame;
	private By xpathCDTitle;
	private By xpathCDSub;
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
		xpathFrame = By.xpath("//*[@id=\"cmsinfo_block\"]/div[1]/ul/li[2]/div/p/a");
		xpathCDTitle = By.xpath("//*[@id=\"cmsinfo_block\"]/div[2]/h3");
		xpathCDSub = By.xpath("//*[@id=\"cmsinfo_block\"]/div[2]/p[1]/strong");
		
	}
	public void setupCmsInfo(String colorBlockRgba, String colorFrameHex) {
		expectedColorBlock = colorBlockRgba;
		expectedColorFrame = colorFrameHex;
		block = driver.findElement(idCont);
		frame = driver.findElement(xpathFrame);
		blockColor = block.getCssValue("background-color");
		String frameRgba = frame.getCssValue("background-color");
		frameColor = Color.fromString(frameRgba).asHex();
		
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
    public String blockColor() {return blockColor;}
    public String frameColor() {return frameColor;}
    public String expectedColorBlock() {return expectedColorBlock;}
    public String expectedColorFrame() {return expectedColorFrame;}
}

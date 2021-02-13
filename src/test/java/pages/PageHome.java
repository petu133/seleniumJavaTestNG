package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

public class PageHome {
	private final static String ID_CONT_DOM = "cmsinfo_block";
	private final static String XPATH_FRAME_DOM = "//*[@id=\"cmsinfo_block\"]/div[1]/ul/li[2]/div/p/a";
	private final static String XPATH_CDTITLE_DOM = "//*[@id=\"cmsinfo_block\"]/div[2]/h3";
	private final static String XPATH_CSSUB_DOM = "//*[@id=\"cmsinfo_block\"]/div[2]/p[1]/strong";
	private final static String CLASS_PRICEOFF_DOM = "price-percent-reduction";
	private boolean colorCoincidence;
	private By idCont;
	private By xpathFrame;
	private By xpathCDTitle;
	private By xpathCDSub;
	private By classPriceOffColor;
	private List<WebElement> capture;
	private String expectedColorBlock;
	private String expectedColorFrame;
	private String expectedPxCBTitle;
	private String expectedPxCBSub;
	private String expectedColorCBSub;
	private String setColor;
	private String blockColor;
	private String frameColor;
	private String cssFontSizeTitleCB;
	private String cssFontSizeSubTitleCB;
	private String cssColorSubTitleCB;
	private WebDriver driver;
	private WebElement titleCB;
	private WebElement subTitleCB;
	private WebElement block;
	private WebElement frame;
	
	public PageHome (WebDriver driver) {
		this.driver = driver;
		idCont = By.id(ID_CONT_DOM);
		xpathFrame = By.xpath(XPATH_FRAME_DOM);
		xpathCDTitle = By.xpath(XPATH_CDTITLE_DOM);
		xpathCDSub = By.xpath(XPATH_CSSUB_DOM);
		classPriceOffColor = By.className(CLASS_PRICEOFF_DOM);
	}
	
	public void setCmsInfo(String colorBlockRgba, String colorFrameHex) {
		expectedColorBlock = colorBlockRgba;
		expectedColorFrame = colorFrameHex;
		block = driver.findElement(idCont);
		frame = driver.findElement(xpathFrame);
		blockColor = block.getCssValue("background-color");
		String frameRgba = frame.getCssValue("background-color");
		frameColor = Color.fromString(frameRgba).asHex();
	}
	
	public void setCmsInfo(String pxCBTitle, String pxCBSub, String colorCBSub) {
		expectedPxCBTitle = pxCBTitle;
		expectedPxCBSub = pxCBSub;
		expectedColorCBSub = colorCBSub;
		titleCB = driver.findElement(xpathCDTitle);
		cssFontSizeTitleCB = titleCB.getCssValue("font-size");
		subTitleCB = driver.findElement(xpathCDSub);
		cssFontSizeSubTitleCB = subTitleCB.getCssValue("font-size");
		cssColorSubTitleCB = subTitleCB.getCssValue("color");
	}
	
    public void setColorOffPrice(String color) {
    	setColor = color;
    	capture = driver.findElements(classPriceOffColor);
    	int numAux = capture.size();
    	int colorsIdem = 0;
    		for (int colorIterator = 0 ; colorIterator<numAux ; colorIterator++) {
	    		String captureVar = capture.get(colorIterator).getCssValue("background-color").toString();
	    		if (captureVar.equalsIgnoreCase(setColor)){
					colorsIdem++; 
	    		}
	    	}
	    	if (colorsIdem == numAux) {
	    	colorCoincidence = true;
	    		} else { 
	    		colorCoincidence = false;
	    		}    		
    	}
    public boolean colorCoincidence() {return colorCoincidence;}
    public List<WebElement> capture () {return capture;}
    public String pxTitle() {return expectedPxCBTitle;}
	public String pxSub() {return expectedPxCBSub;}
    public String colorFontSub() {return expectedColorCBSub;}
    public String priceColor() {return setColor;}
    public String blockColor() {return blockColor;}
    public String frameColor() {return frameColor;}
    public String expectedColorBlock() {return expectedColorBlock;}
    public String expectedColorFrame() {return expectedColorFrame;}
    public String fontSizeTitleCB() {return cssFontSizeTitleCB;}
    public String fontSizeSubTitleCB() {return cssFontSizeSubTitleCB;}
    public String colorSubTitleCB() {return cssColorSubTitleCB;}  
    public WebElement titleCB() {return titleCB;}
	public WebElement subTitleCB() {return subTitleCB;}
}

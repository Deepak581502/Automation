package pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends Basepage {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//input[@id='txtStationFrom']")
	WebElement FromField;
	
	@FindBy(xpath="//div[@class='autocomplete']//div[@style='width:240px;float:left;overflow:hidden']")
	List<WebElement> stationDropdown ;
	//@FindBy(xpath="//table[@class='Month']//tr/td[text()='Jan-25']/parent::tr/following-sibling::tr//td[text()='31']")
	//WebElement datepicker;
	@FindBy(xpath="//input[@title='Select Departure date for availability']")
	WebElement date;
	
	// Click on From field
	 public void clickFromField() {
		 FromField.click();
	    }
	 
	// Clear the "From" field
	 public void clearFromField() {
		 FromField.clear();
	    }
	 
	 //Insert data into From field to open the dropdown
	 
	 public void enterFromField(String station) {
		 FromField.sendKeys(station);
	    }
	 
	 public void selectStationFromDropdown() {
	      //  List<WebElement>list=driver.findElements((By) stationDropdown);
	            String selectedStation =stationDropdown.get(3).getText();
	        System.out.println(selectedStation);
	        stationDropdown.get(3).click();
	        
	    }
	 
	 public List<String> getDropdownOptions() {
		 List<String> dropdownOptions = new ArrayList<>();
	        
	        // Iterate over the WebElement list and get the text of each WebElement
	        for (WebElement option : stationDropdown) {
	            dropdownOptions.add(option.getText());
	        }

	        return dropdownOptions;
	    }
	 
	 public void clickonDate() {
		 date.click();
	 }
	 public void Datepicker(String month,String date) {
		 
		 
		 String xpath1 = "//table[@class='Month']//tr/td[text()='" + month + "']/parent::tr/following-sibling::tr//td[text()='" + date + "']";
		 String xpah2="//table[@class='Month']//tr/td[text()='Jan-25']/parent::tr/following-sibling::tr//td[text()='31']";
		 driver.findElement(By.xpath(xpah2)).click();
	 }

	
}

package testCase;

import java.util.List;

import org.testng.annotations.Test;

import Utility.ExcelUtil;
import junit.framework.Assert;
import pageObject.HomePage;

public class Testcase_UseCase extends BaseTestcase{
	@Test
	public void UseCase1() throws Exception {
	HomePage hp= new HomePage(driver);
	//step 2
	hp.clickFromField();
	//step 3
	hp.clearFromField();
	//step 4
	hp.enterFromField("DEL");

	// step 7
	List<String>list=hp.getDropdownOptions();
	//ExcelUtil.writeDropdownDataToExcel(1, 2, list);
	String expected=ExcelUtil.getcelldata(2, 0);
	String actual=ExcelUtil.getcelldata(1, 4);
	//Assert.assertEquals("The strings are not equal!", expected, actual);
	if (expected.equals(actual)) {
		//select 4th from DropDown
		hp.selectStationFromDropdown();
        // select date 
		hp.clickonDate();
		
		hp.Datepicker("Jan", "31");
    } 
	
}
	
}

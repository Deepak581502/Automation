package testCase;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.ExcelUtil;
import pageObject.HomePageHRM;

public class Test_User_Case2 extends BaseTestcase {
      
	@Test(dataProvider = "loginData")
	public void login_Testcase_valid(String usr, String pwd) throws Exception {
		HomePageHRM hrm=new HomePageHRM(driver);
		//String usr=ExcelUtil.getcelldata(9, 0);
		//String pwd=ExcelUtil.getcelldata(9, 1);
		hrm.Enterusername(usr);
		hrm.Enterpassword(pwd);
		hrm.Sign();		
	}
	
	 @DataProvider(name = "loginData")
	    public Object[][] getLoginData() {
	        Object[][] data = new Object[2][2]; // We have 2 rows of test data and 2 columns
	        
	        try {
	            // Read data from Excel for rows 9 
	            data[0][0] = ExcelUtil.getcelldata(9, 0); // Row 9, Column 0 (usr)
	            data[0][1] = ExcelUtil.getcelldata(9, 1); // Row 9, Column 1 (Password)
	            
	            data[1][0] = ExcelUtil.getcelldata(10, 0); // Row 10, Column 0 (pwd)
	            data[1][1] = ExcelUtil.getcelldata(10, 1); // Row 10, Column 1 (pwd)
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        return data;
	    }
	    }


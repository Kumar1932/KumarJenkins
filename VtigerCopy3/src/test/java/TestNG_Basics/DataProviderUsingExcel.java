package TestNG_Basics;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Vtiger.generic.FileUtility.ExcelUtility;

public class DataProviderUsingExcel 
{
@Test(dataProvider="data")
public void createOrgTest(String name,String Gears)
{
	System.out.println(name+" "+Gears);
}

@DataProvider
public Object[][] data() throws Exception
{
    ExcelUtility elib=new ExcelUtility();
    int rowCount = elib.getRowCount("DataP");
    System.out.println(rowCount);
	Object[][] objArr=new Object[rowCount][2];
	for(int i=0;i<rowCount;i++)
	{
		objArr[i][0]=elib.getDataFromExcel("DataP", i+1, 0);
		objArr[i][1]=elib.getDataFromExcel("DataP", i+1, 1);
	}
	return objArr;
}
}

package TestNG_Basics;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderUsage 
{
@Test(dataProvider="data")
public void test(String name, String nickName)
{
	System.out.println("name---->"+name+" nickName---->"+nickName);
}

@DataProvider
public Object[][] data()
{
	Object[][] objArray=new Object[3][2];
	objArray[0][0]="Luffy";
	objArray[0][1]="Strawhat Luffy";
	objArray[1][0]="Zoro";
	objArray[1][1]="Pirate Hunter";
	objArray[2][0]="Sanji";
	objArray[2][1]="Black Leg";
	return objArray;
}
}

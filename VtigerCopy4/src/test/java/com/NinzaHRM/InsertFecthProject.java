package com.NinzaHRM;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.Vtiger.generic.DatabaseUtility.DatabaseUtility;

public class InsertFecthProject 
{
public static void main(String[] args) throws SQLException 
{
DatabaseUtility db=new DatabaseUtility();
db.getDbConnection();
int result = db.executeNonSelectQuery("insert into project values('NH_1071','Gear5Luffy','05/08/1997','Nika','craeted','0')");
System.out.println(result);

ResultSet result1 = db.executeSelectQuery("select * from project where project_name='Nika'");
while(result1.next())
{
	System.out.println(result1.getString(2));
}

}
}

package com.Vtiger.generic.FileUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.Vtiger.ConstantPaths.iPathConstants;

public class ExcelUtility 
{
public String getDataFromExcel(String sheet,int rowNum,int cellNum) throws Exception
{
	FileInputStream fis=new FileInputStream(iPathConstants.excelPath);
	Workbook wb = WorkbookFactory.create(fis);
	String data = wb.getSheet(sheet).getRow(rowNum).getCell(cellNum).toString();
	wb.close();
	return data;
}
public int getRowCount(String sheet) throws Exception
{
	FileInputStream fis=new FileInputStream(iPathConstants.excelPath);
	Workbook wb = WorkbookFactory.create(fis);
	int data = wb.getSheet(sheet).getLastRowNum();
	wb.close();
	return data;
}
public void setDataIntoExcel(String sheet,int rowNum,int cellNum,String data) throws Exception
{
	FileInputStream fis=new FileInputStream(iPathConstants.excelPath);
	Workbook wb = WorkbookFactory.create(fis);
    Cell cel = wb.getSheet(sheet).getRow(rowNum).createCell(cellNum);
    
    cel.setCellValue(data);
    FileOutputStream fos=new FileOutputStream(iPathConstants.excelPath);
    wb.write(fos);
    wb.close();   
}

public int getCellCount(String sheet,int row) throws Exception
{
	FileInputStream fis=new FileInputStream(iPathConstants.excelPath);
	Workbook wb = WorkbookFactory.create(fis);
	int data = wb.getSheet(sheet).getRow(row).getLastCellNum();
	wb.close();
	return data;
}
}

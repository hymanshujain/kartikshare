package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel
{
	
	public static String getData(String filePath, String sheetName,int row, int cell)
	{
		String value= null;

		try
		{
			XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(new File(filePath)));
			XSSFCell cl = wb.getSheet(sheetName).getRow(row).getCell(cell);

			switch (cl.getCellType())
			{
			case STRING:
				value=cl.getStringCellValue();
				break;	
			case NUMERIC:
				value=Integer.toString((int)cl.getNumericCellValue());
				break;
			default:
				value=cl.getStringCellValue();
				break;
			}
			wb.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return value;
	}
	
	//----------------------------------------------------------------------------
	//Get Question Answer Workbook
	//----------------------------------------------------------------------------
	public static XSSFWorkbook getQAWorkbook()
	{
		XSSFWorkbook wb= null;
		try
		{
			FileInputStream fis = new FileInputStream(new File("./Excel_Data/QA_Results.xlsx"));
			wb= new XSSFWorkbook(fis);

		}
		catch(IOException e)
		{

		}
		return wb;
	}
	


	public static XSSFSheet getSheet(XSSFWorkbook wb, String SheetName)
	{
		XSSFSheet sh = wb.createSheet(SheetName);
		return sh;	
	}

	public static XSSFSheet getOrCreateSheet(XSSFWorkbook wb, String SheetName)
	{
		XSSFSheet sh= null;
		if(wb.getSheet(SheetName)!=null)
		{
			sh=wb.getSheet(SheetName);
		}
		else
		{
			sh = wb.createSheet(SheetName);
		}
		return sh;	
	}

	public static XSSFRow createOrGetRow(XSSFSheet sh, int rowNum)
	{
		XSSFRow row=null;
		if (sh.getRow(rowNum)!=null)
		{
			row=sh.getRow(rowNum);
		}
		else
		{
			row=sh.createRow(rowNum);
		}

		return row;
	}

	public static void setData(String filePath, XSSFSheet sh,int rowNum, int cellNum, String value)
	{
		try
		{
			FileOutputStream fos = new FileOutputStream(new File(filePath));
			XSSFRow row = createOrGetRow(sh, rowNum);
			XSSFCell cell = row.createCell(cellNum);
			cell.setCellValue(value);
			row.getSheet().getWorkbook().write(fos);
			

		}
		catch(IOException e)
		{

		}
	}

	//----------------------------------------------------------------------------
	//Write Pass / Fail results in excel
	//----------------------------------------------------------------------------
	public static void writeResultsInExcel(XSSFSheet sh,int rowNum,int cellNum, String value)
	{
		try
		{
			FileOutputStream fos = new FileOutputStream(new File("./Excel_Data/QA_Results.xlsx"));
			XSSFRow row = createOrGetRow(sh, rowNum);
			XSSFCell cell = row.createCell(cellNum);
			cell.setCellValue(value);
			row.getSheet().getWorkbook().write(fos);
			
		}
		catch(IOException e)
		{

		}
	}
	
}

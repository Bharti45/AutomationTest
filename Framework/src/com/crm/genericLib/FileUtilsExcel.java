package com.crm.genericLib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtilsExcel
{
	String filepath="./data/commondata.properties";
	String excelpath="./data/testdata.xlsx";
	
	public Properties getPropertiesFileObject() throws Throwable
	{
		FileInputStream fis= new FileInputStream(filepath);
		Properties pObj= new Properties();
		pObj.load(fis);
		return pObj;
		
	}
	
	public String getExcelData(String sheetName, int rowNum, int colNum) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		FileInputStream fis= new FileInputStream(excelpath);
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sh= wb.getSheet(sheetName);
		String data= sh.getRow(rowNum).getCell(colNum).getStringCellValue();
		wb.close();
		return data;
		
		
	}
	
	public void setExcelData(String sheetName, int rowNum, int colNum, String data) throws Throwable
	{
		FileInputStream fis = new FileInputStream(excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh= wb.getSheet(sheetName);
		sh.getRow(rowNum).createCell(colNum).setCellValue(data);
		
		FileOutputStream fos= new FileOutputStream(excelpath);
		wb.write(fos);
		wb.close();
	}

	}



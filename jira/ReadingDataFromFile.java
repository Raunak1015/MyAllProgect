package jira;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataFromFile {
	
	public static void main(String[] args) throws IOException
	{
		
		FileInputStream file=new FileInputStream("D:\\Test.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		//XSSFRow row=sheet.getRow(1);
		System.out.println(sheet.getLastRowNum());
		System.out.println(sheet.getRow(0).getLastCellNum());
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			XSSFRow currentRow=sheet.getRow(i);
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
			{
				String Value=currentRow.getCell(j).toString();
				System.out.print("              "+Value);
			}
			System.out.println();
		}
		
		System.out.println(sheet.getRow(0).getCell(0));

		

		
		
	}

}

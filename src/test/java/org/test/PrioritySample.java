package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class PrioritySample {
	public static Object[][] getdata() throws Throwable{
		File f=new File("E:\\Eclipse\\Testng\\src\\test\\resources\\Book1.xlsx");
		FileInputStream f1=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(f1);
		Sheet s=w.getSheet("sheet1");
		Row rowheader = s.getRow(0);
		String name=null;
		Object obj[][]=new Object[s.getPhysicalNumberOfRows()][rowheader.getPhysicalNumberOfCells()];
		for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {
			Row r=s.getRow(i);
			for (int j = 0; j <r.getPhysicalNumberOfCells(); j++) {
				Cell cell = r.getCell(j);
				int cellType = cell.getCellType();
				if(cellType==1)
				{
					name = cell.getStringCellValue();
				}
				if(cellType==0)
				{
					if(DateUtil.isCellDateFormatted(cell))
					{
						Date d=cell.getDateCellValue();
						SimpleDateFormat sd=new SimpleDateFormat("mm/dd/yyyy");
						name=sd.format(d);
					}
					else {
						double d=cell.getNumericCellValue();
						long l=(long)d;
						name = String.valueOf(l);
					}
					
						
					}
				obj[i][j]=name;
				}
			
			
				
			}	
		
		return obj;
	}

}

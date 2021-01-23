/**
 * 
 */
package excel_data_create_update_delete;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.format.CellFormat;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

/**
 * @author acer
 *
 */
public class Dtd_Instances {

	XSSFWorkbook xswb;
	XSSFSheet xss;
	FileInputStream fis;
	FileOutputStream fos;
	File fil;
	File fill;
	String file_location = "G:\\DTD_Project\\Excel\\Login.xlsx";

	@Test(enabled = false)
	public void read_excel() throws IOException {
		fil = new File(file_location);
		try {
			fis = new FileInputStream(fil);
			xswb = new XSSFWorkbook(fis);
			/*---------To delete a sheet---------------
			xswb.removeSheetAt(0);*/
			/*---------To edit a sheet name---------------
			xswb.setSheetName(0, "DTRELEASE");*/
			/*---------To change the position of index of sheet---------------
			xswb.setSheetOrder("DTRELEASE", 1);*/
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		fos = new FileOutputStream(file_location);
		xswb.write(fos);
		fos.close();
		xswb.close();
		System.out.println("Mahesh1");
		System.out.println("Mahesh2");
		System.out.println("Mahesh3");
	}

	@Test(enabled=false)
	public void write_excel() throws IOException {

		fil = new File(file_location);
		try {
			fis = new FileInputStream(fil);
			xswb = new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		XSSFCellStyle cs = xswb.createCellStyle();
		Font f = xswb.createFont();
		f.setBold(true);
		cs.setFont(f);
		xss = xswb.getSheet("dtdev");
		/*xss.getRow(0).createCell(2).setCellValue("Login Name");
		xss.getRow(0).getCell(2).setCellStyle(cs);*/
		/*
		 * xss.createRow(0).createCell(0).setCellValue("Login");
		 * xss.getRow(0).getCell(0).setCellStyle(cs);
		 * xss.getRow(0).createCell(1).setCellValue("Password");
		 * xss.getRow(0).getCell(1).setCellStyle(cs);
		 */
		/*for (int i = 1; i < 5; i++) {
			xss.createRow(i).createCell(0).setCellValue("mahesh.babu@nd" + (10 + i) + ".com");
		}
		for (int j = 1; j < 5; j++) {
			xss.getRow(j).createCell(1).setCellValue("dispatchtrack");
		}*/
		fos = new FileOutputStream(file_location);
		xswb.write(fos);
		fos.close();
		xswb.close();
	}
	@Test
	public void dtd_allscreens() throws IOException
	{
		fil = new File(file_location);
		try {
			fis = new FileInputStream(fil);
			xswb = new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		Font fo=xswb.createFont();
		fo.setBold(true);
		XSSFCellStyle style=xswb.createCellStyle();
		style.setFont(fo);
		xswb=new XSSFWorkbook();
		xss=xswb.createSheet("Instance_URL");
		xss.createRow(0).createCell(0).setCellValue("Module");
		/*xss.getRow(0).getCell(0).setCellStyle(style);*/
		xss.getRow(0).createCell(1).setCellValue("URL");
		/*xss.getRow(0).getCell(1).setCellStyle(style);*/
		fos = new FileOutputStream(file_location);
		xswb.write(fos);
		fos.close();
		xswb.close();
	}

}

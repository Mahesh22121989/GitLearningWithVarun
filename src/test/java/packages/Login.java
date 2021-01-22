/**
 * 
 */
package packages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

/**
 * @author acer
 *
 */
public class Login {
	XSSFWorkbook xwb;
	XSSFSheet xss;
	HSSFWorkbook hwb;
	HSSFSheet hss;
	FileInputStream fis;
	FileOutputStream fos;


	@Test
	public void open_Exccel(String file_location)
	{
		try {
			File fil=new File(file_location);
			fis=new FileInputStream(fil);
			xwb=new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Error message when file not found ::" + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error message is whe error in workbook ::" + e.getMessage() );
			e.printStackTrace();
		}	
	}
	@Test
	public String read_Data(String sheet_name,int row,int column) throws IOException
	{
		xss=xwb.getSheet(sheet_name);
		String cell_readdata=xss.getRow(row).getCell(column).getStringCellValue();
		
		return cell_readdata;
	}
	@Test
	public void write_data(String sheet_name,int row,int column,String wri_data)
	{
		xss=xwb.getSheet(sheet_name);
		xss.getRow(row).createCell(column).setCellValue(wri_data);
	}
	@Test
	public int totl_no_of_users(String sheet_name)
	{
		xss=xwb.getSheet(sheet_name);
		int first_user=xss.getFirstRowNum();
		int last_user=xss.getLastRowNum();
		int total_users=last_user-first_user;
		System.out.println("Total no of users available are ::"+ total_users);
		int users_count=xss.getLastRowNum();
		
		return users_count;
	}
	@Test
	public void close_excel(String sname) throws IOException
	{
		fos=new FileOutputStream(sname);
		xwb.write(fos);
		fos.close();
		xwb.close();
		
	}

}

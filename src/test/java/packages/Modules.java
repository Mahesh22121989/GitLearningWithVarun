/**
 * 
 */
package packages;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

/**
 * @author acer
 *
 */
public class Modules {
	XSSFWorkbook xswb;
	XSSFSheet xsh;
	@Test
	public void  modules_url_capture(String sheetname,int row,int column,String cell_value) throws IOException
	{
	xsh=xswb.getSheet(sheetname);
	xsh.createRow(row).createCell(column).setCellValue(cell_value);	
	}

}

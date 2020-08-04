package in.co.istqb.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLib {
	
	public String filePath;
	
	public ExcelLib(String filePath){
		this.filePath=filePath;
	}
	
	public String readData(String sheet,int row, int cell) {
		String value=null;
		
		try{
			File file=new File(filePath);
			FileInputStream fis=new FileInputStream(file);
			Workbook wb = WorkbookFactory.create(fis);
			Cell cl = wb.getSheet(sheet).getRow(row).getCell(cell);
			
			switch(cl.getCellType()){
			
			case STRING:
				value=cl.getStringCellValue();
				break;
			case BOOLEAN:
				boolean bValue = cl.getBooleanCellValue();
				value=Boolean.toString(bValue);
				break;
			case NUMERIC:
				if(DateUtil.isCellDateFormatted(cl)){
					SimpleDateFormat sdf=new SimpleDateFormat("ddMMyyyy");
					value=sdf.format(cl.getDateCellValue());
				}
				else{
					double dValue=(double)cl.getNumericCellValue();
					value=Double.toString(dValue);
				}
				break;
			default:
			break;	
			}
		}
		catch(EncryptedDocumentException ede){
			ede.getCause();
			ede.printStackTrace();
		}
		catch(IOException io){
			io.getCause();
			io.printStackTrace();
		}
		
		return value;
	}
}

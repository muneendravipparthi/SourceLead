package SourceLead.com.sourcelead.qaautomation.testing;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class CreateCanditeResumes {
	public static void main(String[] args) throws IOException, InterruptedException {
	File file = new File("E:\\Add Candidate.xlsx");
	FileInputStream inputfile = new FileInputStream(file);
	Workbook Project = new XSSFWorkbook(inputfile);
	Sheet sheet = Project.getSheet("Add Candidate");
	int k = sheet.getLastRowNum() - sheet.getFirstRowNum();
	
	for (int i = 1; i <= k; i++) {
		Row row = sheet.getRow(i);
		String firstname = row.getCell(0).getStringCellValue();
		String lastname = row.getCell(1).getStringCellValue();
		String email = row.getCell(2).getStringCellValue();
		int mobile = (int) row.getCell(3).getNumericCellValue();
		String role = row.getCell(4).getStringCellValue();
		
		 //Blank Document
	      XWPFDocument document= new XWPFDocument(); 
	      //Write the Document in file system
	      FileOutputStream out = new FileOutputStream(new File(firstname+" "+lastname+" "+"Resume.docx"));
	        
	      //create Paragraph
	      XWPFParagraph paragraph = document.createParagraph();
	      XWPFRun run=paragraph.createRun();
	      run.setText("Name : " +firstname+" "+lastname);
	      
	      paragraph = document.createParagraph();
	      run=paragraph.createRun();
	      run.setText("Email : " + email);
	     
	      paragraph = document.createParagraph();
	      run=paragraph.createRun();
	      run.setText("Mobile : " + mobile);
	      
	      paragraph = document.createParagraph();
	      run=paragraph.createRun();
	      run.setText("Role : " + role);
	      
	      paragraph = document.createParagraph();
	      run=paragraph.createRun();
	      run.setText("Created by Muneendra");
	      
	      document.write(out);
	      out.close();
	      System.out.println(firstname+" "+lastname+" "+"Resume.docx written successfully");	
		
		}
	}
}

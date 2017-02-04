package SourceLead.com.sourcelead.qaautomation.testing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Hybrid {

	public static void main(String[] args) throws IOException, InterruptedException {
		File file = new File("Exp.xlsx");
		FileInputStream inputfile = new FileInputStream(file);
		Workbook Project = new XSSFWorkbook(inputfile);
		Sheet sheet = Project.getSheet("Sheet1");
		int k = sheet.getLastRowNum() - sheet.getFirstRowNum();
		
			System.setProperty("webdriver.chrome.driver",
				"C:\\QA\\SourceLead\\SeleniumJar\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			String URL = sheet.getRow(1).getCell(3).getStringCellValue();
			driver.get(URL);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		
		for (int i = 2; i <= k; i++) {
			Row row = sheet.getRow(i);
			String Xpath = row.getCell(1).getStringCellValue();
			String fieldtype = row.getCell(2).getStringCellValue();
			String Inputdaa = row.getCell(3).getStringCellValue();
			String validating = row.getCell(4).getStringCellValue();
			String Expected = row.getCell(5).getStringCellValue();
			String visible = sheet.getRow(i+1).getCell(1).getStringCellValue();
			Thread.sleep(3000);
			
			
			if(fieldtype.equals("Sendkeys")){
				driver.findElement(By.xpath(Xpath)).sendKeys(Inputdaa);
			}else if (fieldtype.equals("Click")) {
				driver.findElement(By.xpath(Xpath)).click();
			}else if (fieldtype.equals("Droupdown")) {
				new Select(driver.findElement(By.xpath(Xpath))).selectByVisibleText(Inputdaa);
			}

			
			
			for (int second = 0;; second++) {
				if (second >= 300 ){
			        System.out.println("Failed to load page, too slow!");
			        return;
			    }
				try { 
			   if ( driver.findElement(By.xpath(visible))!= null ){
			        break; 
			    }
			     } catch (Exception e) {
					 //System.out.println("Exception is :" +e);
				 }
				Thread.sleep(1000);
				}
		}
								
	}
}

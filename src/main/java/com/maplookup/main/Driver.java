package com.maplookup.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import au.com.bytecode.opencsv.CSVReader;

import com.maplookup.db.domain.Zipcodes;
import com.maploopup.service.ZipcodesService;
public class Driver {
	
	final static String DATA_FILE_PATH = "C:\\Documents and Settings\\Administrator\\Desktop\\ZipCOdes.csv";
	
    public static void main(String[] args) {
        System.out.println("load context");
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
//        
//        Workbook workbook;
//		try {
//			workbook = Workbook.getWorkbook(new File(EXCEL_FILE_PATH));
//		
//        Sheet sheet = workbook.getSheet(0);
//        for (int i = 0; i< sheet.getRows(); i++) {
//            for (int j = 0; j < sheet.getColumns(); j++) {
//              Cell cell = sheet.getCell(i,j);
//              CellType type = cell.getType();
//                System.out.println(cell.getContents());
//              }
//            break;
//            }
//        workbook.close();
//        
//        
//		} catch (BiffException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        
        
        
        
        
        ZipcodesService zipcodesService = (ZipcodesService) context.getBean("zipcodesService");
        CSVReader reader;
		try {
			reader = new CSVReader( new FileReader( DATA_FILE_PATH ),',', '\"',1);
		
        //   
//            wr  = new CSVWriter( new FileWriter( "/Users/vinaykumar/Desktop/PlayerNamesImageNotExist.csv" ) , ',' , '\"' );
				    String [] nextLine;
				    while ((nextLine = reader.readNext()) != null) {
				        if(nextLine.length > 6){
				        	System.out.println(Arrays.asList(nextLine));
				        if(nextLine[0].trim().isEmpty()) continue;	
				         Zipcodes zip = new Zipcodes();
				        	
				        zip.setZip(nextLine[0].trim());
				        zip.setCity(nextLine[1].trim());
				        zip.setState( nextLine[2].trim());
				        zip.setLatitude(Double.parseDouble(nextLine[3].trim()) );
				        zip.setLongitude( Double.parseDouble(nextLine[4].trim()) );
				        zip.setTimezone( nextLine[5].trim());
				        if(nextLine[6].trim().equals("1"))
				        zip.setDst( true );
				        else
				        	zip.setDst( false );	
//				        System.out.println(Arrays.asList(nextLine));
				        zipcodesService.persistZipCodes( zip );
				        }
				        
				    }
        
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        
//        emService.persistZipCodes( em );
//        System.out.println("Updated age :" + emService.findEmployeeById("123").getAge());       
//        em.setAge(32);
//        emService.updateEmployee(em);
//        System.out.println("Updated age :" + emService.findEmployeeById("123").getAge());
//        emService.deleteEmployee(em);
//        System.out.println(emService.findZipCodesById( 210 ).getCity());
        context.close();
    }
}

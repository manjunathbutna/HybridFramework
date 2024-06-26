//package com.sause.utils;
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import com.Admin.qa.Base.TestBase;
//
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.File;
//
//public class ExcelUtilities {
//	
//	
//	public static void devicedata() {
//		
//		try {
//            // Specify the path to the existing Excel file
//			String filePath = System.getProperty("user.home")+"/eclipse-workspace/BusinessAdmin/DownloadedFiles/sample.xlsx";
//			
//            // Load the existing workbook
//            FileInputStream fis = new FileInputStream(filePath);
//            Workbook workbook = new XSSFWorkbook(fis);
//            fis.close();
//
//            // Get the first sheet (assuming data is in the first sheet)
//            Sheet sheet = workbook.getSheetAt(0);
//
//            // Find the last row number (assuming the data starts from the second row)
//            int lastRowNum = sheet.getLastRowNum() + 1;
//
//            // Create a new row
//            Row newRow = sheet.createRow(lastRowNum);
//            
//            String slno = "3500"+TestBase.generateRandomDigits(10);
//
//            // Write data to 'Serial Number' column (assuming it's in the first column)
//            Cell serialNumberCell = newRow.createCell(0, CellType.NUMERIC);
//            serialNumberCell.setCellValue(slno); // You can customize the serial number logic
//
//            // Write data to 'IMEI' column (assuming it's in the second column)
//            Cell imeiCell = newRow.createCell(1, CellType.NUMERIC);
//            imeiCell.setCellValue(slno); // Use a method to generate a 14-digit random number
//
//            // Save the changes to the Excel file
//            try (FileOutputStream fos = new FileOutputStream(filePath)) {
//                workbook.write(fos);
//                System.out.println("Data written to Excel successfully."+slno);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//	}
//	
//	public void writeDataToDelete() {
//		try {
//            // Specify the path to the existing Excel file
//			String filePath = System.getProperty("user.home")+"/eclipse-workspace/BusinessAdmin/DownloadedFiles/deviceDeleteTemplate.xlsx";
//			
//            // Load the existing workbook
//            FileInputStream fis = new FileInputStream(filePath);
//            Workbook workbook = new XSSFWorkbook(fis);
//            fis.close();
//
//            // Get the first sheet (assuming data is in the first sheet)
//            Sheet sheet = workbook.getSheetAt(0);
//
//            // Find the last row number (assuming the data starts from the second row)
//            int lastRowNum = sheet.getLastRowNum() + 1;
//
//            // Create a new row
//            Row newRow = sheet.createRow(lastRowNum);
//            
//            String simno = "9885"+TestBase.generateRandomDigits(6);
//
//            // Write data to 'Serial Number' column (assuming it's in the first column)
//            Cell phoneNumber = newRow.createCell(0, CellType.NUMERIC);
//            phoneNumber.setCellValue(simno); // You can customize the serial number logic
//
//            // Write data to 'IMEI' column (assuming it's in the second column)
//            Cell simNumber = newRow.createCell(1, CellType.NUMERIC);
//            simNumber.setCellValue(simno); // Use a method to generate a 14-digit random number
//            
//            Cell monthlyCharges = newRow.createCell(1, CellType.NUMERIC);
//            monthlyCharges.setCellValue(simno);
//
//            // Save the changes to the Excel file
//            try (FileOutputStream fos = new FileOutputStream(filePath)) {
//                workbook.write(fos);
//                System.out.println("Data written to Excel successfully."+simno);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//	}
//	
//	public static void simdata() {
//		
//		try {
//            // Specify the path to the existing Excel file
//			String filePath = System.getProperty("user.home")+"/eclipse-workspace/BusinessAdmin/DownloadedFiles/sample.xlsx";
//			
//            // Load the existing workbook
//            FileInputStream fis = new FileInputStream(filePath);
//            Workbook workbook = new XSSFWorkbook(fis);
//            fis.close();
//
//            // Get the first sheet (assuming data is in the first sheet)
//            Sheet sheet = workbook.getSheetAt(0);
//
//            // Find the last row number (assuming the data starts from the second row)
//            int lastRowNum = sheet.getLastRowNum() + 1;
//
//            // Create a new row
//            Row newRow = sheet.createRow(lastRowNum);
//            
//            String simno = "9885"+TestBase.generateRandomDigits(6);
//
//            // Write data to 'Serial Number' column (assuming it's in the first column)
//            Cell phoneNumber = newRow.createCell(0, CellType.NUMERIC);
//            phoneNumber.setCellValue(simno); // You can customize the serial number logic
//
//            // Write data to 'IMEI' column (assuming it's in the second column)
//            Cell simNumber = newRow.createCell(1, CellType.NUMERIC);
//            simNumber.setCellValue(simno); // Use a method to generate a 14-digit random number
//            
//            Cell monthlyCharges = newRow.createCell(2, CellType.NUMERIC);
//            monthlyCharges.setCellValue("40");
//
//            // Save the changes to the Excel file
//            try (FileOutputStream fos = new FileOutputStream(filePath)) {
//                workbook.write(fos);
//                System.out.println("Data written to Excel successfully."+simno);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//		
//		
//
//	}
//	
//	
//	// Method to delete the .tmp files in the directory
//	public static void deleteTMPfiles() {
//		
//		String directoryPath = System.getProperty("user.home")+"/eclipse-workspace/BusinessAdmin/DownloadedFiles";
//		
//		String fileExtension = ".tmp";
//		
//		File directory = new File(directoryPath);
//
//        // Get all files in the directory
//        File[] files = directory.listFiles();
//        
//        if (files != null) {
//            // Iterate through the files
//            for (File file : files) {
//                // Check if the file has the specified extension
//                if (file.isFile() && file.getName().endsWith(fileExtension)) {
//                    // Delete the file
//                    if (file.delete()) {
//                        System.out.println("Deleted: " + file.getAbsolutePath());
//                    } else {
//                        System.out.println("Failed to delete: " + file.getAbsolutePath());
//                    }
//                }
//            }
//        }
//        else {
//            System.out.println("Directory is empty or does not exist.");
//        }
//
//		
//	}
//	
//}

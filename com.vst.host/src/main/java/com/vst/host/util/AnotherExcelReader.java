//package com.vst.host.util;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import com.vst.host.model.HostDetails;
//
//public class AnotherExcelReader {
//	
//	public List<HostDetails> hostTest() {
//		List<HostDetails> hostdetail = new ArrayList<>();
//		FileInputStream file = null;
//		String path = "E:\\projects\\com.vst.host\\hostTestList.xlsx";
//		File xlsxFile = new File(path);
//		
//		
//		Workbook book = null;
//		try {
//			file = new FileInputStream(xlsxFile);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		
//		if (path.endsWith("xls")) {
//			book = new HSSFWorkbook();
//
//		} else if (path.endsWith("xlsx")) {
//			try {
//				book = new XSSFWorkbook(file);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		XSSFSheet sheet = (XSSFSheet) book.getSheet("Sheet1");
//		for (Row row : sheet) {
//			String hostName = row.getCell(1).getStringCellValue();
//			String hostAddress = row.getCell(2).getStringCellValue();
//			int customerId = (int) row.getCell(3).getNumericCellValue();
//			String device = row.getCell(4).getStringCellValue();
//			String manufacturingDate =row.getCell(5).getStringCellValue();
//			String saleDtae = row.getCell(6).getStringCellValue();
//			String numberOfDevice = row.getCell(7).getStringCellValue();
//			String unitPrice = row.getCell(8).getStringCellValue();
//			String deviceType = row.getCell(9).getStringCellValue();
//			String adaptorType = row.getCell(10).getStringCellValue();
//			String deviceLogoName = row.getCell(11).getStringCellValue();
//			String chargerCapacity = row.getCell(12).getStringCellValue();
//			
//			((HostDetails) hostdetail).setHostName(hostName);
//			((HostDetails) hostdetail).setHostAddress(hostAddress);
//			((HostDetails) hostdetail).setCustomerId(customerId);
//			((HostDetails) hostdetail).setDevice(device);
//			((HostDetails) hostdetail).setManufacturingDate(manufacturingDate);
//			((HostDetails) hostdetail).setSaleDate(saleDtae);
//			((HostDetails) hostdetail).setNumberOfDevice(numberOfDevice);
//			((HostDetails) hostdetail).setUnitPrice(unitPrice);
//			((HostDetails) hostdetail).setDeviceType(deviceType);
//			((HostDetails) hostdetail).setAdaptorType(adaptorType);
//			((HostDetails) hostdetail).setDeviceLogoName(deviceLogoName);
//			((HostDetails) hostdetail).setChargerCapacity(chargerCapacity);
//			
//			
//		}
//		try {
//			file.close();
//		} catch (IOException e) {
//
//			e.printStackTrace();
//		}
//		System.out.println(hostdetail);
//		return hostdetail;
//
//	}
//
//}
package com.vst.host.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.vst.host.model.HostDetails;

public class ExcelReader {

	public List<HostDetails> HostDetailsList() {

		List<HostDetails> hostList = new ArrayList<>();

		HostDetails hostdetails = new HostDetails();
		FileInputStream file = null;
		try {
			// to read data from a file in the form of sequence of bytes
			file = new FileInputStream("E:\\projects\\com.vst.host\\hostTestList1.xlsx");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// This class has methods to read and write Microsoft Excel and OpenOffice xml
		// files in . xls or . xlsx format

		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Sheet sheet = workbook.getSheet("Sheet1");
		Iterator<Row> rows = sheet.iterator();
		rows.next();

		// hasNext() either returns true or false while next() will actually iterate to
		// the record.
		while (rows.hasNext()) {
			Row row = rows.next();
			Iterator<Cell> cells = row.cellIterator();
			while (cells.hasNext()) {
				Cell cell = cells.next();

				cell = cells.next();
				String hostName = cell.getStringCellValue();
				System.out.println(hostName);

				cell = cells.next();
				int customerId = (int) cell.getNumericCellValue();
				System.out.println(customerId);

				cell = cells.next();
				String device = cell.getStringCellValue();
				System.out.println(device);

				cell = cells.next();
				String manufacturingDate =cell.getStringCellValue();
				System.out.println(manufacturingDate);

				cell = cells.next();
				String saleDate =(String) cell.getStringCellValue();
				System.out.println(saleDate);

				cell = cells.next();
				String numberOfDevice =(String) cell.getStringCellValue();
				System.out.println(numberOfDevice);

				cell = cells.next();
				String unitPrice =cell.getStringCellValue();
				System.out.println(unitPrice);

				cell = cells.next();
				String deviceType =(String) cell.getStringCellValue();
				System.out.println(deviceType);

				cell = cells.next();
				String adaptorType = cell.getStringCellValue();
				System.out.println(adaptorType);

				cell = cells.next();
				String deviceLogoName = cell.getStringCellValue();
				System.out.println(deviceLogoName);

				cell = cells.next();
				String chargerCapacity = (String)cell.getStringCellValue();
				System.out.println(chargerCapacity);

			
				hostdetails.setHostName(hostName);
				hostdetails.setCustomerId(customerId);
				hostdetails.setDevice(device);
				hostdetails.setManufacturingDate(manufacturingDate);
				hostdetails.setSaleDate(saleDate);
				hostdetails.setNumberOfDevice(numberOfDevice);
				hostdetails.setUnitPrice(unitPrice);
				hostdetails.setDeviceType(deviceType);
				hostdetails.setAdaptorType(adaptorType);
				hostdetails.setDeviceLogoName(deviceLogoName);
				hostdetails.setChargerCapacity(chargerCapacity);

				hostList.add(hostdetails);
			}

		}
		return hostList;
	}

}
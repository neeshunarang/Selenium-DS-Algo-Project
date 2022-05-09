package com.DsAlgoProject.Utilities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class XLUtils {
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public String xlFile;

	public XLUtils(String xlFile, String xlSheet) {
		try {
			fi = new FileInputStream(xlFile);
			wb = new XSSFWorkbook(fi);
			ws = wb.getSheet(xlSheet);
			this.xlFile = xlFile;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}

	public int getRowCount() {
		int rowCount = 0;
		try {
			rowCount = ws.getLastRowNum();
			wb.close();
			fi.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return rowCount;
	}

	public int getCellCount(int rowNum) {
		int columnCount = 0;
		try {
			row = ws.getRow(rowNum);
			columnCount = row.getLastCellNum();
			wb.close();
			fi.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return columnCount;
	}

	public String getCellData(int rowNum, int columnNum) throws IOException {
		String data = null;
		try {
			row = ws.getRow(rowNum);
			cell = row.getCell(columnNum);

			DataFormatter formatter = new DataFormatter();
			data = formatter.formatCellValue(cell);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		wb.close();
		fi.close();
		return data;
	}

	public void setCellData(int rowNum, int columnNum, Object data) throws IOException {
		try {
			row = ws.getRow(rowNum);
			if (row == null)
				row = ws.createRow(rowNum);
			cell = row.getCell(columnNum);
			if (cell == null)
				cell = row.createCell(columnNum);

			if (data instanceof Long)
				cell.setCellValue((Long) data);
			if (data instanceof Integer)
				cell.setCellValue((Integer) data);
			if (data instanceof String)
				cell.setCellValue((String) data);
			if (data instanceof Boolean)
				cell.setCellValue((Boolean) data);
			fo = new FileOutputStream(xlFile);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		wb.write(fo);
		wb.close();
		fo.close();
		fi.close();
	}
}
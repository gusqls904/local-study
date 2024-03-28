package com.local.study.common.util;

import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import jakarta.servlet.http.HttpServletResponse;

public class ExcelUtil {
	
	public static void downloadExcel(HttpServletResponse response ,Map<String, List> excelData) throws Exception{
		
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("테스트 엑셀");
		int rowNo = 0;
        
		Row headerRow = sheet.createRow(rowNo++);
		for (int i = 0; i < excelData.get("headerList").size(); i++) {
			headerRow.createCell(i).setCellValue(excelData.get("headerList").toString());
		}
        
//		for (int i = 0; i < excelData.get("rowList").size(); i++) {
//            Row row = sheet.createRow(rowNo++);
//            row.createCell(i).setCellValue();
//        }
        
        response.setContentType("ms-vnd/excel");
        response.setHeader("Content-Disposition", "attachment;filename=testExcel.xls");
        
        workbook.write(response.getOutputStream());
        workbook.close();
		
	}

}

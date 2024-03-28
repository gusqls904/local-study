package com.local.study.excel.ctrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.local.study.common.util.ExcelUtil;
import com.local.study.excel.dto.res.ExcelResDto;
import com.local.study.excel.svc.ExcelSvc;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class ExcelCtrl {

	@Autowired
	private ExcelSvc excelSvc;
	
	/**
	 * 테스트
	 */
	@GetMapping("/test")
	public void test() {
		int temp = excelSvc.test();
		System.out.print(temp);
	}
	
	/**
	 * 엑셀 다운로드
	 * @param response
	 * @throws Exception
	 */
	@GetMapping("/downloadExel")
	public void downloadExel(HttpServletResponse response) throws Exception{
		List<ExcelResDto> list =  excelSvc.downloadExel();
		
//        List<String> header = new ArrayList<>(); 
//        header.add("사원번호");
//        header.add("사원이름");
//        header.add("직업");
//        header.add("입사일");
//        header.add("급여");
//        header.add("부서번호");
//        
//        Map<String, List> excelData = new HashMap<>();
//        excelData.put("headerList", header);
//        excelData.put("rowList", list);
//        
//        ExcelResDto dto = new ExcelResDto();
//        for (int i = 0; i < excelData.get("rowList").size(); i++) {
//        	System.out.println(excelData.get("rowList").get(i).toString());
//		}
//        
//        ExcelUtil.downloadExcel(response,excelData);
        
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("테스트 엑셀");
		int rowNo = 0;
        
		Row headerRow = sheet.createRow(rowNo++);
        headerRow.createCell(0).setCellValue("사원번호");
        headerRow.createCell(1).setCellValue("사원이름");
        headerRow.createCell(2).setCellValue("직업");
        headerRow.createCell(3).setCellValue("입사일");
        headerRow.createCell(4).setCellValue("급여");
        headerRow.createCell(5).setCellValue("커미션");
        headerRow.createCell(6).setCellValue("부서번호");
        
        for (ExcelResDto resDto : list) {
            Row row = sheet.createRow(rowNo++);
            row.createCell(0).setCellValue(resDto.getEmpNo());
            row.createCell(1).setCellValue(resDto.getEName());
            row.createCell(2).setCellValue(resDto.getJob());
            row.createCell(3).setCellValue(resDto.getHireDate());
            row.createCell(4).setCellValue(resDto.getSal());
            row.createCell(5).setCellValue(resDto.getComm());
            row.createCell(6).setCellValue(resDto.getDeptNo());
        }
        
        response.setContentType("ms-vnd/excel");
        response.setHeader("Content-Disposition", "attachment;filename=testExcel.xls");
        
        workbook.write(response.getOutputStream());
        workbook.close();
	}
	
}

package com.local.study.excel.svc;

import java.util.List;

import com.local.study.excel.dto.res.ExcelResDto;

public interface ExcelSvc {
	
	public Integer test();

	public List<ExcelResDto> downloadExel();
	
}

package com.local.study.excel.svc.lmpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.local.study.excel.dao.ExcelDao;
import com.local.study.excel.dto.res.ExcelResDto;
import com.local.study.excel.svc.ExcelSvc;

@Service
public class ExcelSvcImpl implements ExcelSvc{
	
	@Autowired
	private ExcelDao excelDao;
	
	@Override
	public Integer test() {
		return excelDao.test();
	}

	@Override
	public List<ExcelResDto> downloadExel() {
		return excelDao.downloadExel();
	}
	
}
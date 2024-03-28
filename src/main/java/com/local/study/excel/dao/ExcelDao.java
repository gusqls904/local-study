package com.local.study.excel.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.local.study.excel.dto.res.ExcelResDto;

import java.util.List;

@Mapper
@Repository
public interface ExcelDao {

	Integer test();
	
	List<ExcelResDto> downloadExel();
}

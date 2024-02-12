package com.dodam.dodam.server.diary;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

@Mapper
public interface DiaryDAO {

    public int postdiary(DiaryDTO dto);
    public int deletediary(DiaryDTO dto);
    public int updatediary(DiaryDTO dto);
    public int getdiary(DiaryDTO dto);

}

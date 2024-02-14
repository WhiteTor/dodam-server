package com.dodam.dodam.server.diary;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface DiaryDAO {

    public int postdiary(DiaryDTO dto);
    public int deletediary(DiaryDTO dto);
    public int updatediary(DiaryDTO dto);
    public DiaryDTO getdiary(DiaryDTO dto);
    public List<DiaryDTO> getAlldiary(DiaryDTO dto);
    public int partialUpdate(DiaryDTO dto);

}

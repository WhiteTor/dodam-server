package com.dodam.dodam.server.diary;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DiaryDAO {

    public int posting(DiaryDTO dto);
    public int deletepost (DiaryDTO dto);
    public int updatepost (DiaryDTO dto);

}

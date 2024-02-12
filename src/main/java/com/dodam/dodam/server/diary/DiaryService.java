package com.dodam.dodam.server.diary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiaryService {

    @Autowired
    DiaryDAO dao;

    public int postdiary(DiaryDTO dto) { return dao.postdiary(dto); }
    public int deletediary(DiaryDTO dto) {
        // 삭제하시겠습니까?? 에 해당하는 무언가가 들어가야 할 것 같은데..
        return dao.deletediary(dto);
    }
    public int updatediary(DiaryDTO dto) { return dao.updatediary(dto); }

    public int getdiary(DiaryDTO dto) { return dao.getdiary(dto); }

    public int getAlldiary(DiaryDTO dto) { return dao.getAlldiary(dto); }
}
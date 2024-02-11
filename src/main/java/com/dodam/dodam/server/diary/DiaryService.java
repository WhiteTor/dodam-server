package com.dodam.dodam.server.diary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiaryService {

    @Autowired
    DiaryDAO dao;

    public int posting(DiaryDTO dto) { return dao.posting(dto); }
    public int deletepost(DiaryDTO dto) {
        // 삭제하시겠습니까?? 에 해당하는 무언가가 들어가야 할 것 같은데..
    }
    public int updatepost(DiaryDTO dto) { return dao.updatepost(dto); }


}

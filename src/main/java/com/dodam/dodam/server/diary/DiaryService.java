package com.dodam.dodam.server.diary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DiaryService {

    @Autowired
    DiaryDAO dao;

    public int postdiary(DiaryDTO dto) { return dao.postdiary(dto); }
    public int deletediary(DiaryDTO dto) {
        // 삭제하시겠습니까?? 에 해당하는 무언가가 들어가야 할 것 같은데..
        return dao.deletediary(dto);
    }

    public int partialUpdate(DiaryDTO dto) {
        return dao.partialUpdate(dto);
    }
    //public int updatediary(DiaryDTO dto) { return dao.updatediary(dto); }

    public void updateDiaryPartially(Map<String, Object> updates, String diaryid, String userid) {
        DiaryDTO dto = new DiaryDTO();
        dto.setDiaryid(diaryid);
        dto.setUserid(userid);
        DiaryDTO existingDiary = dao.getdiary(dto);
        if (existingDiary == null) {
            throw new IllegalArgumentException("Diary not found");
        }

        if (updates.containsKey("title")) {
            existingDiary.setTitle((String) updates.get("title"));
        }
        if (updates.containsKey("content")) {
            existingDiary.setContent((String) updates.get("content"));
        }
        if (updates.containsKey("photo")) {
            existingDiary.setPhoto((String) updates.get("photo"));
        }

        dao.partialUpdate(existingDiary);
    }

    public DiaryDTO getdiary(DiaryDTO dto) { return dao.getdiary(dto); }

    public List<DiaryDTO> getAlldiary(DiaryDTO dto) { return dao.getAlldiary(dto); }
}
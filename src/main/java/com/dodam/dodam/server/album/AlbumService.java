package com.dodam.dodam.server.album;

import com.dodam.dodam.server.diary.DiaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AlbumService {

    @Autowired
    AlbumDAO dao;

    public int postalbum(AlbumDTO dto) { return dao.postalbum(dto); }
    public int deletealbum(AlbumDTO dto) { return dao.deletealbum(dto); }

    public int partialUpdate(AlbumDTO dto) {
        return dao.partialUpdate(dto);
    }

    public AlbumDTO getalbum(AlbumDTO dto) { return dao.getalbum(dto); }

    public List<AlbumDTO> getAllalbum (AlbumDTO dto) { return dao.getAllalbum(dto); }
}

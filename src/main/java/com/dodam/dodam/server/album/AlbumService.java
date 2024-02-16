package com.dodam.dodam.server.album;

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

    public void updateAlbumPartially(Map<String, Object> updates, String albumid, String userid) {
        AlbumDTO dto = new AlbumDTO();
        dto.setAlbumid(albumid);
        dto.setUserid(userid);
        AlbumDTO existingAlbum = dao.getalbum(dto);
        if (existingAlbum == null) {
            throw new IllegalArgumentException("Diary not found");
        }

        if (updates.containsKey("title")) {
            existingAlbum.setTitle((String) updates.get("title"));
        }
        if (updates.containsKey("photo")) {
            existingAlbum.setPhoto((String) updates.get("photo"));
        }

        dao.partialUpdate(existingAlbum);
    }

    public AlbumDTO getalbum(AlbumDTO dto) { return dao.getalbum(dto); }

    public List<AlbumDTO> getAllalbum (AlbumDTO dto) { return dao.getAllalbum(dto); }
}

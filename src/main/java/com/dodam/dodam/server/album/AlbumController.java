package com.dodam.dodam.server.album;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    AlbumService service;

    // 작성..
    @PostMapping("/post")
    public AlbumDTO writeAlbum(@RequestBody AlbumDTO dto) {
        service.postalbum(dto);
        return dto;
    }

    @GetMapping("/{albumid}/{userid}")
    public AlbumDTO viewAlbum(@PathVariable("albumid") String albumid, @PathVariable("userid") String userid) {
        AlbumDTO dto = new AlbumDTO();
        dto.setAlbumid(albumid);
        dto.setUserid(userid);
        return service.getalbum(dto);
    }

    // 전체 조회
    @GetMapping("/all/{userid}")
    public List<AlbumDTO> viewAllAlbum(@PathVariable("userid") String userid) {
        AlbumDTO dto = new AlbumDTO();
        dto.setUserid(userid);
        return service.getAllalbum(dto);
    }

    // 수정
    @PutMapping("/update/{albumid}/{userid}")
    public AlbumDTO updateAlbum(@RequestBody AlbumDTO dto, @PathVariable("albumid") String albumid, @PathVariable("userid") String userid) {
        dto.setAlbumid(albumid);
        dto.setUserid(userid);
        service.partialUpdate(dto);
        return dto;
    }

    //삭제
    @DeleteMapping("/delete/{albumid}/{userid}")
    public String deleteAlbum(@PathVariable("albumid") String albumid, @PathVariable("userid") String userid) {
        AlbumDTO dto = new AlbumDTO();
        dto.setAlbumid(albumid);
        dto.setUserid(userid);
        int result = service.deletealbum(dto);
        return result == 1 ? "success" : "fail";
    }
}

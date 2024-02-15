package com.dodam.dodam.server.album;

import lombok.Data;

@Data
public class AlbumDTO {

    private String userid;
    private String albumid;
    private String title;
    private String creationdate;
    private String photo;  // 로컬 경로 저장용
}

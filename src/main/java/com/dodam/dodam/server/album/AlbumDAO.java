package com.dodam.dodam.server.album;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AlbumDAO {

    public int postalbum(AlbumDTO dto);
    public int deletealbum(AlbumDTO dto);
    public AlbumDTO getalbum(AlbumDTO dto);
    public List<AlbumDTO> getAllalbum(AlbumDTO dto);
    public int partialUpdate(AlbumDTO dto);


}

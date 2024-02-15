package com.dodam.dodam.server.album;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("album")
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    AlbumService service;



}

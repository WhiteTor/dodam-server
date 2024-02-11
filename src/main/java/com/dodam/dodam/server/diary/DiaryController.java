package com.dodam.dodam.server.diary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class DiaryController {

    @Autowired
    DiaryService service;



}

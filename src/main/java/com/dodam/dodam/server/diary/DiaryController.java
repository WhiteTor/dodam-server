package com.dodam.dodam.server.diary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@SessionAttributes("diary")
public class DiaryController {

    @Autowired
    DiaryService service;

    //작성?
    @PostMapping("/diary")
    public String writeDiary(DiaryDTO dto) {
        service.postdiary(dto);
        return "redirect:/diary";
    }

    @GetMapping("/diary")
    public String viewDiary(Model model, DiaryDTO dto) {
        int diaries = service.getdiary(dto);
        model.addAttribute("diaries", diaries);
        return "diary/selected";
    }

    @GetMapping("/diary/all")
    public String viewAllDiary(Model model, DiaryDTO dto) {
        List diaries = service.getAlldiary(dto);
        model.addAttribute("diaries", diaries);
        return "diary/list";
    }

    //수정
    @GetMapping("/updatediary")
    public String updateDiary(@ModelAttribute DiaryDTO dto) { return "diary/updateform"; }

    @PutMapping("/update")
    public String update(@ModelAttribute DiaryDTO dto, SessionStatus status) {
        service.updatediary(dto);
        status.setComplete();

        return "redirect:/diary";
    }

    //삭제
    @GetMapping("/deletediary")
    public String deleteDiary(String result, Model m) {
        m.addAttribute("result", result);

        return "diary/deleteform";
    }

    @DeleteMapping("/delete")
    public String delete(@ModelAttribute DiaryDTO dto,
                         SessionStatus status,
                         RedirectAttributes redirectAttributes) {
        int i = service.deletediary(dto);

        if (i == 0) {
            redirectAttributes.addFlashAttribute("result", "false");
            return "redirect:/deleteform";
        }
        else {
            redirectAttributes.addFlashAttribute("result", "success");
            status.setComplete();
            return "redirect:/";
        }
    }
}

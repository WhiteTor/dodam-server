package com.dodam.dodam.server.album;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("album")
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    AlbumService service;

    // 작성..
    @PostMapping("/postalbum")
    public String writeAlbum(AlbumDTO dto) {
        service.postalbum(dto);
        return "redirect:/album";
    }

    @GetMapping("/postalbum")
    public String viewAlbum(Model model, AlbumDTO dto) {
        AlbumDTO albums = service.getalbum(dto);
        model.addAttribute("albums", albums);
        return "album/selected";
    }

    // 전체 조회
    @GetMapping("/getalbum/all")
    public String viewAllAlbum(Model model, AlbumDTO dto) {
        List albums = service.getAllalbum(dto);
        model.addAttribute("albums", albums);
        return "album/list";
    }

    // 수정
    @GetMapping("/updatealbum")
    public String updateAlbum(@ModelAttribute AlbumDTO dto) { return "album/updateform"; }

    @PatchMapping("/update")
    public String partialUpdate(@RequestBody Map<String, Object> updates,
                                @RequestParam String albumid,
                                @RequestParam String userid,
                                SessionStatus status) {
        updates.remove("creationdate");
        service.updateAlbumPartially(updates, albumid, userid);
        status.setComplete();

        return "redirect:/diary";
    }

    //삭제
    @GetMapping("/deletealbum")
    public String deletealbum(String result, Model m) {
        m.addAttribute("result", result);

        return "album/deleteform";
    }

    @DeleteMapping("/delete")
    public String delete(@ModelAttribute AlbumDTO dto,
                         SessionStatus status,
                         RedirectAttributes redirectAttributes) {
        int i = service.deletealbum(dto);

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

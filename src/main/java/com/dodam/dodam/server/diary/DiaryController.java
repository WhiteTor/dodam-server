package com.dodam.dodam.server.diary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/*@Controller
@SessionAttributes("diary")
@RequestMapping("/diary")
public class DiaryController {

    @Autowired
    DiaryService service;

    //작성?
    @PostMapping("/postdiary")
    public String writeDiary(DiaryDTO dto) {
        service.postdiary(dto);
        return "redirect:/diary";
    }

    @GetMapping("/postdiary")
    public String viewDiary(Model model, DiaryDTO dto) {
        DiaryDTO diaries = service.getdiary(dto);
        model.addAttribute("diaries", diaries);
        return "diary/selected";
    }

    // 전체 조회
    @GetMapping("/getdiary/all")
    public String viewAllDiary(Model model, DiaryDTO dto) {
        List diaries = service.getAlldiary(dto);
        model.addAttribute("diaries", diaries);
        return "diary/list";
    }

    // 일부 수정
    @GetMapping("/updatediary")
    public String updateDiary(@ModelAttribute DiaryDTO dto) {
        return "diary/updateform";
    }

    @PatchMapping("/update")
    public String partialUpdate(@RequestBody Map<String, Object> updates,
                                @RequestParam String diaryid,
                                @RequestParam String userid,
                                SessionStatus status) {
        updates.remove("creationdate"); // creationdate는 수정 불가능하도록 제거
        service.updateDiaryPartially(updates, diaryid, userid);
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
}*/

@RestController
@RequestMapping("/diary")
public class DiaryController {

    @Autowired
    DiaryService service;

    @PostMapping("/post")
    public DiaryDTO writeDiary(@RequestBody DiaryDTO dto) {
        service.postdiary(dto);
        return dto;  // 새로 작성된 diary 반환
    }

    @GetMapping("/{diaryid}/{userid}")
    public DiaryDTO viewDiary(@PathVariable("diaryid") String diaryid, @PathVariable("userid") String userid) {
        DiaryDTO dto = new DiaryDTO();
        dto.setDiaryid(diaryid);
        dto.setUserid(userid);
        return service.getdiary(dto);
    }

    @GetMapping("/all/{userid}")
    public List<DiaryDTO> viewAllDiary(@PathVariable("userid") String userid) {
        DiaryDTO dto = new DiaryDTO();
        dto.setUserid(userid);
        return service.getAlldiary(dto);
    }

    @PutMapping("/update/{diaryid}/{userid}")
    public DiaryDTO updateDiary(@RequestBody DiaryDTO dto, @PathVariable("diaryid") String diaryid, @PathVariable("userid") String userid) {
        dto.setDiaryid(diaryid);
        dto.setUserid(userid);
        service.partialUpdate(dto);
        return dto;  // 수정된 diary 반환
    }

    @DeleteMapping("/delete/{diaryid}/{userid}")
    public String deleteDiary(@PathVariable("diaryid") String diaryid, @PathVariable("userid") String userid) {
        DiaryDTO dto = new DiaryDTO();
        dto.setDiaryid(diaryid);
        dto.setUserid(userid);
        int result = service.deletediary(dto);
        return result == 1 ? "success" : "fail";  // 삭제 성공 여부 반환
    }
}
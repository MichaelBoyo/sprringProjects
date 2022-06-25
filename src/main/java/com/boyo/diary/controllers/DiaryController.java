package com.boyo.diary.controllers;

import com.boyo.diary.models.Diary;
import com.boyo.diary.models.Entry;
import com.boyo.diary.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/diary")
public class DiaryController {
    @Autowired
    private DiaryService diaryService;

    @PostMapping("/create")
    public String createDiary(@RequestBody Diary diary){
        diaryService.createDiary(diary);
        return "success";
    }
    @GetMapping("/getDiary/{diaryId}")
    public Diary getDiary(@PathVariable String diaryId){
        return diaryService.getDiary(diaryId);
    }

    @DeleteMapping("/delete/{diaryId}")
    public String deleteDiary(@PathVariable String diaryId){
        return diaryService.deleteDiary(diaryId);
    }
    @PatchMapping("/edit/{diaryId}")
    public String editDiaryName(@PathVariable String diaryId, @RequestBody String newDiaryName){
        return diaryService.editDiary(diaryId, newDiaryName);
    }

    @PostMapping("/newEntry/{diaryId}")
    public ResponseEntity<?> addEntry(@PathVariable String diaryId, @RequestBody Entry entry){
        try {
            diaryService.addEntryToDiary(diaryId, entry);
            return new ResponseEntity<>("Entry created successfully", HttpStatus.OK);
        } catch (IllegalArgumentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
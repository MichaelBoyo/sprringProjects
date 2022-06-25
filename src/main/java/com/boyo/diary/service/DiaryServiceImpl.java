package com.boyo.diary.service;

import com.boyo.diary.models.Diary;
import com.boyo.diary.models.Entry;
import com.boyo.diary.repository.DiaryRepository;
import com.boyo.diary.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DiaryServiceImpl implements DiaryService{
    @Autowired
    private DiaryRepository diaryRepository;
    @Autowired
    private EntryRepository entryRepository;

    @Override
    public void addEntryToDiary(String diaryId, Entry newEntry) {
        Optional<Diary> diaryOptional = diaryRepository.findById(diaryId);
        if(diaryOptional.isPresent()){
            Entry savedEntry = entryRepository.save(newEntry);
            var diary = diaryOptional.get();
            diary.getEntries().add(savedEntry);
            diaryRepository.save(diary);
        } else {
            throw new IllegalArgumentException("No diary with that id found");
        }
    }

    @Override
    public void createDiary(Diary diary) {
        diaryRepository.save(diary);
    }

    @Override
    public Diary getDiary(String diaryId) {
        return diaryRepository.findById(diaryId)
                .orElseThrow(()-> new IllegalArgumentException("diary with diary id "+diaryId+" not found"));
    }

    @Override
    public String deleteDiary(String diaryId) {
        Optional<Diary> diaryOptional = diaryRepository.findById(diaryId);
        if(diaryOptional.isPresent()){
            diaryRepository.deleteById(diaryId);
            return "delete successful";
        }else {
            throw  new IllegalArgumentException("diaryId does not exist");
        }
    }

    @Override
    public String editDiary(String diaryId, String newDiaryNAme) {
        Diary diary = diaryRepository.findById(diaryId)
                        .orElseThrow(()-> new IllegalArgumentException("diaryId doesnt exist"));
        diary.setName(newDiaryNAme);
        return "edit successful";
    }
}

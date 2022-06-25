package com.boyo.diary.service;

import com.boyo.diary.models.Diary;
import com.boyo.diary.models.Entry;

public interface DiaryService {
    void addEntryToDiary(String diaryId, Entry newEntry);
    void createDiary(Diary diary);
    Diary getDiary(String diaryId);
    String deleteDiary(String diaryId);

    String editDiary(String diaryId, String newDiaryName);
}

package com.boyo.diary.repository;

import com.boyo.diary.models.Diary;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DiaryRepository extends MongoRepository<Diary, String> {
    Diary findDiaryByName(String name);
    void deleteById(String id);
    List<Diary> findAll();
}

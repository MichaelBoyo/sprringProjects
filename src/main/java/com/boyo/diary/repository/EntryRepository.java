package com.boyo.diary.repository;

import com.boyo.diary.models.Entry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntryRepository extends MongoRepository<Entry, String> {
    Entry getEntryByTitle(String title);
    void deleteEntriesBy(String id);
    List<Entry> findAll();
}

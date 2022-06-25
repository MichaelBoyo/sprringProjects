package com.boyo.diary.service;

import com.boyo.diary.models.Entry;

import java.util.List;

public interface EntryService {
    void addEntry(Entry Entry);
    Entry getEntryById(String id);
    String editEntryTitle(String id, String title);
    String deleteEntry(String id);
    List<Entry> findAllEntries();
}

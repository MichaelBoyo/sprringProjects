package com.boyo.diary.service;

import com.boyo.diary.models.Entry;
import com.boyo.diary.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntryServiceImpl implements EntryService{

    @Autowired
    EntryRepository entryRepository;

    @Override
    public void addEntry(Entry entry) {
        if(entry.getTitle().isEmpty()){
            throw new IllegalArgumentException("");
        }
        entryRepository.save(entry);
    }

    @Override
    public Entry getEntryById(String id) {
        Entry entry = entryRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("No Entry found with that id"));
        return entry;
    }

    @Override
    public String editEntryTitle(String id, String title) {
        Entry entry = entryRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("No Entry found with that id"));

        if(entry.getTitle().equals(title)){
            throw new IllegalArgumentException("same as old title");
        }
        entry.setTitle(title);
        return "updated successfully";
    }

    @Override
    public String deleteEntry(String id) {
        entryRepository.deleteEntriesBy(id);
        return "deleted Successfully";
    }

    @Override
    public List<Entry> findAllEntries() {
        return entryRepository.findAll();
    }


}

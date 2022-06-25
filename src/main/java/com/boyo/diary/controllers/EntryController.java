package com.boyo.diary.controllers;

import com.boyo.diary.models.Entry;
import com.boyo.diary.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/entry")
public class EntryController {
    @Autowired
    private EntryService entryService;

    @PostMapping("/create")
    public String createEntry(@RequestBody Entry entry) {
        entryService.addEntry(entry);
        return "Success";
    }

    @GetMapping("/get/{entryId}")
    public ResponseEntity<?> getEntry(@PathVariable String entryId) {
        var entry = entryService.getEntryById(entryId);
        return new ResponseEntity<>(entry, HttpStatus.OK);
    }

    @PatchMapping("/edit/{entryId}/{newTitle}")
    public String editEntryTitle(@PathVariable String entryId, @PathVariable String newTitle) {
        return entryService.editEntryTitle(entryId, newTitle);
    }

    @DeleteMapping("/delete/{entryId}")
    public String deleteEntry(@PathVariable String entryId){
        return  entryService.deleteEntry(entryId);
    }
    @GetMapping("/getAll")
    public List<Entry> getAllEntries(){
        return  entryService.findAllEntries();
    }
}
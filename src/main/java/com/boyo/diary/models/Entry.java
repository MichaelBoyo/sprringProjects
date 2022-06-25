package com.boyo.diary.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Entry {
    @Id
    private String id;
    private String title;
    private String body;
}

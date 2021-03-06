package com.boyo.diary.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Data
@Document
public class Diary {
    @Id
    private String id;
    private String name;

    @DBRef
    private List<Entry> entries = new ArrayList<>();
}

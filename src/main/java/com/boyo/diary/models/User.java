package com.boyo.diary.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document
public class User {
    @Id
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String PhoneNumber;
    @DBRef
    private List<Diary> diaries = new ArrayList<>();
}

package com.boyo.diary.service;

import com.boyo.diary.models.Diary;
import com.boyo.diary.models.User;

import java.util.List;

public interface UserService {
    String addUser(User user);
    User getUserById(String id);
    String deleteUser(String id);
    List<User> findAllUsers();

    String addDiary(String id, Diary diary);

    String editFirstName(String id, String newFirstName);
}

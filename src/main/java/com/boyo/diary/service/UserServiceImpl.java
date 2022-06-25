package com.boyo.diary.service;

import com.boyo.diary.models.Diary;
import com.boyo.diary.models.User;
import com.boyo.diary.repository.DiaryRepository;
import com.boyo.diary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    DiaryRepository diaryRepository;

    @Autowired
    UserRepository userRepository;


    @Override
    public String addUser(User user) {
        userRepository.save(user);
        return "added";
    }

    @Override
    public User getUserById(String id) {
        return userRepository.findById(id).get();
    }

    @Override
    public String deleteUser(String id) {
        userRepository.deleteById(id);
        return "deletes";
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public String addDiary(String id, Diary diary) {
        userRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("User not found"))
                .getDiaries().add(diary);
        return "added";
    }

    @Override
    public String editFirstName(String id, String newFirstName) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("User not found"));
        user.setFirstName(newFirstName);
        userRepository.save(user);
        return "edited";
    }
}

package com.boyo.diary.controllers;

import com.boyo.diary.models.Diary;
import com.boyo.diary.models.User;
import com.boyo.diary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public String addUser(@RequestBody User user){
        return userService.addUser(user);
    }
    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable String id){
       return userService.getUserById(id);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteUSer(@PathVariable String id){
        return userService.deleteUser(id);
    }
    @PostMapping("/addDiary/{id}")
    public String addDiary(@PathVariable String id, @RequestBody Diary diary){
        return userService.addDiary(id, diary);
    }
    @PatchMapping("/editUser/{id}/{newFirstName}")
    public String editFirstNAme(@PathVariable String id, @PathVariable String newFirstName){
        return userService.editFirstName(id,newFirstName);
    }
}

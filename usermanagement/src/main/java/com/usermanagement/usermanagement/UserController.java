package com.usermanagement.usermanagement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    // List ที่เรา Edit ไม่ได้
    List<User> users = new ArrayList<>(
            List.of(
                    new User(1, "John", 22, false),
                    new User(2, "Jane", 21, true),
                    new User(3, "Mary", 25, false)
                    )
            );
    @GetMapping("api/users")
    public List<User> getUsers() {
        return users;
    }

}

class User {
    private int id;
    private String name;
    private int age;
    private Boolean active;

    // Constructor
    public User(int id, String name, int age, Boolean active) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Boolean getActive() {
        return active;
    }

    public int getId() {
        return id;
    }
}

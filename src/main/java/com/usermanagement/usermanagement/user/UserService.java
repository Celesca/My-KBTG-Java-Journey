package com.usermanagement.usermanagement.user;

import com.usermanagement.usermanagement.mail.GoogleMailService;
import com.usermanagement.usermanagement.mail.MailService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    List<User> users = new ArrayList<>(
            List.of(
                    new User(1, "John", 22, false),
                    new User(2, "Jane", 21, true),
                    new User(3, "Mary", 25, false)
            )
    );

    private MailService mailService;
    public UserService(@Qualifier("outlookMail") MailService mailService) {
        this.mailService = mailService;
    }

    public List<User> getUsers(Optional<Boolean> active) {
        if (active.isPresent()) {
            return users.stream().filter(u -> u.getActive() == active.get()).toList();
        }
        return users;
    }

    public User createUser(UserController.UserRequest request) {
        Optional<Integer> maxId = users.stream().map(User::getId).max(Integer::compareTo);
        int nextId = maxId.orElse(0) + 1;
        User user = new User(nextId, request.name() , request.age() , true);
        users.add(user);

        // TODO: send the mail
        mailService.sendMail("dev@gmail.com" , "New user created");
        return user;
    }

    public void editUser(int id, UserController.UserRequest request)  {
        Optional<User> user = users.stream().filter(u -> u.getId() == id).findFirst();
        if (user.isPresent()){
            User u = user.get();
            u.setName(request.name());
        }
    }

    public void deleteUser(int id) {
        users.removeIf(u -> u.getId() == id);
    }

}

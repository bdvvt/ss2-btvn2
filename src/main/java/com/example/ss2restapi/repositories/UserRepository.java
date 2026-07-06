package com.example.ss2restapi.repositories;

import com.example.ss2restapi.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    public final User u1 = new User(1, "An", "ADMIN");
    public final User u2 = new User(2, "Bình", "USER");
    public final User u3 = new User(3, "Chi", "USER");
    List<User> users = new ArrayList<>(
            List.of(u1, u2, u3)
    );

    public List<User> findAll(String search) {
        return users.stream()
                .filter( user -> user.getName().toLowerCase().contains(search.toLowerCase()))
                .toList();
    }

    public User findById(Integer id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }



}

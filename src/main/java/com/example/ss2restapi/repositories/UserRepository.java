package com.example.ss2restapi.repositories;

import com.example.ss2restapi.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    public final User u1 = new User(1L, "An", "ADMIN");
    public final User u2 = new User(2L, "Bình", "USER");
    public final User u3 = new User(3L, "Chi", "USER");
    List<User> users = new ArrayList<>(
            List.of(u1, u2, u3)
    );

    public List<User> findAll() {
        return users;
    }
}

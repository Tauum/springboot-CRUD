package com.example.springbootcrud;

import com.example.springbootcrud.User.Model.Role;
import com.example.springbootcrud.User.Model.User;
import com.example.springbootcrud.User.Repository.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringbootCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCrudApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserRepo userRepo){ // MOCK DATA
        return args -> {
            if (userRepo.findAll().size() < 3){ // BELOW ONLY RUNS IF MISSING THESE SPECIFIC USERS
                List<User> usersToAdd = new ArrayList<>();
                if (userRepo.findByEmail("admin@mail.com") == null ){
                    usersToAdd.add(
                        new User("Admin","admin@mail.com",1998, Role.ADMIN, true)
                    );
                }
                if (userRepo.findByEmail("staff@mail.com") == null ){
                    usersToAdd.add(
                            new User("User","staff@mail.com",1997, Role.STAFF, true)
                    );
                }
                if (userRepo.findByEmail("user@mail.com") == null ){
                    usersToAdd.add(
                            new User("User","user@mail.com",1996, Role.USER, true)
                    );
                }
                if (userRepo.findByEmail("undefined@mail.com") == null ){
                    usersToAdd.add(
                            new User("Undefined","undefined@mail.com",1995, Role.UNDEFINED, true)
                    );
                }
                userRepo.saveAllAndFlush(usersToAdd);
            }
        };
    }
}

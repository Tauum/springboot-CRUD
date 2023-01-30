package com.example.springbootcrud.User.Service;

import com.example.springbootcrud.Exception.EntityNotFoundException;
import com.example.springbootcrud.User.Model.Role;
import com.example.springbootcrud.User.Model.User;
import com.example.springbootcrud.User.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User addUser(User user) {
        if (findUserByEmail(user.getEmail()) == null){
            if(user.getRole() == null) { user.setRole(Role.UNDEFINED);}
            else{user.setRole(Role.valueOf(user.getRole().toString().toUpperCase()));}
            return userRepo.save(user);
        }
        return null;
    }

    public List<User> findAll(){ return userRepo.findAll(); }

    public User updateUser(User user){
        // this should have field checking
        // to make sure that all fields passed are valid
        return userRepo.save(user);
    }

    //query method (auto generates method in spring back-backend)
    @Transactional
    public void deleteUser(Long id) {
        if (findUserById(id) == null){
            userRepo.deleteUserById(id);
        }
    }

    public User findUserById(Long id)
    {
        return userRepo.findUserById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found with id: " + id)) ;
    }

    public User findUserByEmail(String email) {
        return userRepo.findUserByEmail(email);
    }
}

package com.springdatajpa.springdatajpa.UserService;

import com.springdatajpa.springdatajpa.pojo.User;
import com.springdatajpa.springdatajpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService{

    private UserRepository userRepository;
    @Autowired
    private UserServiceImp(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public List<User> getAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public void createUser(User user) {
        // call the entity manager, the persistence() method, can not be null
        userRepository.save(user);
    }
}

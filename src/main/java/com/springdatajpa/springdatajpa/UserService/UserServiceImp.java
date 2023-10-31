package com.springdatajpa.springdatajpa.UserService;

import com.springdatajpa.springdatajpa.pojo.Account;
import com.springdatajpa.springdatajpa.pojo.User;
import com.springdatajpa.springdatajpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository){
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

    @Override
    public User getUser(int id) {
        Optional<User> result = userRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }


}

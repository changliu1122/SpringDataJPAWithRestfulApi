package com.springdatajpa.springdatajpa;

import com.springdatajpa.springdatajpa.UserService.UserService;
import com.springdatajpa.springdatajpa.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    @Autowired
    private UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id){
       return userService.getUser(id);
    }


    /**
     * we can create a user with account or without,
     * with one-to-one table mapping, we do not have to separately create an entry of account for this user
     * {
     *     "name":"mike has no account",
     *     "account":{
     *         "accountNumber":"002",
     *         "accountPassword":"321"
     *     }
     * }
     * @param user in user class, there is a property named account
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void create(@RequestBody User user ){
        userService.createUser(user);
    }


    /**
     * if this user already exist, and we want to update its account,
     * we can again use save() method, but this time user object must contain user_id
     * than save() method can be an update method
     * if it wants to change its already exist account
     * the object in request body must contain account id
     * {
     *     "id":2,
     *     "name":"mike has no account",
     *     "account":{
     *         "accountId":3,
     *         "accountNumber":"404",
     *         "accountPassword":"321"
     *     }
     * }
     * @param user  user object with user_id
     */
    @PutMapping
    public void updateUser(@RequestBody User user){
        userService.updateUser(user);
    }
}

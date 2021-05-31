package com.appsdeveloperblog.app.ws.ui.controller;

import com.appsdeveloperblog.app.ws.exceptions.UserServiceException;
import com.appsdeveloperblog.app.ws.ui.model.UserRest;
import com.appsdeveloperblog.app.ws.ui.model.request.UpdatesUserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.userservice.UserService;
import com.appsdeveloperblog.app.ws.userservice.impl.UserServiceImpl;
import com.upchain.logging.*;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("users") // http://localhost:8080/users
public class UserController {

    Map<String, UserRest> users = new HashMap<>();
    LoggerFactory loggerFactory;
    Logger logger = loggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @GetMapping
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "limit", defaultValue = "50") int limit,
                           @RequestParam(value = "sort", required = false) String sort){
        logger.info("someone is getting user");
        return "get users was called with page: " + page + " and limit: " + limit + " and sort: " + sort;
    }

    @GetMapping(path="/{userId}")
    public ResponseEntity<UserRest> getUser(@PathVariable String userId){
        if(true) {
            throw new UserServiceException("A user service exception is thrown");
        }

        if(users.containsKey(userId)){
            return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(consumes = {
            MediaType.APPLICATION_JSON_VALUE
    }, produces = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<UserRest> createUser(@RequestBody UserDetailsRequestModel userDetails){
        UserRest returnValue = new UserServiceImpl().createUser(userDetails);
        return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
    }

    @PutMapping(
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE
            },
            path = "/{userId}"
    )
    public UserRest updateUser(@PathVariable String userId, @RequestBody UpdatesUserDetailsRequestModel userDetails){

        UserRest storedUserDetails = users.get(userId);
        storedUserDetails.setFirstName(userDetails.getFirstName());
        storedUserDetails.setLastName(userDetails.getLastName());
        users.put(userId, storedUserDetails);
        return storedUserDetails;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id){
        users.remove(id);
        return ResponseEntity.noContent().build();
    }
}

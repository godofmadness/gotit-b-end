package com.ilegal.team.gotit.user;

import org.springframework.stereotype.Service;

/**
 * Created by mm on 6/4/18.
 */
@Service
public interface UserService {

    void create(UserTO user);

    UserTO createUserTOFromCredentials(UserCredentials userCredentials);

    UserTO findByUsername(String username);

    boolean isValidUser(UserCredentials userCredentials, UserTO user);

    void updateCategories(String userId, String categories);

    UserTO findOne(String userId);
}
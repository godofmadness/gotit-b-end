package com.ilegal.team.gotit.auth;

import com.ilegal.team.gotit.user.UserCredentials;
import org.springframework.stereotype.Service;

/**
 * Created by mm on 6/4/18.
 */
@Service
public class AuthValidationService {

    public boolean validateCredentials(UserCredentials userCredentials) {
        System.out.println(userCredentials.getUsername().matches("^[a-zA-Z0-9]+$"));
        System.out.println(userCredentials.getUsername().length() < 16);
        if (userCredentials.getUsername().matches("^[a-zA-Z0-9]+$") && userCredentials.getUsername().length() < 16) {
            return true;
        }
        return false;
    }
}

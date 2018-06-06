package com.ilegal.team.gotit.auth;

import com.ilegal.team.gotit.atricle.ArticleController;
import com.ilegal.team.gotit.auth.session.SessionService;
import com.ilegal.team.gotit.auth.session.SessionTO;
import com.ilegal.team.gotit.user.UserCredentials;
import com.ilegal.team.gotit.user.UserService;
import com.ilegal.team.gotit.user.UserTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Externalizable;

/**
 * Created by mm on 6/4/18.
 */
@RestController
@CrossOrigin(origins = "*")
public class AuthenticationController {

    private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private AuthValidationService authValidationService;

    @Autowired
    private UserService userService;

    @Autowired
    SessionService sessionService;


    @RequestMapping(method = RequestMethod.POST, value = "/gotit/signup")
    private ResponseEntity<String> signup(@RequestBody UserCredentials userCredentials) {

        boolean valid = authValidationService.validateCredentials(userCredentials);
        if (!valid) {
            return new ResponseEntity<String>("", HttpStatus.BAD_REQUEST);
        }

        UserTO u = userService.findByUsername(userCredentials.getUsername());

        if (u != null) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }


        // create user
        UserTO user = userService.createUserTOFromCredentials(userCredentials);
        userService.create(user);

        // create session
        SessionTO session = sessionService.createSessionTOFromUserId(user.getId());
        sessionService.create(session);
        // return token
        return new ResponseEntity<String>(session.getToken(), HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/gotit/signin")
    private ResponseEntity<String> signin(@RequestBody UserCredentials userCredentials) {

        boolean valid = authValidationService.validateCredentials(userCredentials);

        if (!valid) {
            return new ResponseEntity<String>("", HttpStatus.BAD_REQUEST);
        }

        UserTO user = userService.findByUsername(userCredentials.getUsername());
        logger.info("finded user" + user.getUsername());

        if (user == null) {
            return new ResponseEntity<String>("", HttpStatus.NOT_FOUND);
        }

        // check password etc
        boolean accessGranted = userService.isValidUser(userCredentials, user);
        logger.info("is password valid " + accessGranted);

        if (!accessGranted) {
            return new ResponseEntity<String>("", HttpStatus.FORBIDDEN);
        }

        // create session
        SessionTO session = sessionService.createSessionTOFromUserId(user.getId());
        sessionService.create(session);

        logger.info("session created" + session);
        return new ResponseEntity<>(session.getToken(), HttpStatus.OK);
    }


}

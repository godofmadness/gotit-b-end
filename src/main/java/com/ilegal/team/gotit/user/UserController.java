package com.ilegal.team.gotit.user;

import com.ilegal.team.gotit.atricle.ArticleController;
import com.ilegal.team.gotit.auth.session.SessionService;
import com.ilegal.team.gotit.auth.session.SessionTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by mm on 6/4/18.
 */
@RestController
@CrossOrigin(origins = "*")
public class UserController {



    @Autowired
    SessionService sessionService;

    @Autowired
    UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @RequestMapping(method = RequestMethod.GET, value = "/gotit/user")
    private ResponseEntity<UserIdentity> findAuthenticatedUser(@RequestHeader("Authorization") String authToken) {

        SessionTO session = sessionService.findByToken(authToken);
        logger.info("session " + session);
        UserTO user = userService.findOne(session.getUserId());
        logger.info("user " + user);


        return new ResponseEntity<>(new UserIdentity(user.getId(), user.getUsername(), user.getInterestedCategories(), user.getRoles(), user.getCreated(), user.getModified(), user.getCreatedBy(), user.getModifiedBy(), user.getVersion(), user.getDeleted()), HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/gotit/user/{userId}")
    private ResponseEntity<UserIdentity> findByUserId(@PathVariable("userId") String userId) {

        UserTO user = userService.findOne(userId);

        return new ResponseEntity<>(new UserIdentity(user.getId(), user.getUsername(), user.getInterestedCategories(), user.getRoles(), user.getCreated(), user.getModified(), user.getCreatedBy(), user.getModifiedBy(), user.getVersion(), user.getDeleted()), HttpStatus.OK);
    }




    @RequestMapping(method = RequestMethod.POST, value = "/gotit/user/categories")
    private ResponseEntity<String> updateUserCategories(@RequestHeader("Authorization") String authToken, @RequestParam("categories") String categories) {


        logger.info("token " + authToken);
        logger.info("update categories " +categories);
        // find auth by token in cookie
        SessionTO session = sessionService.findByToken(authToken);
        logger.info("finded session " + session);
        if (session == null) {
            return new ResponseEntity<String>("", HttpStatus.UNAUTHORIZED);
        }

        userService.updateCategories(session.getUserId(), categories);

        return new ResponseEntity<String>("", HttpStatus.OK);


        // update user by userId;
    }
}

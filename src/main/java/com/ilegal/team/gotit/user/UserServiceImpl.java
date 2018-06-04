package com.ilegal.team.gotit.user;

import com.ilegal.team.gotit.role.GotItRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.UUID;

/**
 * Created by mm on 6/4/18.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void create(UserTO user) {
        userDao.save(user);
    }

    @Override
    public UserTO createUserTOFromCredentials(UserCredentials userCredentials) {


        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(userCredentials.getPassword());

        System.out.println("hashed password" + hashedPassword);
        String userId = UUID.randomUUID().toString();

        return new UserTO(userId, userCredentials.getUsername(), hashedPassword, "", GotItRole.USER, new Date().getTime(), new Date().getTime(), userId, userId, 0, Long.valueOf(0));
    }

    @Override
    public UserTO findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public boolean isValidUser(UserCredentials userCredentials, UserTO user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(userCredentials.getPassword(), user.getPassword());
    }


    @Override
    @Transactional
    public void updateCategories(String userId, String categories) {
        userDao.updateUserCategories(userId, categories);
    }
}

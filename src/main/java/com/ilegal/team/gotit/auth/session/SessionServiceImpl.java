package com.ilegal.team.gotit.auth.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * Created by mm on 6/4/18.
 */

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionDao sessionDao;

    @Override
    public void create(SessionTO session) {
        sessionDao.save(session);
    }

    @Override
    public SessionTO createSessionTOFromUserId(String userId) {

        return new SessionTO(UUID.randomUUID().toString(), userId, UUID.randomUUID().toString(), new Date().getTime(), new Date().getTime(), userId, userId, 0, Long.valueOf(0));
    }
}

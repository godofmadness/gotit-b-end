package com.ilegal.team.gotit.auth.session;

/**
 * Created by mm on 6/4/18.
 */
public interface SessionService {

    void create(SessionTO session);

    SessionTO createSessionTOFromUserId(String userId);
}

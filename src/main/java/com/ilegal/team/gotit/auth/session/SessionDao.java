package com.ilegal.team.gotit.auth.session;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by mm on 6/4/18.
 */

public interface SessionDao extends JpaRepository<SessionTO, String> {


    @Override
    <S extends SessionTO> S save(S s);
}

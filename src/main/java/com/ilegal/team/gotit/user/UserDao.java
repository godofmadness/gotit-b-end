package com.ilegal.team.gotit.user;

import com.ilegal.team.gotit.atricle.ArticleTO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by mm on 6/4/18.
 */
public interface UserDao extends JpaRepository<UserTO, String> {

    @Override
    <S extends UserTO> S save(S s);

    UserTO findByUsername(String username);
}

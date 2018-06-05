package com.ilegal.team.gotit.user;

import com.ilegal.team.gotit.atricle.ArticleTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * Created by mm on 6/4/18.
 */
public interface UserDao extends JpaRepository<UserTO, String> {

    @Override
    <S extends UserTO> S save(S s);

    UserTO findByUsername(String username);

    @Modifying
    @Query(value = "UPDATE USER SET interestedCategories = ?2 WHERE id = ?1", nativeQuery = true)
    void updateUserCategories(String id, String categories);


    @Override
    Optional<UserTO> findById(String s);
}


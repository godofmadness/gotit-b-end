package com.ilegal.team.gotit.topic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by mm on 5/30/18.
 */

// use only one table requests via ORM (don't use relation requests with ORM, use raw queries via @Query)

public interface TopicDao extends JpaRepository<TopicTO, String> {

    @Override
    Optional<TopicTO> findById(String id);



    // sample to use custom query
//    @Query(value = "SELECT * FROM TOPIC WHERE title = ?1", nativeQuery = true)
//    TopicTO findByEmailTitleStream(String title);
}

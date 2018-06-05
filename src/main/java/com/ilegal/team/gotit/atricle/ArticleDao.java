package com.ilegal.team.gotit.atricle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * Created by mm on 5/30/18.
 */

// use only one table requests via ORM (don't use relation requests with ORM, use raw queries via @Query)

public interface ArticleDao extends JpaRepository<ArticleTO, String> {

    @Override
    Optional<ArticleTO> findById(String id);

//    @Query(value = "SELECT * FROM ARTICLE WHERE categories LIKE CONCAT('%',:category,'%')", nativeQuery = true)
//    List<ArticleTO> findByCategory(@Param("category") String category);
    List<ArticleTO> findByCategoriesContaining(String category);

    @Override
    <S extends ArticleTO> S save(S s);

    List<ArticleTO> findByUserId(String userId);
}

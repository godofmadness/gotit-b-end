package com.ilegal.team.gotit.articlecategory;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by mm on 6/3/18.
 */
public interface ArticleCategoryDao extends JpaRepository<ArticleCategoryTO, String>{

    @Override
    List<ArticleCategoryTO> findAll();
}

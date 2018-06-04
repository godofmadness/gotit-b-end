package com.ilegal.team.gotit.articlecategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mm on 6/3/18.
 */
@Service
public class ArticleCategoryServiceImpl implements ArticleCategoryService {

    @Autowired
    private ArticleCategoryDao articleCategoryDao;

    @Override
    public List<ArticleCategoryTO> findAll() {
        return articleCategoryDao.findAll();
    }


}

package com.ilegal.team.gotit.articlecategory;

import com.ilegal.team.gotit.atricle.TopicController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by mm on 6/3/18.
 */

@RestController
@CrossOrigin(origins = "*")
public class ArticleCategoryController {

    private static final Logger logger = LoggerFactory.getLogger(TopicController.class);

    @Autowired
    private ArticleCategoryService articleCategoryService;

    // get all avaliable categories in application
    @RequestMapping(method = RequestMethod.GET, value = "/gotit/category")
    public ResponseEntity<List<ArticleCategoryTO>> findAll() {

        List<ArticleCategoryTO> articleCategories = articleCategoryService.findAll();
        logger.info("All articles categories " + articleCategories);

        return new ResponseEntity<>(articleCategories, HttpStatus.OK);

    }
}

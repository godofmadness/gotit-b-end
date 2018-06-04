package com.ilegal.team.gotit.atricle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mm on 5/30/18.
 */

@RestController
public class TopicController {


    private static final Logger logger = LoggerFactory.getLogger(TopicController.class);

    @Autowired
    private TopicService topicService;


    @RequestMapping(method = RequestMethod.GET, value = "/gotit/atricle/{userId}/{id}")
    private ResponseEntity<ArticleTO> findOne(@PathVariable String id) {

        ArticleTO topic = topicService.findOneById(id);
        logger.info("finded atricle " + topic);

        return new ResponseEntity<>(topic, HttpStatus.OK);
    }



    @RequestMapping(method = RequestMethod.GET, value = "/gotit/article")
    private ResponseEntity<List<ArticleTO>> findByCategory(@RequestParam("c") String category) {


        List<ArticleTO> articles = topicService.findByCategory(category);
        logger.info("finded articles by category " + category + " " + articles);

        return new ResponseEntity<>(articles, HttpStatus.OK);
    }

//    @RequestMapping(method = RequestMethod.GET, value = "/gotit/atricle/{userId}")
//    private ResponseEntity<List<ArticleTO>> findAll(PathVariable String userId) {
//        List<ArticleTO> topics = topicService.findAllByUserId(userId);
//
//        return new ResponseEntity<List<ArticleTO>>(topics, HttpStatus.OK);
//    }

}

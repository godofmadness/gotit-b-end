package com.ilegal.team.gotit.atricle;

import com.ilegal.team.gotit.auth.session.SessionService;
import com.ilegal.team.gotit.auth.session.SessionTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by mm on 5/30/18.
 */

@RestController
@CrossOrigin(origins = "*")
public class ArticleController {


    private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private TopicService topicService;

    @Autowired
    private SessionService sessionService;


    @RequestMapping(method = RequestMethod.GET, value = "/gotit/article/{id}")
    private ResponseEntity<ArticleTO> findOne(@PathVariable String id) {

        ArticleTO topic = topicService.findOneById(id);
        logger.info("finded atricle " + topic);

        return new ResponseEntity<>(topic, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/gotit/article/user/{userId}")
    private ResponseEntity<List<ArticleTO>> findByUserId(@PathVariable String userId) {

        List<ArticleTO> topic = topicService.findByUserId(userId);
        logger.info("finded atricle by userId " + topic);

        return new ResponseEntity<>(topic, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/gotit/article")
    private ResponseEntity<Void> create(@RequestBody ArticleTO article, @RequestHeader("Authorization") String token) {

        SessionTO session = sessionService.findByToken(token);
        if (session == null) {
            return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
        }

        topicService.create(article);
        return new ResponseEntity<>(HttpStatus.OK);
    }


//    @RequestMapping(method = RequestMethod.POST, value = "/gotit/article/{articleId}/content")
//    private ResponseEntity<Void> create(@PathVariable("articleId") String articleId, @RequestBody ArticleContent articleContent, @RequestHeader("Authorization") String token) {
//
//        SessionTO session = sessionService.findByToken(token);
//        if (session == null) {
//            return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
//        }
//
//        logger.info("Article content " + articleContent);
//
//        topicService.create(article);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }




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

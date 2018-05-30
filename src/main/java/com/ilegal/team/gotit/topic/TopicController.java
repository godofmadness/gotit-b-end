package com.ilegal.team.gotit.topic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by mm on 5/30/18.
 */

@RestController
public class TopicController {


    private static final Logger logger = LoggerFactory.getLogger(TopicController.class);

    @Autowired
    private TopicService topicService;


    @RequestMapping(method = RequestMethod.GET, value = "/gotit/topic/{userId}/{id}")
    private ResponseEntity<TopicTO> findOne(@PathVariable String id) {

        TopicTO topic = topicService.findOneById(id);
        logger.info("finded topic " + topic);

        return new ResponseEntity<>(topic, HttpStatus.OK);
    }
}

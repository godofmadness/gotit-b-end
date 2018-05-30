package com.ilegal.team.gotit.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

/**
 * Created by mm on 5/30/18.
 */
@Service
public class TopicServiceImpl implements TopicService {


    @Autowired
    private TopicDao topicDao;

    @Override
    public TopicTO findOneById(String id) {
        return topicDao.findById(id).orElse(null);
    }

//    public TopicTO findByTitle(String title) {
//        return topicDao.findByEmailTitleStream(title);
//    }
}

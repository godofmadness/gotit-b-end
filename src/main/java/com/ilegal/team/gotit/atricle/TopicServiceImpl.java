package com.ilegal.team.gotit.atricle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mm on 5/30/18.
 */
@Service
public class TopicServiceImpl implements TopicService {


    @Autowired
    private TopicDao topicDao;

    @Override
    public ArticleTO findOneById(String id) {
        return topicDao.findById(id).orElse(null);
    }

//    public ArticleTO findByTitle(String title) {
//        return topicDao.findByEmailTitleStream(title);
//    }


    @Override
    public List<ArticleTO> findByCategory(String category) {
        return topicDao.findByCategoriesContaining(category);
    }

    @Override
    public List<ArticleTO> findByUserId(String userid) {
        return topicDao.findByUserId(userid);
    }
}

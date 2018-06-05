package com.ilegal.team.gotit.atricle;

import java.util.List;

/**
 * Created by mm on 5/30/18.
 */
public interface TopicService {

    ArticleTO findOneById(String id);

    List<ArticleTO> findByCategory(String category);

    List<ArticleTO> findByUserId(String userid);
//    ArticleTO findByTitle(String title);
}

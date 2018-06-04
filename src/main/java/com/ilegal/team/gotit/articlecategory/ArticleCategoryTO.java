package com.ilegal.team.gotit.articlecategory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by mm on 6/3/18.
 */

@Entity
@Table(name = "ARTICLE_CATEGORY")
public class ArticleCategoryTO {


    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    public ArticleCategoryTO() {
    }

    public ArticleCategoryTO(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ArticleCategoryTO{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

package com.ilegal.team.gotit.atricle;

/**
 * Created by mm on 6/5/18.
 */
public class ArticleContent {
    private String content;

    public ArticleContent(String content) {
        this.content = content;
    }

    public ArticleContent() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ArticleContent{");
        sb.append("content='").append(content).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

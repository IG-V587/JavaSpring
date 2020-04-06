package com.test.dao;

import org.springframework.stereotype.Repository;

@Repository
public class BookDao {
    private String tag="1";

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "BookDao{" +
                "tag='" + tag + '\'' +
                '}';
    }
}

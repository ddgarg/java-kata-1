package org.echocat.kata.java.part1.models;

/**
 * Created by dindayal on 08/09/17.
 */
public class Magazine extends BookBase {

    String publishedAt;

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }
}

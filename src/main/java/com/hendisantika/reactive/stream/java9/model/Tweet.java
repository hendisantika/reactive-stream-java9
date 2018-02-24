package com.hendisantika.reactive.stream.java9.model;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * Project : reactive-stream-java9
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 24/02/18
 * Time: 21.38
 * To change this template use File | Settings | File Templates.
 */
public class Tweet {
    public static final String BLUE = "\u001B[34m";
    //Reset code
    public static final String RESET = "\u001B[0m";
    String user, tweet;
    Date tweetDate;

    public Tweet(String user, String tweet, Date tweetDate) {
        this.user = user;
        this.tweet = tweet;
        this.tweetDate = tweetDate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    public Date getTweetDate() {
        return tweetDate;
    }

    public void setTweetDate(Date tweetDate) {
        this.tweetDate = tweetDate;
    }

    @Override
    public String toString() {
        return "@" + user + " tweeted: '" + BLUE + tweet + RESET + "' [" + tweetDate + "]";
    }
}

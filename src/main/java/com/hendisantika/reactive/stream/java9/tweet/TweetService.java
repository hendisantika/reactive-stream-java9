package com.hendisantika.reactive.stream.java9.tweet;

import javax.annotation.PostConstruct;
import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.interceptor.Interceptor;

/**
 * Created by IntelliJ IDEA.
 * Project : reactive-stream-java9
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 25/02/18
 * Time: 06.40
 * To change this template use File | Settings | File Templates.
 */

@ApplicationScoped
public class TweetService {
    @Inject
    private TweetPublisher tweetPublisher;

    @Inject
    private TweetSubscriber subscriber;

    @PostConstruct
    public void subscribeToTweets() {
        tweetPublisher.subscribe(subscriber);
    }

    public void init(@Observes @Priority(Interceptor.Priority.APPLICATION - 100)
                     @Initialized(ApplicationScoped.class) Object init) {
        tweetPublisher.getTweets();
    }

}
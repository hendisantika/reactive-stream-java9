package com.hendisantika.reactive.stream.java9.tweet;

import com.hendisantika.reactive.stream.java9.model.Tweet;
import twitter4j.Status;

import javax.inject.Inject;
import java.util.UUID;
import java.util.concurrent.Flow;
import java.util.logging.Level;
import java.util.logging.Logger;

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

public class TweetSubscriber implements Flow.Subscriber<Status> {

    private static final int SUB_REQ = 5;
    private static final int SLEEP = 1000;
    private final String id = UUID.randomUUID().toString();
    private Flow.Subscription subscription;

    @Inject
    private Logger logger;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        logger.info("subscriber: " + id + " ==> Subscribed");
        this.subscription = subscription;
        subscription.request(SUB_REQ);
    }

    @Override
    public void onNext(Status status) {
        try {
            Thread.sleep(SLEEP);
        } catch (InterruptedException e) {
            logger.log(Level.SEVERE, "An error has occured: {}", e);
        }
        Tweet t = new Tweet(status.getUser().getScreenName(), status.getText(), status.getCreatedAt());
        logger.info(t.toString());
        subscription.request(SUB_REQ);
    }

    @Override
    public void onError(Throwable throwable) {
        logger.log(Level.SEVERE, "An error occured", throwable);

    }

    @Override
    public void onComplete() {
        logger.info("Done!");

    }
}
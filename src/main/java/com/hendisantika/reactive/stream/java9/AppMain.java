package com.hendisantika.reactive.stream.java9;

import com.hendisantika.reactive.stream.java9.tweet.TweetService;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

/**
 * Created by IntelliJ IDEA.
 * Project : reactive-stream-java9
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 24/02/18
 * Time: 21.37
 * To change this template use File | Settings | File Templates.
 */
public class AppMain {
    public static void main(String[] args) {
        SeContainerInitializer initializer = SeContainerInitializer.newInstance();
        /** disable discovery and register classes manually */
        try (SeContainer container = initializer.initialize()) {
            container.select(TweetService.class);
        }

    }
}

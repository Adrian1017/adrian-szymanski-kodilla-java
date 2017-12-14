package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publisher.TwitterPublisher;
import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {

    @Test
    public void testDefaultSharingStrategies(){
        //given
        User skipper = new Millenials("Skipper");
        User kowalski = new YGeneration("Kowalski");
        User rico = new ZGeneration("Rico");
        //when
        String skipperPublisher = skipper.sharePost();
        System.out.println(skipperPublisher);
        String kowalskiPublisher = kowalski.sharePost();
        System.out.println(kowalskiPublisher);
        String ricoPublisher = rico.sharePost();
        System.out.println(ricoPublisher);
        //then
        Assert.assertEquals("[Twitter] blah... blah...", skipperPublisher);
        Assert.assertEquals("[Snapchat] blah... blah...", kowalskiPublisher);
        Assert.assertEquals("[Facebook] blah... blah...", ricoPublisher);
    }
    @Test
    public void testIndividualSharingStrategy(){
        //given
        User rico = new ZGeneration("Rico");
        //when
        String ricoBefore = rico.sharePost();
        System.out.println("Rico beafore: " + ricoBefore);
        rico.setSocialPublisher(new TwitterPublisher());
        String ricoAfter = rico.sharePost();
        System.out.println("Rico after: " + ricoAfter);
        //Then
        Assert.assertEquals("[Twitter] blah... blah...", ricoAfter);
    }
}

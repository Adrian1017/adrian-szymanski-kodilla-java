package com.kodilla.patterns.builder.bigmac;
import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {
    @Test
    public void testBigMacBuilder() {
        //given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .roll("usual")
                .burger(2)
                .sauce("1000 islands")
                .ingredients("salad")
                .ingredients("cucumber")
                .ingredients("cheese")
                .build();
        System.out.println(bigmac);
        //when
        int numberOfIngredients = bigmac.getIngredients().size();
        //then
        Assert.assertEquals(3, numberOfIngredients);
    }
}
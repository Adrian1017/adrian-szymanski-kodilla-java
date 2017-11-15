package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity(){
        //Given
        Country poland = new Country(new BigDecimal(10));
        Country germany = new Country(new BigDecimal(10));
        Country france = new Country(new BigDecimal(10));
        Continent europe = new Continent();
        europe.addCountry(poland);
        europe.addCountry(germany);
        europe.addCountry(france);

        Country china = new Country(new BigDecimal(10));
        Country japan = new Country(new BigDecimal(10));
        Country russia = new Country(new BigDecimal(10));
        Continent asia = new Continent();
        asia.addCountry(china);
        asia.addCountry(japan);
        asia.addCountry(russia);

        Country egypt = new Country(new BigDecimal(10));
        Country kenya = new Country(new BigDecimal(10));
        Country togo = new Country(new BigDecimal(10));
        Continent africa = new Continent();
        africa.addCountry(egypt);
        africa.addCountry(kenya);
        africa.addCountry(togo);

        World world = new World();
        world.addContinent(europe);
        world.addContinent(asia);
        world.addContinent(africa);
        BigDecimal expectedPeopleQuantity = new BigDecimal(90);

        //When
        BigDecimal actualPeopleQuantity = world.getPeopleQuantity();

        //Then
        Assert.assertEquals(expectedPeopleQuantity,actualPeopleQuantity);

    }
}

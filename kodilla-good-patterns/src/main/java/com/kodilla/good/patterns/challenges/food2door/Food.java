package com.kodilla.good.patterns.challenges.food2door;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

public class Food {
    private String kindOfFood;

    public String getKindOfFood() {
        return kindOfFood;
    }

    public Food(String kindOfFood) {

        this.kindOfFood = kindOfFood;
    }
}

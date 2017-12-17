package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public final class Bigmac {
    private final String roll;
    private final int burger;
    private final String sauce;
    private final List<String> ingredients;

    public static class BigmacBuilder {
        private String roll;
        private int burger;
        private String sauce;
        private List<String> ingredients = new ArrayList<>();

        public BigmacBuilder roll(String roll) {
            this.roll=roll;
            if(roll.toLowerCase().equals("usual")|| roll.toLowerCase().equals("sesame")) {
                return this;
            }
            throw new IllegalStateException("Wrong rolls options!");
        }

        public BigmacBuilder burger(int burger) {
            this.burger=burger;
            return this;
        }

        public BigmacBuilder sauce(String sauce) {
            this.sauce=sauce;
            if(sauce.toLowerCase().equals("standard")||sauce.toLowerCase().equals("1000 islands") || sauce.toLowerCase().equals("barbecue")) {
                return this;
            }
            throw new IllegalStateException("Wrong sauce options!");
        }

        public BigmacBuilder ingredients(String ingredient) {
            ingredients.add(ingredient);
            if(ingredient.toLowerCase().equals("salad")||ingredient.toLowerCase().equals("onion")||ingredient.toLowerCase().equals("bacon")
                    ||ingredient.toLowerCase().equals("cucumber")||ingredient.toLowerCase().equals("chili")||ingredient.toLowerCase().equals("mushrooms")
                    ||ingredient.toLowerCase().equals("shrimps")||ingredient.toLowerCase().equals("cheese")) {
                return this;
            }
            throw new IllegalStateException("Wrong ingredients options!");
        }

        public Bigmac build() {
            return new Bigmac(roll, burger, sauce, ingredients);
        }
    }

    private Bigmac(final String roll, final int burger, final String sauce, final List<String> ingredients) {
        this.roll = roll;
        this.burger = burger;
        this.sauce = sauce;
        this.ingredients = ingredients;
    }

    public String getRoll() {
        return roll;
    }

    public int getBurger() {
        return burger;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "BigMac{" +
                "roll='" + roll + '\'' +
                ", burger=" + burger +
                ", sauce='" + sauce + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
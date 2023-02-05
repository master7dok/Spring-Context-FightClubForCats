package com.mbdev.springcontext;

public class CombatCat {

    private String name;
    @CalculateCatStrength(minStrength = 10, maxStrength = 14)
    private Integer strength;

    public String getName() {
        return name;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CombatCat{" +
                "name='" + name + '\'' +
                ", strength=" + strength +
                '}';
    }
}

package com.xebialabs;

/*This class defines a method that takes name of a metal and
* returns it's per unit price from the Repository named perUnitStore
* */

public class PerUnitPriceOfMetal {

//    Takes a string and searches for it's value in the Hashmap named perUnitStore
    public Double costOfMetal(String metalName) {
        return Repository.perUnitStore.get(metalName);
    }
}

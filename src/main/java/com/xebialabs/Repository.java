package com.xebialabs;

import java.util.HashMap;
import java.util.Map;

class Repository {

//    final map that contains the name of the metal and it's per unit price
    static Map<String, Double> perUnitStore = new HashMap<>();

//    intermediate map
    static Map<String, String> symbolMap = new HashMap<>();

//    contains actual information, maps user defined symbols to actual per unit credit
    static Map<String, Integer> symbolValue = new HashMap<>();

//    factual credit values of roman numbers from which symbolValue map is derived
    static Map<String, Integer> romanValues = new HashMap<>();

    final void setup() {
        romanValues.put("I", 1);
        romanValues.put("V", 5);
        romanValues.put("X", 10);
        romanValues.put("L", 50);
        romanValues.put("C", 100);
        romanValues.put("D", 500);
        romanValues.put("M", 1000);
    }
}

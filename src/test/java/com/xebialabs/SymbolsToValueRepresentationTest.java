package com.xebialabs;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SymbolsToValueRepresentationTest {

    @Before
    public void setup(){
        Repository.symbolValue.put("glob", 100);
        Repository.symbolValue.put("prok", 200);
        Repository.symbolValue.put("habibi", 300);
        Repository.symbolMap.put("glob", "I");
        Repository.symbolMap.put("prok", "V");
        Repository.symbolMap.put("habibi", "X");
    }

    @Test
    public void calculateWhenValuesRepeatConsecutively() {
        SymbolsToValueRepresentation calculate = new SymbolsToValueRepresentation();
        List<String> testList = new ArrayList<>();
        testList.add("glob");
        testList.add("glob");
        testList.add("habibi");
        assertEquals(300, calculate.calculate(testList), .5);
    }

    @Test
    public void calculateWhenValuesAreInIncreasingOrder() {
        SymbolsToValueRepresentation calculate = new SymbolsToValueRepresentation();
        List<String> testList = new ArrayList<>();
        testList.add("glob");
        testList.add("prok");
        testList.add("habibi");
        assertEquals(400, calculate.calculate(testList), .5);
    }

    @Test
    public void calculateWhenValuesAreInDecreasingOrder() {
        SymbolsToValueRepresentation calculate = new SymbolsToValueRepresentation();
        List<String> testList = new ArrayList<>();
        testList.add("habibi");
        testList.add("prok");
        testList.add("glob");
        assertEquals(600, calculate.calculate(testList), .5);
    }
}
package com.xebialabs;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GetPerUnitPriceOfMetalTest {

    private GetPerUnitPriceOfMetal getPrice = new GetPerUnitPriceOfMetal();

    @Before
    public void setup(){
        Repository.perUnitStore.put("glob", 100.0);
        Repository.perUnitStore.put("prok", 200.0);
        Repository.perUnitStore.put("habibi", 300.00);
    }

    @Test
    public void costOfMetal() {
        assertEquals(100.0, getPrice.costOfMetal("glob"), 0.5);
        assertEquals(200.0, getPrice.costOfMetal("prok"), 0.5);
        assertEquals(300.0, getPrice.costOfMetal("habibi"), 0.5);
    }
}
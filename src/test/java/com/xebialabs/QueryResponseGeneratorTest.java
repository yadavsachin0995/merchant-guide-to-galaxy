package com.xebialabs;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueryResponseGeneratorTest {

    private QueryResponseGenerator queryResponse = new QueryResponseGenerator();

    @Before
    public void setup(){
        Repository repository = new Repository();
        repository.setup();

        Repository.symbolMap.put("bro", "I");
        Repository.symbolValue.put("bro", 5);
        Repository.perUnitStore.put("Apple", 100.0);
    }

    @Test
    public void saveSymbolInformation() {
        assertTrue(queryResponse.saveSymbolInformation("bro is cool"));
    }

    @Test
    public void processCredits() {
        assertTrue(queryResponse.processCredits("bro bro bro means 300 Credits"));
    }

    @Test
    public void processHowMuch() {
        assertEquals("bro is 5 Credits", queryResponse.processHowMuch("how much is bro ?"));
    }

    @Test
    public void processHowMany() {
        assertEquals("bro Apple is 500.0 Credits", queryResponse.processHowMany("how many Credits is bro Apple ?"));
    }
}
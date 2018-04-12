package com.xebialabs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SymbolConcatenationTest {

    private SymbolConcatenation generator = new SymbolConcatenation();

    @Test
    public void generateConcat() {
        List<String> testList = new ArrayList<>();
        testList.add("glob");
        testList.add("prok");
        testList.add("habibi");
        assertEquals("glob prok habibi", generator.generateConcat(testList));
    }
}
package com.xebialabs;

import java.util.List;


// Defines a method to concatenate a list of symbols
public class GenerateSymbolConcat {

    public String generateConcat(List<String> symbols){
        String symbolConcat = "";
        for (String word : symbols){
            symbolConcat += " " + word;
        }
        return symbolConcat.trim();
    }
}

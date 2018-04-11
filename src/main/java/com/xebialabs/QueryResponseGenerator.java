package com.xebialabs;

import java.util.ArrayList;
import java.util.List;

// Defines method each of which maps to one case of InputCategory.findInputLineCategory()
// method.
public class QueryResponseGenerator {

    CalculateTotalValueFromSymbols calculateTotalValueFromSymbols = new CalculateTotalValueFromSymbols();
    GenerateSymbolConcat generate = new GenerateSymbolConcat();
    GetPerUnitPriceOfMetal getPerUnitPriceOfMetal = new GetPerUnitPriceOfMetal();

//    Saves input line information to an intermediate map having "Symbol" --> "Roman" information
    public boolean saveSymbolInformation(String line){
        List<String> temp = new ArrayList<>();
        for (String word : line.split(" is ")){
            temp.add(word.trim());
        }
        Repository.symbolMap.put(temp.get(0).trim(), temp.get(1).trim());

        for (String key : Repository.symbolMap.keySet()){
            Repository.symbolValue.put(key.trim(), Repository.romanValues.get(Repository.symbolMap.get(key)));
        }
        return true;
    }

//    Calculates and saves per unit cost of a metal and saves to Repository.perUnitStore
    public boolean processCredits(String line) {
        List<String> symbols = new ArrayList<>();
        List<String> tempFullLine = new ArrayList<>();
        for (String word : line.split(" ")){
            if (Repository.symbolMap.keySet().contains(word.trim())){
                symbols.add(word.trim());
            }
            tempFullLine.add(word.trim());
        }
        for (String word : symbols){
            tempFullLine.remove(word.trim());
        }
        String creditOnly = line.replaceAll("[^0-9]", "");


        double perUnitPrice;
        double priceFromInputLine = Integer.parseInt(creditOnly);
        int symbolsSum = calculateTotalValueFromSymbols.calculate(symbols);
        if (symbolsSum > 0)
            perUnitPrice = priceFromInputLine / symbolsSum;
        else
            perUnitPrice = priceFromInputLine;

        Repository.perUnitStore.put(tempFullLine.get(0).trim(), perUnitPrice);

        return true;
    }

//    Returns a calculated value of input Symbols
    public String processHowMuch(String line) {
        List<String> symbols = new ArrayList<>();
        for (String word : line.split(" ")){
            if (Repository.symbolMap.keySet().contains(word.trim()))
                symbols.add(word.trim());
        }

        return generate.generateConcat(symbols).concat(" is " + calculateTotalValueFromSymbols.calculate(symbols) + " Credits");
    }

//    Returns calculated Credits for a particular quantity of metal
    public String processHowMany(String line) {
        List<String> symbols = new ArrayList<>();
        String metalName = null;
        for (String word : line.split(" ")){
            if (Repository.symbolValue.containsKey(word.trim()))
                symbols.add(word.trim());
            else if (!word.equalsIgnoreCase("?") && !word.equalsIgnoreCase("how") && !word.equalsIgnoreCase("many")
                    && !word.equalsIgnoreCase("is"))
                metalName = word.trim();
        }

        double metalPriceForQuantity = calculateTotalValueFromSymbols.calculate(symbols)
                * getPerUnitPriceOfMetal.costOfMetal(metalName);
        String concatenatedSymbols = generate.generateConcat(symbols);
        return concatenatedSymbols.concat(" " + metalName.concat(" is " + metalPriceForQuantity + " Credits"));
    }
}

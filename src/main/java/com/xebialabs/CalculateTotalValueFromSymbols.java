package com.xebialabs;

import java.util.ArrayList;
import java.util.List;

// Defines method to calculate the Credit values from the list of Symbols
public class CalculateTotalValueFromSymbols {

//    Defines an ArrayList that contains the Roman Symbols which can not be subtracted from
//    other Symbols

    ComplianceRules complianceRules = new ComplianceRules();

    List<String> exemptedFromSubtraction = new ArrayList<>();


//    Takes list of InterGalactic Symbols and returns Credits based on imposed Rules
    public double calculate(List<String> symbols){
        double sum = 0;
        int value = 0;
        int nextValue = 0;

        exemptedFromSubtraction.add("V");
        exemptedFromSubtraction.add("L");
        exemptedFromSubtraction.add("D");

        for (int i=0; i<symbols.size(); ){
            String romanSymbolAtPositionI = Repository.symbolMap.get(symbols.get(i));
            value = Repository.symbolValue.get(symbols.get(i));
            String romanSymbolAtPositionIPlusOne = null;
            if (i == (symbols.size() - 1))
                nextValue = 0;
            else{
                romanSymbolAtPositionIPlusOne = Repository.symbolMap.get(symbols.get(i + 1));
                nextValue = Repository.symbolValue.get(symbols.get(i+1));
            }

            if ((value<nextValue) && complianceRules.compliant(romanSymbolAtPositionI, romanSymbolAtPositionIPlusOne)
                    && !exemptedFromSubtraction.contains(value)){
                sum += (nextValue-value);
                i+=2;
            }

            else{
                sum += value;
                i++;
            }
        }

        return sum;
    }
}

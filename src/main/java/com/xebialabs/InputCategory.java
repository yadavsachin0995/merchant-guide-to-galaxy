package com.xebialabs;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


// Defines method that classifies to which category does an input line belong
public class InputCategory {

//    Compiles Pattern of type "glob is I"
    final String symbolInformation = "^([A-Za-z]+) is ([I|V|X|L|C|D|M])$";
    Pattern patternSymbolInformation = Pattern.compile(symbolInformation);

//    Compiles Pattern of type "glob prok Silver is 1234 Credits"
    final String credits = "^([A-Za-z]+)([A-Za-z\\s]*) is ([0-9]+) ([c|C]redits)$";
    Pattern patternCredits = Pattern.compile(credits);

//    Compiles Pattern of type "How much is glob prok ?"
    final String howMuch = "^how much is (([A-Za-z\\s])+)\\?$";
    Pattern patternHowMuch = Pattern.compile(howMuch);

//    Compiles Pattern of type "How many credits is glob prok Silver ?"
    final String howMany = "^how many [c|C]redits is (([A-Za-z\\s])+)\\?$";
    Pattern patternHowMany = Pattern.compile(howMany);

//    Takes a List of lines from GetInput Class and classifies each line according
//    to it's class. Returns a list of Responses for each line which is passed to
//    the WriteOutput Class
    public List<String> findInputLineCategory(List<String> inputLines){
        List<String> responseList = new ArrayList<>();

        for (String line : inputLines){

            QueryResponseGenerator queryResponseGenerator = new QueryResponseGenerator();

            if (patternSymbolInformation.matcher(line).matches())
                queryResponseGenerator.saveSymbolInformation(line);

            else if (patternCredits.matcher(line).matches())
                queryResponseGenerator.processCredits(line);

            else if (patternHowMuch.matcher(line).matches())
                responseList.add(String.valueOf(queryResponseGenerator.processHowMuch(line)));

            else if (patternHowMany.matcher(line).matches())
                responseList.add(queryResponseGenerator.processHowMany(line));

            else
                responseList.add("I've no idea what you are talking about");

        }
        return responseList;
    }
}

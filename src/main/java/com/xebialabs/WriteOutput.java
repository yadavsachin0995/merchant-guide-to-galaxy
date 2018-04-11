package com.xebialabs;

import java.util.List;

// Defines a method that writes final output to the Standard Output
public class WriteOutput {

//    Take a List as Argument and print each element of the list on Standard Output
    public void writeOutputOnConsole(List<String> responseList){
        for (String line : responseList){
            System.out.println(line.trim());
        }
    }
}

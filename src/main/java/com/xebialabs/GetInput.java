package com.xebialabs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


// Defines a method to take input from Standard input and store each line in an ArrayList
public class GetInput {

    List<String> inputLines = new ArrayList<>();
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public List<String> getInput() throws IOException {
        while (true){
            String temp = bufferedReader.readLine();
            if (temp.length() > 0)
                inputLines.add(temp);
            else
                break;
        }
        return inputLines;
    }
}

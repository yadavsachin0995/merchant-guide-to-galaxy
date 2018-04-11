package com.xebialabs;

import java.io.IOException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
//        Initialize objects of the classes in which methods are defined
        Repository repository = new Repository();
        GetInput getInput = new GetInput();
        InputCategory inputCategory = new InputCategory();
        WriteOutput writeOutput = new WriteOutput();

//        Setup the repository with the roman numbers to their corresponding values
        repository.setup();

//        Get input from the command line
        List<String> input = getInput.getInput();

//        Calls the method of Class InputCategory to determine what is the line all about
        List<String> inputLineCategory = inputCategory.findInputLineCategory(input);

//        Write the output to the Standard output line by line
        writeOutput.writeOutputOnConsole(inputLineCategory);
    }
}

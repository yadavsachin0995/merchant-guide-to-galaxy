package com.xebialabs;

public class ComplianceRules {
    public boolean compliant(String value, String nextValue){
        boolean check = false;
        if (value.equals("I") && (nextValue.equals("V") || nextValue.equals("X")))
            check = true;
        else if (value.equals("X") && (nextValue.equals("L") || nextValue.equals("C")))
            check = true;
        else if (value.equals("C") && (nextValue.equals("D") || nextValue.equals("M")))
            check = true;

        return check;
    }
}

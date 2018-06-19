package com.efimova.verification;

import com.efimova.verification.ltl.Formula;
import com.efimova.verification.ltl.LtlFormulaParser;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        String ltlFormulaString = args[0];

        LtlFormulaParser parser = new LtlFormulaParser();
        Formula formula = parser.parse(ltlFormulaString);
        System.out.println(formula.toString());
    }
}

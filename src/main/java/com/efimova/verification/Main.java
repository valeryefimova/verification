package com.efimova.verification;

import com.efimova.verification.diagram.Diagram;
import com.efimova.verification.diagram.DiagramParser;
import com.efimova.verification.ltl.Formula;
import com.efimova.verification.ltl.LtlFormulaParser;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        String ltlFormulaString = args[0];

        LtlFormulaParser parser = new LtlFormulaParser();
        Formula formula = parser.parse(ltlFormulaString);
        System.out.println(formula.toString());

        File diagramXmlFile = new File(args[1]);
        DiagramParser diagramService = new DiagramParser();
        Diagram diagram = diagramService.parseDiagram(diagramXmlFile);
        System.out.println(diagram.toString());
    }
}

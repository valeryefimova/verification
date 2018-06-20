package com.efimova.verification;

import com.efimova.verification.automaton.Automaton;
import com.efimova.verification.diagram.Diagram;
import com.efimova.verification.diagram.DiagramParser;
import com.efimova.verification.intersection.AutomatonIntersector;
import com.efimova.verification.ltl.Formula;
import com.efimova.verification.ltl.LtlFormulaParser;
import com.efimova.verification.ltl.Utils;

import java.io.File;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        String ltlFormulaString = args[0];

        LtlFormulaParser parser = new LtlFormulaParser();
        Formula formula = parser.parse(ltlFormulaString);
        System.out.println(formula.toString());
        Automaton ltlAuto = formula.ltlToAutomaton();
        System.out.println(ltlAuto.toString());

        System.out.println();

        File diagramXmlFile = new File(args[1]);
        DiagramParser diagramParser = new DiagramParser();
        Diagram diagram = diagramParser.parseDiagram(diagramXmlFile);
        System.out.println(diagram.toString());

        Automaton diagramAuto = diagram.toAutomaton();
        System.out.println(diagramAuto.toString());

        System.out.println();
        System.out.println("============");
        System.out.println();

        AutomatonIntersector intersector = new AutomatonIntersector();
        Automaton intersection = intersector.intersect(diagramAuto, ltlAuto);
        System.out.println(intersection.toString());

        Collection<Formula> acceptingPath = intersection.findAcceptedWord();
        if (acceptingPath != null) {
            System.out.println("INCORRECT:");
            System.out.println(Utils.formulasToString(acceptingPath));
        } else {
            System.out.println("CORRECT");
        }

    }
}

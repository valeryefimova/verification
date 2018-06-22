package com.efimova.verification;

import com.efimova.verification.automaton.Automaton;
import com.efimova.verification.diagram.Diagram;
import com.efimova.verification.diagram.DiagramParser;
import com.efimova.verification.intersection.AutomatonIntersector;
import com.efimova.verification.ltl.Formula;
import com.efimova.verification.ltl.LtlFormulaParser;
import com.efimova.verification.ltl.Utils;

import java.io.*;
import java.util.Collection;

import static com.efimova.verification.ltl.Utils.not;

public class Main {


    private static void usage() {
        System.out.println("Usage: java -jar verification.jar <mode: batch|single> <formula or file.ltl> <automaton.xstd> <result.out>");
    }

    public static void main(String[] args) throws IOException {
        if(args.length != 4){
            usage();
            return;
        }

        String mode = args[0];
        String ltl = args[1];
        String diagramPath = args[2];
        String outputPath = args[3];

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {

            if (mode.endsWith("batch")) {
                // file
                BufferedReader reader = new BufferedReader(new FileReader(ltl));
                String line;
                while ((line = reader.readLine()) != null) {
                    Collection<Formula> acceptingPath = verificationCounterExample(line, diagramPath);
                    writeRoport(line, acceptingPath, writer);
                }
            } else {
                // single formula
                String ltlFormulaString = args[0];
                Collection<Formula> acceptingPath = verificationCounterExample(ltlFormulaString, diagramPath);
                writeRoport(ltlFormulaString, acceptingPath, writer);
            }
        }
    }

    private static void writeRoport(String formula, Collection<Formula> counterExample, BufferedWriter writer) throws IOException {
        writer.write("Formula: " + formula + " - ");
        if (counterExample != null) {
            System.out.println("INCORRECT " + formula);
            writer.write("INCORRECT " + formula);
            writer.newLine();
            writer.write(Utils.formulasToString(counterExample));
            writer.newLine();
        } else {
            System.out.println("CORRECT " + formula);
            writer.write("CORRECT " + formula + ": ");
            writer.newLine();
        }
        writer.newLine();
        writer.newLine();
        writer.newLine();
        writer.flush();
    }

    private static Collection<Formula> verificationCounterExample(String ltlFormulaString, String diagramPath) {
        LtlFormulaParser parser = new LtlFormulaParser();
        Formula formula = parser.parse(ltlFormulaString);
//        System.out.println(formula.toString());
        Automaton ltlAuto = not(formula).ltlToAutomaton();
//        System.out.println(ltlAuto.toString());

//        System.out.println();

        File diagramXmlFile = new File(diagramPath);
        DiagramParser diagramParser = new DiagramParser();
        Diagram diagram = diagramParser.parseDiagram(diagramXmlFile);
//        System.out.println(diagram.toString());

        Automaton diagramAuto = diagram.toAutomaton();
//        System.out.println(diagramAuto.toString());

//        System.out.println();
//        System.out.println("============");
//        System.out.println();

        AutomatonIntersector intersector = new AutomatonIntersector();
        Automaton intersection = intersector.intersect(diagramAuto, ltlAuto);
//        System.out.println(intersection.toString());
        return intersection.findAcceptedWord();
    }
}

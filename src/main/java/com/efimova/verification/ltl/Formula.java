package com.efimova.verification.ltl;

import com.efimova.verification.LtlVisitor;
import com.efimova.verification.automaton.Automaton;
import com.efimova.verification.automaton.State;
import com.efimova.verification.automaton.Transition;
import com.efimova.verification.automaton.generated.BuchiLexer;
import com.efimova.verification.automaton.generated.BuchiParser;
import lombok.SneakyThrows;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

import static com.efimova.verification.ltl.Utils.trueConst;


public abstract class Formula {
    public abstract Formula transformName(Function<String, String> transformer);

    public abstract void accept(LtlVisitor visitor);


    public Automaton ltlToAutomaton() {
        Map<String, String> oldToNeNamesMap = new HashMap<>();

        // replace all names with vX, where x is a number:
        Formula lowercaseLTL = this.transformName(name ->
                oldToNeNamesMap.computeIfAbsent(name, v -> "v" + oldToNeNamesMap.size()));

        // replace Release to V in orders to comply spin syntax:
        String spinSyntaxFormula = lowercaseLTL.toString().replace("R", "V");

        Map<String, String> newToOldNamesMap = new HashMap<>();
        for (Map.Entry<String, String> entry : oldToNeNamesMap.entrySet()) {
            newToOldNamesMap.put(entry.getValue(), entry.getKey());
        }

        Automaton automaton = ltlToAutomaton(spinSyntaxFormula);
        return automaton.withRenamedTransitions(t -> t.transformName(newToOldNamesMap::get));
    }


    private Automaton ltlToAutomaton(String ltl) {
        String buchiAutomaton = spinLtlToBA(ltl);

        CharStream in = CharStreams.fromString(buchiAutomaton);
        BuchiLexer lexer = new BuchiLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        BuchiParser parser = new BuchiParser(tokens);
        List<State> states = parser.automaton().list;

        AtomicInteger ids = new AtomicInteger();
        Map<String, Integer> idMap = new HashMap<>();
        Automaton automaton = new Automaton();
        for (State state : states) {
            int nodeId = idMap.computeIfAbsent(state.getName(), k -> ids.getAndIncrement());
            if (state.isAccept()) {
                automaton.addAccepting(nodeId);
            }
            if (state.isInit()) {
                automaton.setInitialState(nodeId);
            }
            for (Transition transition : state.getTransitions()) {
                int nextId = idMap.computeIfAbsent(transition.getStateName(), k -> ids.getAndIncrement());
                Formula formula = transition.getExpression();
                automaton.addTransition(nodeId, nextId, formula);
                if (transition.isAccept()) {
                    automaton.addAccepting(nextId);
                }
                if (transition.isInit()) {
                    automaton.setInitialState(nextId);
                }
            }
        }
        for (int nodeId : automaton.getNodes()) {
            if (automaton.getTransitionsMap(nodeId).isEmpty()) {
                automaton.addTransition(nodeId, nodeId, trueConst());
            }
        }
        return automaton;
    }


    @SneakyThrows
    private String spinLtlToBA(String ltl) {
        String cygwinBash = "C:\\lib\\cygwin64\\bin\\bash.exe";
        String ltl2baExecutable = "ltl2ba/ltl2ba.exe";
        String configFile = "src/main/resources/config.properties";

        BufferedReader reader = new BufferedReader(new FileReader(configFile));
        String s = reader.readLine();
        if (!s.isEmpty()) {
            cygwinBash = s;
            s = reader.readLine();
            ltl2baExecutable = s;
        } else {
            System.err.println("Unable to read config file: " + configFile);
        }

        String command = ltl2baExecutable + " -f \\\"" + ltl + "\\\"";  // windows way

        Process process = Runtime.getRuntime().exec(new String[]{cygwinBash, "-c", command});
        process.waitFor();

        StringWriter errorWriter = new StringWriter();
        IOUtils.copy(process.getErrorStream(), errorWriter);
        if (errorWriter.toString().length() > 0) {
            System.err.println(errorWriter.toString());
        }

        StringWriter writer = new StringWriter();
        IOUtils.copy(process.getInputStream(), writer);
        return writer.toString();
    }
}

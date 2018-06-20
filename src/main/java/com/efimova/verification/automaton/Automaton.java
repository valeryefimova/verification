package com.efimova.verification.automaton;

import com.efimova.verification.ltl.Formula;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.*;
import java.util.function.Function;


@Data
@EqualsAndHashCode
@ToString
public class Automaton {
    private int initialState;
    private Set<Integer> nodes = new HashSet<>();
    private Set<Integer> acceptingSet = new HashSet<>();
    private Map<Integer, Map<Formula, List<Integer>>> transitions = new HashMap<>();

    public Map<Formula, List<Integer>> getTransitionsMap(int stateId) {
        return transitions.computeIfAbsent(stateId, k -> new HashMap<>());
    }

    public void addTransition(int stateA, int stateB, Formula edgeFormula) {
        nodes.add(stateA);
        nodes.add(stateB);
        Map<Formula, List<Integer>> outgoings = getTransitionsMap(stateA);
        outgoings.putIfAbsent(edgeFormula, new ArrayList<>());
        outgoings.get(edgeFormula).add(stateB);
    }

    public void addAccepting(int state) {
        nodes.add(state);
        acceptingSet.add(state);
    }

    public boolean accepts(int state) {
        return acceptingSet.contains(state);
    }


    /**
     * Renames all variables in transition formulas and created a new automaton.
     * @param mapper mapper function for renaming variables
     * @return a new automaton where transition formulas have new variables
     */
    public Automaton withRenamedTransitions(Function<Formula, Formula> mapper) {
        Automaton automaton = new Automaton();

        transitions.forEach((nodeId, successors) -> {
            successors.forEach((transitionFormula, value) -> {
                // rename all variables in the formula according to the given mapper:
                Formula newFormula = mapper.apply(transitionFormula);
                for (int targetId : value) {
                    automaton.addTransition(nodeId, targetId, newFormula);
                }
            });
        });

        acceptingSet.forEach(automaton::addAccepting);
        automaton.setInitialState(initialState);
        return automaton;
    }
}

package com.efimova.verification.automaton;

import com.efimova.verification.ltl.Formula;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.*;


@Data
@EqualsAndHashCode
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
}

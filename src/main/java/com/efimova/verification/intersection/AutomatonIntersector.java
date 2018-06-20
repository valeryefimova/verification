package com.efimova.verification.intersection;

import com.efimova.verification.automaton.Automaton;
import com.efimova.verification.ltl.Formula;
import org.antlr.v4.runtime.misc.Triple;

import java.util.HashMap;
import java.util.Map;


/**
 * Automaton intersection algorithm
 */
public class AutomatonIntersector {

    // key: 3-tuple=(a,b, isAccepting)
    // value state number. 0,1,...
    private final Map<Triple<Integer, Integer, Boolean>, Integer> newStatesMap = new HashMap<>();

    private int mapToNewState(int aState, int bState, boolean isAccepting) {
        return newStatesMap.computeIfAbsent(
                new Triple<>(aState, bState, isAccepting), k -> newStatesMap.size());
    }

    public Automaton intersect(Automaton a, Automaton b) {
        LtlIntersector intersector = new LtlIntersector();
        Automaton newAutomaton = new Automaton();

        newAutomaton.setInitialState(mapToNewState(a.getInitialState(), b.getInitialState(), false));

        a.getTransitions().forEach((aState, aSuccessors) -> {
            b.getTransitions().forEach((bState, bSuccessors) -> {
                aSuccessors.keySet().forEach(aFormula -> {
                    bSuccessors.keySet().forEach(bFormula -> {

                        Formula transitionFormula = intersector.intersect(aFormula, bFormula);

                        if (transitionFormula != null) {
                            aSuccessors.get(aFormula).forEach(aSucc -> {
                                bSuccessors.get(bFormula).forEach(bSucc -> {
                                    newAutomaton.addTransition(
                                            mapToNewState(aState, bState, false),
                                            mapToNewState(aSucc, bSucc, a.accepts(aState)),
                                            transitionFormula);
                                    newAutomaton.addTransition(
                                            mapToNewState(aState, bState, true),
                                            mapToNewState(aSucc, bSucc, !a.accepts(bState)),
                                            transitionFormula);
                                });
                            });
                        }
                    });
                });
            });
        });

        for (int bAccState : b.getAcceptingSet()) {
            for (int aState : a.getTransitions().keySet()) {
                newAutomaton.addAccepting(mapToNewState(aState, bAccState, true));
            }
        }
        return newAutomaton;
    }
}

package com.efimova.verification.automaton;

import com.efimova.verification.ltl.Formula;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.*;
import java.util.function.Function;

import static com.efimova.verification.automaton.Automaton.Color.BLACK;
import static com.efimova.verification.automaton.Automaton.Color.GRAY;


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
     *
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

    enum Color {
        GRAY,
        BLACK;

        static boolean isWhite(Color other) {
            return (!GRAY.equals(other)) && (!BLACK.equals(other));
        }
    }

    public Collection<Formula> findAcceptedWord() {
        Map<Integer, Color> color1 = new HashMap<>();
        Map<Integer, Color> color2 = new HashMap<>();
        Deque<Formula> path = new ArrayDeque<>();
        dfs1(initialState, color1, color2, path);
        return path.isEmpty() ? null : path;
    }


    private Map<Formula, List<Integer>> getTransitionsOrDefault(int stateId) {
        return transitions.computeIfAbsent(stateId, k -> new LinkedHashMap<>());
    }

    private boolean dfs1(int curNode, Map<Integer, Color> color1,
                         Map<Integer, Color> color2, Deque<Formula> pathByFormulas) {
        color1.put(curNode, GRAY);
        for (Formula formula : getTransitionsOrDefault(curNode).keySet()) {
            for (int target : getTransitionsMap(curNode).get(formula)) {
                if (Color.isWhite(color1.get(target))) {
                    // try include the formula:
                    pathByFormulas.addLast(formula);

                    if (dfs1(target, color1, color2, pathByFormulas)) {
                        return true;
                    }
                    // if nothing found, exclude formula and continue:
                    pathByFormulas.removeLast();
                }
            }
        }

        if (accepts(curNode)) {
            if (dfs2(curNode, color1, color2, pathByFormulas)) {
                return true;
            }
        }
        color1.put(curNode, BLACK);
        return false;
    }

    private boolean dfs2(int curNode, Map<Integer, Color> color1,
                         Map<Integer, Color> color2, Deque<Formula> path) {
        color2.put(curNode, GRAY);
        for (Formula formula : getTransitionsOrDefault(curNode).keySet()) {
            for (int target : getTransitionsMap(curNode).get(formula)) {
                if (GRAY.equals(color1.get(target))) {
                    path.addLast(formula);
                    return true;
                }
                if (Color.isWhite(color2.get(target))) {
                    path.addLast(formula);
                    if (dfs2(target, color1, color2, path)) {
                        return true;
                    }
                    path.removeLast();
                }
            }
        }
        color2.put(curNode, BLACK);
        return false;
    }
}

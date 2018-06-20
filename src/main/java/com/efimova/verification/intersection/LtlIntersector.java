package com.efimova.verification.intersection;


import com.efimova.verification.LtlVisitor;
import com.efimova.verification.ltl.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static com.efimova.verification.ltl.Operation.CON;
import static com.efimova.verification.ltl.Operation.DIS;


public class LtlIntersector {

    /**
     * Intersects two formulas, where the first one has to be conjunction of variables or a true constant.
     */
    public Formula intersect(Formula a, Formula b) {
        Set<Variable> variables = Collections.emptySet();

        if (!a.equals(Utils.trueConst())) {
            VariableExtractorVisitor visitor = new VariableExtractorVisitor();
            a.accept(visitor);
            variables = visitor.getResult();
        }
        FormulaEvaluatorVisitor evaluator = new FormulaEvaluatorVisitor(variables);
        b.accept(evaluator);
        return evaluator.isCurrentValue() ? a : null;
    }

    /**
     * Extracts variables from given conjunction formula or variable.
     */
    private class VariableExtractorVisitor implements LtlVisitor {
        private Set<Variable> variables = new HashSet<>();

        Set<Variable> getResult() {
            return variables;
        }

        @Override
        public void visit(Binary binary) {
            if (!binary.getOperation().equals(CON)) {
                notSupported();
            }
            binary.getLeft().accept(this);
            binary.getRight().accept(this);
        }

        @Override
        public void visit(Variable variable) {
            variables.add(variable);
        }

        @Override
        public void visit(Const c) {
            notSupported();
        }

        @Override
        public void visit(Not formula) {
            notSupported();
        }

        @Override
        public void visit(Next formula) {
            notSupported();
        }

        private void notSupported() {
            throw new IllegalStateException(this.getClass().getName()
                    + " is supposed to extract variables only from Conjunction operations or single Variable class.");
        }
    }

    /**
     * Evaluates a Formula, which only from Const, Variable, Not, conjunction and disjunction.
     */
    @RequiredArgsConstructor
    private class FormulaEvaluatorVisitor implements LtlVisitor {
        @Getter
        private boolean currentValue;

        @NonNull
        private Set<Variable> trueVariables;

        @Override
        public void visit(Binary binary) {
            if (!binary.getOperation().equals(DIS) && !binary.getOperation().equals(CON)) {
                throw new IllegalStateException("Given binary formula should be either Conjunction or Disjunction.");
            }

            binary.getLeft().accept(this);
            boolean left = currentValue;
            binary.getRight().accept(this);
            boolean right = currentValue;

            if (binary.getOperation().equals(DIS)) {
                currentValue = left || right;
            }
            if (binary.getOperation().equals(CON)) {
                currentValue = left && right;
            }
        }

        @Override
        public void visit(Const c) {
            currentValue = c.isTrue();
        }

        @Override
        public void visit(Not formula) {
            formula.getF().accept(this);
            currentValue = !currentValue;
        }

        @Override
        public void visit(Variable variable) {
            currentValue = trueVariables.contains(variable);
        }

        @Override
        public void visit(Next formula) {
            throw new IllegalStateException(this.getClass().getName()
                    + " is not supposed to calculate value of " + formula.getClass().getName()
                    + ". Only regular boolean operations (AND, OR), constants and variables are supported.");
        }
    }


}


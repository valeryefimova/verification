package com.efimova.verification.ltl;

import static com.efimova.verification.ltl.Operation.*;

public class Utils {
    public static  Formula conjunction(Formula l, Formula r) {
        return new Binary(CON, l, r);
    }

    public static  Formula disjunction(Formula l, Formula r) {
        return new Binary(DIS, l, r);
    }

    public static  Formula release(Formula l, Formula r) {
        return new Binary(RELEASE, l, r);
    }

    public static  Formula until(Formula l, Formula r) {
        return new Binary(UNTIL, l, r);
    }

    public static  Formula eq(Formula l, Formula r) {
        return new Binary(CON, implication(l, r), implication(r, l));
    }

    public static  Formula implication(Formula l, Formula r) {
        return new Binary(DIS, new Not(l), r);
    }

    public static  Formula not(Formula f) {
        return new Not(f);
    }

    public static  Formula next(Formula f) {
        return new Next(f);
    }

    public static  Formula variable(String var) {
        return new Variable(var);
    }

    public static  Formula trueConst() {
        return new Const(true);
    }

    public static  Formula falseConst() {
        return new Const(false);
    }

    //Note: Future and Globally can be expressed using Until and Release respectively.
    public static  Formula future(Formula f) {
        return new Binary(UNTIL, trueConst(), f);
    }

    public static  Formula globally(Formula f) {
        return new Binary(RELEASE, falseConst(), f);
    }

    public static String formulasToString(Iterable<Formula> formulas){
        StringBuilder res = new StringBuilder();
        for(Formula step : formulas){
            res.append(step).append(System.lineSeparator());
        }
        return res.toString();
    }
}

package com.efimova.verification;

import com.efimova.verification.ltl.*;


public interface LtlVisitor {
    void visit(Binary binary);

    void visit(Const c);

    void visit(Not formula);

    void visit(Next formula);

    void visit(Variable variable);
}
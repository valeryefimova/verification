package com.efimova.verification.ltl;

import com.efimova.verification.LtlVisitor;

import java.util.function.Function;


public abstract class Formula {
    public abstract Formula transformName(Function<String, String> transformer);

    public abstract void accept(LtlVisitor visitor);
}

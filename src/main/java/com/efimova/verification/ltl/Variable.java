package com.efimova.verification.ltl;

import com.efimova.verification.LtlVisitor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.function.Function;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Variable extends Formula {
    private String name;

    @Override
    public String toString() {
        return name;
    }

    @Override
    public Formula transformName(Function<String, String> transformer) {
        return new Variable(transformer.apply(name));
    }

    @Override
    public void accept(LtlVisitor visitor) {
        visitor.visit(this);
    }
}

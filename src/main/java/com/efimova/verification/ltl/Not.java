package com.efimova.verification.ltl;

import com.efimova.verification.LtlVisitor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.function.Function;


@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Not extends Formula {
    private final Formula f;

    @Override
    public String toString() {
        return "!" + f;
    }

    @Override
    public Formula transformName(Function<String, String> transformer) {
        return new Not(f.transformName(transformer));
    }

    @Override
    public void accept(LtlVisitor visitor) {
        visitor.visit(this);
    }
}

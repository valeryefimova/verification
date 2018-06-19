package com.efimova.verification.ltl;

import com.efimova.verification.LtlVisitor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.function.Function;


@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Const extends Formula {
    private final boolean isTrue;

    @Override
    public String toString() {
        return String.valueOf(isTrue);
    }

    @Override
    public Formula transformName(Function<String, String> transformer) {
        return this;
    }

    @Override
    public void accept(LtlVisitor visitor) {
        visitor.visit(this);
    }
}

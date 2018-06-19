package com.efimova.verification.ltl;

import com.efimova.verification.LtlVisitor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.function.Function;


@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Binary extends Formula {
    private Operation operation;
    private Formula left;
    private Formula right;

    @Override
    public String toString() {
        return "(" + left + operation.toString() + right + ")";
    }

    @Override
    public Formula transformName(Function<String, String> transformer) {
        return new Binary(operation, left.transformName(transformer), right.transformName(transformer));
    }

    @Override
    public void accept(LtlVisitor visitor) {
        visitor.visit(this);
    }
}

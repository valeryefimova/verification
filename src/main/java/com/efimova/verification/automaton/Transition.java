package com.efimova.verification.automaton;

import com.efimova.verification.ltl.Formula;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Transition {
    private Formula expression;
    private String stateName;

    public boolean isAccept() {
        return stateName.startsWith("accept_");
    }

    public boolean isInit() {
        return stateName.endsWith("_init");
    }
}

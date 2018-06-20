package com.efimova.verification.automaton;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class State {
    private String name;
    private List<Transition> transitions;

    public boolean isAccept() {
        return name.startsWith("accept_");
    }

    public boolean isInit() {
        return name.endsWith("_init");
    }
}

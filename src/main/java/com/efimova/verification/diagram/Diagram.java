package com.efimova.verification.diagram;

import com.efimova.verification.automaton.Automaton;
import com.efimova.verification.ltl.Formula;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.efimova.verification.ltl.Utils.trueConst;
import static com.efimova.verification.ltl.Utils.variable;


@lombok.Data
@JacksonXmlRootElement(localName = "diagram")
public class Diagram {
    @JacksonXmlProperty
    private String name;

    @JacksonXmlProperty
    private Data data;

    @JacksonXmlProperty(localName = "widget")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Widget> widget;


    public Automaton toAutomaton() {
        Map<Integer, Widget> widgetIdToWidget = getWidget()
                .stream().collect(Collectors.toMap(Widget::getId, Function.identity()));
        Map<Integer, Integer> successors = new HashMap<>();

        for (Widget widget : getWidget()) {
            if (widget.isState()) {
                if (widget.getAttributes().getIncomings() == null) {
                    continue;
                }
                for (Incoming incoming : widget.getAttributes().getIncomings()) {
                    Widget prev = widgetIdToWidget.get(incoming.getId());
                    if (prev.isTransition()) {
                        successors.put(incoming.getId(), widget.getId());
                    } else {
                        throw new IllegalStateException("Every incoming widget into State, "
                                + "should be Transition. Found inappropriate linkage: "
                                + prev.getId() + " -> " + widget.getId());
                    }
                }
            }
        }
        Automaton automaton = new Automaton();
        AtomicInteger ids = new AtomicInteger(100000);
        Integer initId = null;
        for (Widget widget : getWidget()) {
            if (widget.isState()) {
                Integer stateNode = widget.getId();
                if (1 == (widget.getAttributes().getType())) {
                    if (initId == null) {
                        initId = ids.getAndIncrement();
                        automaton.setInitialState(initId);
                    }
                    Formula stateEdge = variable("S(" + widget.getAttributes().getName() + ")");
                    automaton.addTransition(initId, stateNode, stateEdge);
                }
                if (widget.getAttributes().getOutgoings() == null) {
                    continue;
                }
                for (Outgoing outgoing : widget.getAttributes().getOutgoings()) {
                    Widget next = widgetIdToWidget.get(outgoing.getId());
                    if (next.isTransition()) {
                        Formula eventEdge = variable("E(" + next.getAttributes().getEvent().getName() + ")");
                        Integer eventNodeId = ids.getAndIncrement();
                        automaton.addTransition(stateNode, eventNodeId, eventEdge);
                        Integer lastNodeId = eventNodeId;

                        if (next.getAttributes().getActions() != null && !next.getAttributes().getActions().isEmpty()) {
                            for (Action action : next.getAttributes().getActions()) {
                                Formula actionEdge = variable("A(" + action.getName() + ")");
                                Integer actionNodeId = ids.getAndIncrement();
                                automaton.addTransition(lastNodeId, actionNodeId, actionEdge);
                                lastNodeId = actionNodeId;
                            }
                        }

                        Integer successorId = successors.get(outgoing.getId());
                        Widget nextState = widgetIdToWidget.get(successorId);
                        Integer nextNode = nextState.getId();
                        Formula nextEdge = variable("S(" + nextState.getAttributes().getName() + ")");
                        automaton.addTransition(lastNodeId, nextNode, nextEdge);
                    } else {
                        throw new IllegalStateException();
                    }
                }
            }
        }
        for (int nodeId : automaton.getNodes()) {
            automaton.addAccepting(nodeId);
            if (automaton.getTransitionsMap(nodeId).isEmpty()) {
                automaton.addTransition(nodeId, nodeId, trueConst());
            }
        }
        return automaton;
    }
}

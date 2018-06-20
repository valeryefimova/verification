package com.efimova.verification.diagram;

import lombok.SneakyThrows;

import java.io.File;
import java.io.PrintWriter;


public class DiagramDrawer {

    public static final String ID = "id";

    /**
     * To get the image, process generated file with:
     * $ dot -Gsplines=true -Goverlap=false -Tpdf graph.dot -o graph.pdf
     */
    @SneakyThrows
    public void convertDiagramToDot(Diagram diagram, File file) {
        try (PrintWriter writer = new PrintWriter(file)) {
            String graphName = diagram.getName();
            writer.println("digraph " + graphName + " {");
            writer.println("\trankdir = LR;");
            for (Widget widget : diagram.getWidget()) {
                if (widget.isState()) {
                    writer.println("\t" + ID + widget.getId() + " [label=\"S(" + widget.getAttributes().getName() + ")\"]");
                    if (widget.getAttributes().getIncomings() != null) {
                        for (Incoming incoming : widget.getAttributes().getIncomings()) {
                            writer.println("\t" + ID + incoming.getId() + " -> " + ID + widget.getId() + ";");
                        }
                    }
                    if (widget.getAttributes().getOutgoings() != null) {
                        for (Outgoing outgoing : widget.getAttributes().getOutgoings()) {
                            writer.println("\t" + ID + widget.getId() + " -> " + ID + outgoing.getId() + ";");
                        }
                    }
                } else if (widget.isTransition()) {
                    writer.println("\t" + ID + widget.getId() + " [shape=\"none\", label=\"" + getLabelByTransition(widget) + "\"]");
                }
            }
            writer.println("}");
        }
    }

    private String getLabelByTransition(Widget transition) {
        Attributes attr = transition.getAttributes();
        StringBuilder sb = new StringBuilder();

        if (attr.getEvent() != null) {
            sb.append("E(").append(attr.getEvent().getName()).append(":").append(attr.getEvent().getComment().replaceAll("\"", ""))
                    .append(")");
        }
        if (attr.getActions() != null) {
            attr.getActions().forEach(a -> {
                sb.append("\\n").append("A(")
                        .append(a.getName()).append("::").append(a.getComment()).append(")");
            });
        }
        return sb.toString();
    }
}

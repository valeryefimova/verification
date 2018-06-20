package com.efimova.verification.diagram;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Widget {
    @JacksonXmlProperty(isAttribute = true)
    private Integer id;
    @JacksonXmlProperty(isAttribute = true)
    private Type type;

    @JacksonXmlProperty(localName = "attributes")
    private Attributes attributes;

    public boolean isState() {
        return Type.State.equals(type);
    }

    public boolean isTransition() {
        return Type.Transition.equals(type);
    }

    public enum Type {
        State,
        Transition
    }
}



package com.efimova.verification.diagram;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import java.util.List;


@Data
public class Attributes {
    @JacksonXmlProperty
    private String name;

    @JacksonXmlProperty
    private Integer type;

    @JacksonXmlProperty
    private String code;

    @JacksonXmlProperty
    private String guard;

    @JacksonXmlProperty(localName = "incoming")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Incoming> incomings;

    @JacksonXmlProperty(localName = "outgoing")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Outgoing> outgoings;

    @JacksonXmlProperty(localName = "action")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Action> actions;

    @JacksonXmlProperty
    private Event event;

    @JacksonXmlProperty
    private Nested nested;
}

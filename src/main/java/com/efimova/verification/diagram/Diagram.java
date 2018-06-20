package com.efimova.verification.diagram;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;


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
}

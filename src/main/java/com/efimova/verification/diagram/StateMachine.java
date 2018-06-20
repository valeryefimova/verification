package com.efimova.verification.diagram;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.util.List;


@Data
@JacksonXmlRootElement(localName = "Statemachine")
@JsonIgnoreProperties(ignoreUnknown = true)
public class StateMachine {
    @JacksonXmlProperty(localName = "event")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Event> events;

    @JacksonXmlProperty
    private Boolean autoreject;
}

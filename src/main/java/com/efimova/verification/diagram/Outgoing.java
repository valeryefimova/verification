package com.efimova.verification.diagram;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;


@Data
@JacksonXmlRootElement(localName = "outgoing")
public class Outgoing {
    @JacksonXmlProperty(isAttribute = true)
    private Integer id;
}
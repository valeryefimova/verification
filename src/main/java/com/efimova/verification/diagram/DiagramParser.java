package com.efimova.verification.diagram;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.SneakyThrows;

import java.io.File;


public class DiagramParser {
    private XmlMapper xmlMapper;

    public DiagramParser() {
        this.xmlMapper = new XmlMapper();
        this.xmlMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
    }

    @SneakyThrows
    public Diagram parseDiagram(File file) {
        return xmlMapper.readValue(file, Diagram.class);
    }
}

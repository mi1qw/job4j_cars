package com.example.car;

import lombok.extern.slf4j.Slf4j;
import org.h2.jdbcx.JdbcDataSource;

import javax.sql.DataSource;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Objects;

@Slf4j
public class XmlParser {
    public DataSource dataSource() {
        String file = Objects.requireNonNull(
                XmlParser.class.getClassLoader().getResource("hibernate.cfg.xml")).getFile();
        JdbcDataSource ds = new JdbcDataSource();
        XMLEventReader reader;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            reader = xmlInputFactory.createXMLEventReader(new FileInputStream(file));
            while (!isComplete(ds) && reader.hasNext()) {
                XMLEvent nextEvent = reader.nextEvent();
                if (nextEvent.isStartElement()) {
                    StartElement startElement = nextEvent.asStartElement();
                    if (startElement.getName().getLocalPart().equals("property")) {
                        String value = startElement
                                .getAttributeByName(new QName("name")).getValue();
                        switch (value) {
                            case "hibernate.connection.url" -> ds
                                    .setUrl(eventData(reader));
                            case "hibernate.connection.password" -> ds
                                    .setPassword(eventData(reader));
                            case "hibernate.connection.username" -> ds
                                    .setUser(eventData(reader));
                        }
                    }
                }
            }
        } catch (XMLStreamException | FileNotFoundException e) {
            log.error(e.getMessage(), e);
        }
        return ds;
    }

    private String eventData(final XMLEventReader reader) throws XMLStreamException {
        return reader.nextEvent().asCharacters().getData()
                .replace("\n", "")
                .trim();
    }

    private boolean isComplete(final JdbcDataSource ds) {
        return !ds.getUser().isEmpty()
               && !ds.getURL().isEmpty()
               && !ds.getPassword().isEmpty();
    }
}

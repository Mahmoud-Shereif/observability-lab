package com.observability.config;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.spi.DeferredProcessingAware;
import com.fasterxml.jackson.core.JsonGenerator;
import net.logstash.logback.composite.AbstractFieldJsonProvider;
import net.logstash.logback.composite.JsonWritingUtils;

import java.io.IOException;

import static com.observability.controller.ObservabilityController.USER_NAME_MESSAGE;

public class LogStashUserNameJsonProvider<Event extends DeferredProcessingAware> extends AbstractFieldJsonProvider<Event> {

    @Override
    public void writeTo(JsonGenerator generator, Event event) throws IOException {
        String message = ((ILoggingEvent) event).getMessage();
        if(message.contains(USER_NAME_MESSAGE)) {
            int beginIndex = message.indexOf(USER_NAME_MESSAGE) + USER_NAME_MESSAGE.length();
            String username = message.substring(beginIndex);
            JsonWritingUtils
                    .writeStringField(generator, "username", username);
        } else {
            JsonWritingUtils
                    .writeStringField(generator, "username", "NA");
        }
    }
}

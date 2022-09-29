package com.observability.config;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.spi.DeferredProcessingAware;
import com.fasterxml.jackson.core.JsonGenerator;
import net.logstash.logback.composite.AbstractFieldJsonProvider;
import net.logstash.logback.composite.JsonWritingUtils;

import java.io.IOException;

import static com.observability.controller.ObservabilityController.ERROR_CODE_MESSAGE;
import static com.observability.controller.ObservabilityController.USER_NAME_MESSAGE;

public class LogStashErrorCodeJsonProvider<Event extends DeferredProcessingAware> extends AbstractFieldJsonProvider<Event> {

    @Override
    public void writeTo(JsonGenerator generator, Event event) throws IOException {
        String message = ((ILoggingEvent) event).getMessage();
        if(message.contains(ERROR_CODE_MESSAGE)) {
            int beginIndex = message.indexOf(ERROR_CODE_MESSAGE);
            String errorCode = message.substring(beginIndex + ERROR_CODE_MESSAGE.length(), message.indexOf(USER_NAME_MESSAGE) - 2);
            JsonWritingUtils
                    .writeStringField(generator, "error-code", errorCode);
        } else {
            JsonWritingUtils
                    .writeStringField(generator, "error-code", "NA");
        }
    }
}

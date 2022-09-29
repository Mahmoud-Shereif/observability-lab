package com.observability.config;

import net.logstash.logback.encoder.LogstashEncoder;

public class LogStashCustomEncoder extends LogstashEncoder {
    public LogStashCustomEncoder() {
        this.addProvider(new LogStashUserNameJsonProvider<>());
        this.addProvider(new LogStashErrorCodeJsonProvider<>());
    }
}

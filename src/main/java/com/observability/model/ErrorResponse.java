package com.observability.model;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class ErrorResponse {
    LocalDateTime date;
    String message;
    String description;
    String code;
    String user;
}

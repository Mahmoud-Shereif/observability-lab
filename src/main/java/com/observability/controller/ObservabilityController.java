package com.observability.controller;

import com.observability.model.Error;
import com.observability.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Slf4j
@Controller
public class ObservabilityController {
    public static final String ERROR_CODE_MESSAGE = "Error Code: ";
    public static final String USER_NAME_MESSAGE = "User Name: ";
    private final Random random = new Random();
    private final List<String> users
            = List.of("user1", "user2", "user3", "user4", "user5");

    @GetMapping("/success")
    public ResponseEntity<Void> success() {
        log.info("Success");
        log.warn("Too many hits");
        return ResponseEntity.ok().build();
    }

    @PostMapping("/error")
    public ResponseEntity<ErrorResponse> error() {
        int r1 = random.nextInt(5);
        int r2 = random.nextInt(5);
        String user = users.get(r1);
        Error error = Error.values()[r2];

        ErrorResponse errorResponse = ErrorResponse
                .builder()
                .code(error.name())
                .description("Error")
                .date(LocalDateTime.now())
                .user(user)
                .message(error.name())
                .build();

        log.error(
                ERROR_CODE_MESSAGE + errorResponse.getCode() + ", "
                        + USER_NAME_MESSAGE + errorResponse.getUser());

        return ResponseEntity
                .badRequest()
                .body(errorResponse);
    }
}

package com.espectro93.jooqdemo;

import java.time.ZonedDateTime;
import java.util.UUID;

public record Book(UUID id, String name, ZonedDateTime creationDate, String author, String content) {
}

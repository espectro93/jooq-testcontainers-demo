package com.espectro93.jooqdemo;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

import static generated.public_.Tables.BOOKS;

@Repository
public class BookRepository {

    private final DSLContext dslContext;

    public BookRepository(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    public Book findById(UUID id) {
        return Optional.ofNullable(dslContext.selectFrom(BOOKS)
                        .where(BOOKS.ID.eq(id))
                        .fetchOne())
                .map(this::map)
                .orElseThrow(() -> new IllegalArgumentException("Deck not found"));
    }

    private Book map(Record record) {
        UUID id = record.get(BOOKS.ID);
        String name = record.get(BOOKS.NAME);
        var creationTime = record.get(BOOKS.CREATION_DATE);
        String author = record.get(BOOKS.AUTHOR);
        String content = record.get(BOOKS.CONTENT);

        return new Book(id, name, creationTime.toZonedDateTime(), author, content);
    }

    public void save(Book book) {
        dslContext.insertInto(BOOKS)
                .set(BOOKS.ID, book.id())
                .set(BOOKS.NAME, book.name())
                .set(BOOKS.CREATION_DATE, book.creationDate().toOffsetDateTime())
                .set(BOOKS.AUTHOR, book.author())
                .set(BOOKS.CONTENT, book.content())
                .execute();
    }
}

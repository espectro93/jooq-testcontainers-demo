package com.espectro93.jooqdemo;

import org.jooq.DSLContext;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jooq.JooqTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.ZonedDateTime;
import java.util.UUID;

import static generated.public_.Tables.BOOKS;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@JooqTest
@ComponentScan(basePackages = "com.espectro93.jooqdemo")
@Import(PostgresConfig.class)
public class BookRepositoryTest {

    @Autowired
    DSLContext dsl;

    BookRepository bookRepository;

    @BeforeEach
    void setup() {
        dsl.truncate(BOOKS).execute();
        bookRepository = new BookRepository(dsl);
    }

    @Test
    void testSaveAndFindById() {
        UUID id = UUID.randomUUID();
        Book book = new Book(id, "Test Book", ZonedDateTime.now(), "Author", "Content");

        bookRepository.save(book);

        Book fetchedBook = bookRepository.findById(id);
        assertThat(fetchedBook).isNotNull();
        assertThat(fetchedBook.id()).isEqualTo(book.id());
        assertThat(fetchedBook.name()).isEqualTo(book.name());
        assertThat(fetchedBook.creationDate()).isEqualTo(book.creationDate());
        assertThat(fetchedBook.author()).isEqualTo(book.author());
        assertThat(fetchedBook.content()).isEqualTo(book.content());
    }
}

/*
 * This file is generated by jOOQ.
 */
package generated.public_.tables.records;


import generated.public_.tables.Books;

import java.time.OffsetDateTime;
import java.util.UUID;

import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class BooksRecord extends UpdatableRecordImpl<BooksRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.books.id</code>.
     */
    public void setId(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.books.id</code>.
     */
    public UUID getId() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.books.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.books.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.books.creation_date</code>.
     */
    public void setCreationDate(OffsetDateTime value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.books.creation_date</code>.
     */
    public OffsetDateTime getCreationDate() {
        return (OffsetDateTime) get(2);
    }

    /**
     * Setter for <code>public.books.author</code>.
     */
    public void setAuthor(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.books.author</code>.
     */
    public String getAuthor() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.books.content</code>.
     */
    public void setContent(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.books.content</code>.
     */
    public String getContent() {
        return (String) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<UUID> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached BooksRecord
     */
    public BooksRecord() {
        super(Books.BOOKS);
    }

    /**
     * Create a detached, initialised BooksRecord
     */
    public BooksRecord(UUID id, String name, OffsetDateTime creationDate, String author, String content) {
        super(Books.BOOKS);

        setId(id);
        setName(name);
        setCreationDate(creationDate);
        setAuthor(author);
        setContent(content);
        resetChangedOnNotNull();
    }
}

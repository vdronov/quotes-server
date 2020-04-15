package com.remoteseome.quotesserver.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 * @author Vasiliy Dronov
 */
public class Quote {

    /**
     * Id of the quote
     */
    private Long id;

    /**
     * Date of quote creation
     */
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date creationDate;


    /**
     * Author of the quote
     */
    private String author;

    /**
     * The quote itself
     */
    private String text;


    /**
     * Sets new Author of the quote.
     *
     * @param author New value of Author of the quote.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Sets new The quote itself.
     *
     * @param text New value of The quote itself.
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Sets new Date of quote creation.
     *
     * @param creationDate New value of Date of quote creation.
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Gets Author of the quote.
     *
     * @return Value of Author of the quote.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Gets Date of quote creation.
     *
     * @return Value of Date of quote creation.
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Sets new Id of the quote.
     *
     * @param id New value of Id of the quote.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets The quote itself.
     *
     * @return Value of The quote itself.
     */
    public String getText() {
        return text;
    }

    /**
     * Gets Id of the quote.
     *
     * @return Value of Id of the quote.
     */
    public Long getId() {
        return id;
    }
}

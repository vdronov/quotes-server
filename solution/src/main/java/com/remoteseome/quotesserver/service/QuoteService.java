package com.remoteseome.quotesserver.service;

import com.remoteseome.quotesserver.domain.Quote;
import com.remoteseome.quotesserver.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Vasiliy Dronov
 */
@Service
public class QuoteService {

    private Map<Long, Quote> storage = new LinkedHashMap<Long, Quote>();

    /**
     * Create new quote
     * @param newQuote new quote data
     * @return id of the created quote entity
     */
    public synchronized long addQuote(Quote newQuote){
        Long newId = System.currentTimeMillis();
        newQuote.setId(newId);
        newQuote.setCreationDate(new Date());
        storage.put(newId, newQuote);
        return newId;
    }

    /**
     * Delete quote by id
     * @param quoteId id of the quote
     */
    public synchronized void deleteQuote(long quoteId){
        validateExistance(quoteId);
        storage.remove(quoteId);
    }

    private void validateExistance(long quoteId) {
        if (!storage.containsKey(quoteId)){
            throw new NotFoundException("There is not quote with specified id");
        }
    }

    /**
     * Update quote by id
     * @param quoteId id of the quote to be updated
     * @param newQuote new quote data
     * @return updated version
     */
    public synchronized Quote update(long quoteId, Quote newQuote){
        validateExistance(quoteId);
        Quote quote = storage.get(quoteId);
        quote.setAuthor(newQuote.getAuthor());
        quote.setText(newQuote.getText());
        storage.put(quoteId, quote);
        return quote;
    }

    /**
     * Gets the quote by id
     * @param id id of the quote
     * @return related quote
     */
    public synchronized Quote get(long id){
        validateExistance(id);
        return storage.get(id);
    }

    /**
     * @return all values from storage
     */
    public List<Quote> getAll() {
        return new ArrayList<Quote>(storage.values());
    }
}

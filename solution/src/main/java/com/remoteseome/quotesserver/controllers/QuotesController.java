package com.remoteseome.quotesserver.controllers;

import com.remoteseome.quotesserver.domain.Quote;
import com.remoteseome.quotesserver.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Vasiliy Dronov
 */
@RestController
@RequestMapping(path = "/api/quotes")
public class QuotesController {

    @Autowired
    private QuoteService quoteService;

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public Long addQuote(@RequestBody Quote newQuote) {
        return quoteService.addQuote(newQuote);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public void deleteQuote(@PathVariable(name = "id") long quoteId) {
        quoteService.deleteQuote(quoteId);
    }


    @RequestMapping(method = RequestMethod.PUT, path = "/{id}",produces = "application/json")
    public Quote update(@PathVariable(name = "id") long quoteId, @RequestBody Quote newQuote) {
        return quoteService.update(quoteId, newQuote);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public Quote get(@PathVariable(name = "id") Long id) {
        return quoteService.get(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Quote> getAll(){
        return quoteService.getAll();
    }



}

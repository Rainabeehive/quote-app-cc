package edu.cmu.mis.iccfb.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import edu.cmu.mis.iccfb.model.Quote;

public interface QuoteService extends CrudRepository<Quote, Long>, QuoteServiceCustom {
//    List<Quote> findByName(String name);
    
   
        
    }



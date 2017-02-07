package edu.cmu.mis.iccfb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.cmu.mis.iccfb.model.Author;
import edu.cmu.mis.iccfb.model.Quote;
import edu.cmu.mis.iccfb.service.AuthorService;
import edu.cmu.mis.iccfb.service.QuoteService;

@Configuration
public class SeedData {

    @Autowired
    private AuthorService authorService;
    
    @Autowired
    private QuoteService quoteService;
    
    private static final Logger log = LoggerFactory.getLogger(SeedData.class);

    @Bean
    public SeedData getBean() {
        
        Author a1 = new Author("Douglas Adams");
        Author a2 = new Author("Gautama Buddha");
        Author a3 = new Author("Albert Einstein");
        
        authorService.save(a1);
        authorService.save(a2);
        authorService.save(a3);

        Quote q1 = new Quote(
                "The world is a thing of utter inordinate complexity and richness " +
                "and strangeness that is absolutely awesome",
                "https://en.wikiquote.org/wiki/Douglas_Adams", 
                a1);
        
        Quote q2 = new Quote(
                "As rain breaks through an ill-thatched house, passion will break through an unreflecting mind.", 
                "https://en.wikiquote.org/wiki/Gautama_Buddha", 
                a2);
        
        Quote q3 = new Quote(
                "I think that only daring speculation can lead us further and not accumulation of facts.", 
                "https://en.wikiquote.org/wiki/Albert_Einstein", 
                a3);
        
        quoteService.save(q1);
        quoteService.save(q2);
        quoteService.save(q3);
        
        log.info("Quoates found with findAll():");
        log.info("-------------------------------");
        for (Quote m : quoteService.findAll()) {
            log.info(m.toString());
        }
        return new SeedData();
    }
}

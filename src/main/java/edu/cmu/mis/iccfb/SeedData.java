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
        
        Author a1 = new Author("Eva Lettner");
        Author a2 = new Author("Isaac Asimov");
        Author a3 = new Author("Jeff Atwood");
        
        authorService.save(a1);
        authorService.save(a2);
        authorService.save(a3);

        Quote q1 = new Quote(
                "Being a developer means to be in the loop constantly, to learn, "
                + "to engage the people you meet at events, to experiment, "
                + "to build, to try, to fail, to fix and improve.",
                "https://hackernoon.com/being-a-junior-developer-at-30-38309f1daee8", a1);
        
        Quote q2 = new Quote(
                "The saddest aspect of life right now is that science gathers knowledge faster than society gathers wisdom.", 
                "https://medium.com/hi-my-name-is-jon/there-are-3-essential-elements-to-a-good-meeting-78ed1e186162", 
                a2);
        
        Quote q3 = new Quote(
                "Treat people who know less than you with respect, deference, and patience.", 
                "https://blog.codinghorror.com/the-ten-commandments-of-egoless-programming/", 
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

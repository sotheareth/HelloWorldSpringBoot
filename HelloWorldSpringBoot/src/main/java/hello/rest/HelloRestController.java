package hello.rest;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hello.annotation.ObjectToJsonConverter;
import hello.dto.ArticleDTO;
import hello.dto.PersonDTO;
import hello.service.ArticlesService;

@RestController
public class HelloRestController {
    
	public static Logger logger = LoggerFactory.getLogger(HelloRestController.class);
	
	@Autowired
	ArticlesService articlesServiceImpl;
	
    @RequestMapping("/")
    public String index() {
    	
    	logger.debug("welcome() is executed, value {}", "test");
		logger.error("This is Error message example", new Exception("Testing"));
		
        return "Greetings from Spring Boot2!";
    }
    
    @RequestMapping(value = "/getArticle")
    public ArticleDTO getArticle() {
    	
    	logger.info("start insert article");
    	Random random = new Random();
    	String text = "test" + random.nextInt(1000);
    	logger.info("random = " + text);
    	
    	ArticleDTO article = new ArticleDTO();
    	article.setTitle(text);
    	article.setAuthor(text);
    	ArticleDTO result = articlesServiceImpl.insertArticle(article);
    	logger.info("result = " + result);
    	
    	return result;
    }
    
    @RequestMapping(value = "/getPersonJson", produces = {MediaType.APPLICATION_JSON_VALUE} )
    public String getPersonJson() {
    	
    	logger.info("start get person json");
    	PersonDTO person = new PersonDTO("sotheareth", "ham", "37");
        ObjectToJsonConverter serializer = new ObjectToJsonConverter();
        String jsonString = serializer.convertToJson(person);
    	logger.info("result = " + person);
    	
    	return jsonString;
    }
    
}

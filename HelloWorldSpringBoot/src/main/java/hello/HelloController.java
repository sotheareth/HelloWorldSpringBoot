package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
	public static Logger logger = LoggerFactory.getLogger(HelloController.class);
	
    @RequestMapping("/")
    public String index() {
    	logger.debug("welcome() is executed, value {}", "test");

		logger.error("This is Error message example", new Exception("Testing"));
		
        return "Greetings from Spring Boot2!";
    }
}

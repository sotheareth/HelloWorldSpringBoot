package hello.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hello.dto.ArticleDTO;
import hello.service.ArticlesService;

@RestController
public class ArticleRestController {

	public static Logger logger = LoggerFactory.getLogger(ArticleRestController.class);
	
	@Autowired
	ArticlesService articlesServiceImpl;
	
	@RequestMapping(
			  value = "/insertArticle", 
			  produces = "application/json", 
			  method = {RequestMethod.POST})
    @ResponseBody
    public ArticleDTO insertArticle(@RequestBody ArticleDTO article) {
    	
    	logger.info("#################start insert article:" + article);
    	ArticleDTO result = articlesServiceImpl.insertArticle(article);
    	logger.info("result = " + result);
    	
    	return result;
    }
    
}

package hello.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SessionController {
	
	@RequestMapping(value ="/greeting",  method = { RequestMethod.GET, RequestMethod.POST })
	@SuppressWarnings("unchecked")
    public String greeting(@RequestParam(value="bookName", required = false) String bookName, HttpServletRequest request) {
		
		List<String> listOfBooks = (List<String>) request.getSession().getAttribute("Books");
		if (listOfBooks == null) {
            listOfBooks = new ArrayList<String>();
            request.getSession().setAttribute("Books", listOfBooks);
        }
		if(bookName != null) {
			listOfBooks.add(bookName);
            request.getSession().setAttribute("Books", listOfBooks);
		}
        return "greeting";
        
    }
    
    @RequestMapping("/session")
    public String session() {
        return "session";
    }
    
    @RequestMapping("/article")
    public String article() {
    	
        return "article";
    }
    
}

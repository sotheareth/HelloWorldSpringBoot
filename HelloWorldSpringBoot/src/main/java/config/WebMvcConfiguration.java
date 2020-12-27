package config;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter implements EnvironmentAware {
	
	private Environment propertyResolver;

	/**
	 * Thymeleaf template engine
	 * @return
	 */
	@Bean
	public SpringTemplateEngine templateEngine() {
	    SpringTemplateEngine templateEngine = new SpringTemplateEngine();
	    templateEngine.addTemplateResolver(templateResolver());
	    return templateEngine;
	}

	
	/**
	 * View template resolver
	 * @return
	 */
	private ITemplateResolver templateResolver() {
		ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
	    templateResolver.setPrefix("templates/mail/");
	    templateResolver.setTemplateMode("HTML");
	    templateResolver.setSuffix(".html");
	    templateResolver.setOrder(1);
	    return templateResolver;
	}

	@Override
	public void setEnvironment(Environment environment) {
		propertyResolver = environment;
	}
	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

	    //set path extension to true
	    configurer.favorPathExtension(true).
	    //set favor parameter to false
	    favorParameter(false).
	    //ignore the accept headers
	    ignoreAcceptHeader(true).
	    //dont use Java Activation Framework since we are manually specifying the mediatypes required below
	    useJaf(false).
	    defaultContentType(MediaType.APPLICATION_JSON).
	    mediaType("xml", MediaType.APPLICATION_XML).
	    mediaType("json", MediaType.APPLICATION_JSON);
	  }

}

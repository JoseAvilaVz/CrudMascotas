package mex.com.curso.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Configuration
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer{
	
	@Override
	protected Class<?>[] getRootConfigClasses(){
		return new Class <?>[] {RootConfig.class};
		
	}
	
	@Override
	protected Class<?>[] getServletConfigClasses(){
		return new Class <?>[] {WebConfig.class};
	}
	
	@Override
	protected String[] getServletMappings(){
		return new String[] {"/"}; // Sirve para indicar que todo lo que este despues del contexto con "/"
	}
}

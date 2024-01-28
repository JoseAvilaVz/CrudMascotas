package mex.com.curso.Config;


// Esta es la primera clase que se inicializa al levantarse el proyecto!!!!


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.WebApplicationInitializer;
 

public class SpringWebAppInitializer implements WebApplicationInitializer {
	

	public void onStartup(ServletContext servletContext) throws ServletException {
		 AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
	        appContext.register(ApplicationContextConfig.class);
	        
	        ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
	                "SpringDispatcher", new DispatcherServlet(appContext));
	        dispatcher.setLoadOnStartup(1);
	        dispatcher.addMapping("/");
	}

}

package mex.com.curso.Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.context.annotation.FilterType;


@Configuration//Anotacion para indicar que esta clase es de configuracion
@ComponentScan(basePackages= {"mex.com.curso"},
excludeFilters = {
		@ComponentScan.Filter(type= FilterType.ANNOTATION, value= EnableWebMvc.class)	
})//FILTRO PARA SPRING TOME AQUELLAS CLASES QUE LLEVEN ANOTACIONES O LA ANOTACION @EnableWebMvc
public class RootConfig {

}

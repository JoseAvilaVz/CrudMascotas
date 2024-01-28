package mex.com.curso.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//anotaciones o estereotipos
@Configuration //IDENTIFICA QUE NUESTRA CLASE ES DE TIPO CONFIGURACION
@EnableWebMvc //HABILITAR LA PARTE WEB MVC = MODELO VISTA CONTROLADOR
@ComponentScan("mex.com.curso") //SIRVE PARA INDICARLE A SPRING QUE SOBRE ESE
//PAQUETE VA A BUSCAR AQUELLAS CLASES QUE NOSOTROS HAYAMOS
//AFILIADO/INTEGRADO A SPRING CON LAS ANOTACIONES
public class WebConfig {
	
	@Bean
	public InternalResourceViewResolver resolver() {
		InternalResourceViewResolver resol = new InternalResourceViewResolver();
		resol.setPrefix("/WEB-INF/Views/");
		resol.setPrefix(".jsp");
		return resol;
		
	}
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry
		.addResourceHandler("/resources/**")
		.addResourceLocations("classpath:/resources/");
	}

}

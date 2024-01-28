package mex.com.curso.Config;


import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource(value = {"classpath:/properties/CONEXIONES.properties"})
public class DataBaseConfig {
	
	@Autowired
	private Environment environment;
	
	
	@Bean(name="dataSource")  //nuestra conexion a base de datos
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getRequiredProperty("DB_ORCL_DRIVER"));
		dataSource.setUrl(environment.getRequiredProperty("DB_LOCAL_ORCL_URL"));
		dataSource.setUsername(environment.getRequiredProperty("DB_LOCAL_ORCL_USERNAME"));
		dataSource.setPassword(environment.getRequiredProperty("DB_LOCAL_ORCL_PASSWORD"));
		return dataSource;
		
	}
	
	
	//JDBC TEMPLATE ES LA HERRAMINETA QUE NOS VA A PERMITIR HACER CONSULTAS EN LA BASE DE DATOS
	// INDICANDOLE HACIA QUE BASE DE DATOS VA A COPNSULTAR
	
	@Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();  
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }
}
	
	


package com.bolsadeideas.springboot.app;

import java.util.Locale;

import org.springframework.context.annotation.Bean;

// import java.nio.file.Paths;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class MvcConfig implements WebMvcConfigurer { // registramos otro directorio como recurso estatico de nuestro proyecto
	
	/*private final Logger log = LoggerFactory.getLogger(getClass());

	@Override
	//public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		// WebMvcConfigurer.super.addResourceHandlers(registry);

		String resourcePath = Paths.get("uploads").toAbsolutePath().toUri().toString(); // toUri lo que hace es agregar el esquema "file" con la ruta abosluta
		log.info(resourcePath);
		
		registry.addResourceHandler("/uploads/**") // hemos creado la carpeta uploads en la raiz de nuestro proyecto
		.addResourceLocations(resourcePath);
		*/
		
		public void addViewControllers(ViewControllerRegistry registry) {
			registry.addViewController("/error_403").setViewName("error_403"); // registra una ruta y asocia a una vista específica. 
		}
		
		@Bean
		public static BCryptPasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder(); // escripta cualquier password
		}
		
		@Bean
		public LocaleResolver localeResolver() {
			SessionLocaleResolver localeResolver = new SessionLocaleResolver(); // para resolver el locale (idioma y región) utilizado en la aplicación. En este caso, se crea una instancia de SessionLocaleResolver y se establece el locale predeterminado como "es_ES" (español de España).
			localeResolver.setDefaultLocale(new Locale("es", "ES"));
			return localeResolver;
		}
		
		@Bean
		public LocaleChangeInterceptor localeChangeInterceptor() { // Este método configura el LocaleChangeInterceptor. Se establece el nombre del parámetro de solicitud utilizado para cambiar el locale como "lang".
			LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
			localeInterceptor.setParamName("lang");
			return localeInterceptor;
		}

		@Override
		public void addInterceptors(InterceptorRegistry registry) { // Este método agrega el LocaleChangeInterceptor al registro de interceptores. Cuando se recibe una solicitud, este interceptor buscará el parámetro "lang" y cambiará el locale de acuerdo a su valor.
			// TODO Auto-generated method stub
			registry.addInterceptor(localeChangeInterceptor());
		}
		
		
	}
	
	

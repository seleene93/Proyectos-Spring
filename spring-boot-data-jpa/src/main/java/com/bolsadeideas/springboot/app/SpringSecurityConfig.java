package com.bolsadeideas.springboot.app;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.bolsadeideas.springboot.app.auth.handler.LoginSuccessHandler;
import com.bolsadeideas.springboot.app.models.service.JpaUserDetailsService;

@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled =  true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private LoginSuccessHandler successHandler; // creamos la instancia para pasarla al método successHandler() más abajo
	
	@Autowired
	private DataSource dataSource; // para conexión a la base de datos
	
	@Autowired
	private JpaUserDetailsService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception { // configuramos las rutas privadas o públicas por el rol
		// TODO Auto-generated method stub
		http.authorizeRequests().antMatchers("/", "/css/**", "/js/**", "/images/**", "/listar**", "/locale", "/api/clientes/**").permitAll()
		// .antMatchers("/ver/**").hasAnyRole("USER")
		// .antMatchers("/uploads/**").hasAnyRole("USER") // VAMOS A REEMPLAZARLAS POR ANOTACIONES @Secured("ROLE_USER/ADMIN"), @PreAuthorize("hasRole('ROLE_USER/ADMIN')")
		// .antMatchers("/form/**").hasAnyRole("ADMIN")
		// .antMatchers("/eliminar/**").hasAnyRole("ADMIN")
		// .antMatchers("/factura/**").hasAnyRole("ADMIN")
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.successHandler(successHandler)
		.loginPage("/login")
		.permitAll()
		.and()
		.logout().permitAll()
		.and().exceptionHandling().accessDeniedPage("/error_403");
	}

	

	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception{
		
		build.userDetailsService(userDetailsService)
		.passwordEncoder(passwordEncoder);
		
		
		/* build.jdbcAuthentication()
		.dataSource(dataSource) // Establece el origen de datos para acceder a la base de datos y realizar consultas relacionadas con la autenticación.
		.passwordEncoder(passwordEncoder) // Establece el codificador de contraseñas que se utilizará para cifrar y comparar las contraseñas almacenadas en la base de datos.
		.usersByUsernameQuery("select username, password, enabled from users where username=?")
		.authoritiesByUsernameQuery("select u.username, a.authority from authorities a inner join users u on (a.user_id=u.id) where u.username=?");
		*/
		
		
		/*PasswordEncoder encoder = this.passwordEncoder;
		UserBuilder users = User.builder().passwordEncoder(encoder::encode); // encriptamos la contraseña, "::" obtiene el arg(password) de encoder y se la pasa al metodo encode
		
		builder.inMemoryAuthentication()
		.withUser(users.username("admin").password("12345").roles("ADMIN", "USER"))
		.withUser(users.username("andres").password("12345").roles("USER"));
		*/
		
		
		
		
}
}
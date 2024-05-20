package com.salesianostriana.dam.proyectoalvarolorentealman.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import com.salesianostriana.dam.proyectoalvarolorentealman.model.User;
import com.salesianostriana.dam.proyectoalvarolorentealman.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableMethodSecurity
public class SecurityConfiguration {
	/*
	 * para por acceder a la bd se us a el userService, en el bean se crea un
	 * builder para que sepueda recuperar llama al
	 */
	@Autowired
	UserService userService;

	/*para configurar los filtros de seguridad
	 * 
	 * damos permiso a los endspoints para que permita todo
	 * al estar todos en permitAll
	 * 
	 * // Configura la cadena de filtros de seguridad
	 * */
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				requests -> requests.requestMatchers("/h2-console/**", "/css/**", "/js/**", "/img/**").permitAll()
						.requestMatchers("/", "/index", "/login", "/register").permitAll()
						.requestMatchers("/deliveries/**", "/users/**", "/invoices/**", "/reports/**", "/comments/**").permitAll()
						.anyRequest().authenticated())
		/**/
			.formLogin(login -> login
						.loginPage("/login")
						.defaultSuccessUrl("/dashboard", true)
						.failureHandler(customAuthenticationFailureHandler())
						.permitAll())
			.logout(logout -> logout.permitAll());
		http.headers(headers -> headers.disable());
		http.csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"));
		return http.build();
	}
	/*
	 * evita que se cree un usuario por defecto ya que los usuarios que tienen
	 * permisos son los que estan en la bbdd Configrua nuestra bbdd de usuarios como
	 * fuente de autenticacion la de user porque se está accedieno a traves del user
	 * service
	 * 
	 * por lo que hay que tener usuarios creados
	 * 
	 * Con springwebSecurity puedo acceder a los usuarios creados
	 * 
	 * Configura el servicio de detalles del usuario
	 */
	@Bean
	public UserDetailsService userDetailsService() {
		return username -> {
			User user = this.userService.getUserByUsername(username);
			UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(user.getUsername());
			builder.password("{noop}" + user.getPassword());
			builder.authorities(user.getRole().toString());
			return builder.build();
		};
	}
	
	// Maneja fallos de autenticación redirigiendo a la página de login con un mensaje de error
	@Bean
	public AuthenticationFailureHandler customAuthenticationFailureHandler() {
		return new SimpleUrlAuthenticationFailureHandler() {
			@Override
			public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
					AuthenticationException exception) throws IOException, ServletException {
				setDefaultFailureUrl("/login?error=true");
				super.onAuthenticationFailure(request, response, exception);
			}
		};
	}
}

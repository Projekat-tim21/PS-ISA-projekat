package rs.ac.uns.ftn.informatika.jpa.config;

import org.aspectj.weaver.ast.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("user")
//				.password("password").roles("USER");
//	}
	
	@Bean("authenticationManager")
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception{
		
		return super.authenticationManagerBean();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication().withUser("user")
			.password("password").roles("USER");
		
	}
//	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests().antMatchers("/").permitAll()
			.antMatchers("/login").permitAll()
			.antMatchers("/registracija").permitAll()
			//.antMatchers("/lekarPage").hasRole("DOKTOR")
			.anyRequest()
			.authenticated()
			.and()
			.logout().deleteCookies("JSESSIONID");
		http.csrf().disable();
			//.and()
			/*.formLogin().loginPage("/login.jsp")
			.failureUrl("/login.jsp?error=1").loginProcessingUrl("/login")
			.permitAll().and().logout()
			.logoutSuccessUrl("/listEmployees.html");*/
	}

}

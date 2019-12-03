package rs.ac.uns.ftn.informatika.jpa.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import rs.ac.uns.ftn.informatika.jpa.model.Role;
import rs.ac.uns.ftn.informatika.jpa.service.CustomUserDetailsService;


@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = CustomUserDetailsService.class)
@AutoConfigureWebMvc
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean(name = "passwordEncoder")
	public PasswordEncoder passwordencoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordencoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			/*.authorizeRequests()
			.antMatchers("/console/**").permitAll()
			.antMatchers("/", "/addNewUser").authenticated()
			.antMatchers("/getAllUser/**", "/removeAll/**").hasAuthority(Role.ADMIN.name())
			.antMatchers("/removeAll/**", "/addNewUser/**", "/save/**", "/register/**", "/delete/**", "/page/**", "/pokazikorisnikaSaLogina/**", "/pokazi-korisnika2/**").hasAuthority(Role.ADMIN.name())
			.anyRequest().permitAll()
			.and()
				.formLogin().loginPage("/login")
				.defaultSuccessUrl("/")
				.usernameParameter("username")
				.passwordParameter("password")
			.and()
				.logout().logoutSuccessUrl("/login")
			.and()
				.exceptionHandling().accessDeniedPage("/403")
			.and()
				.csrf().disable();*/
		
		.authorizeRequests().antMatchers("/").permitAll()
		.antMatchers("/login").permitAll()
		.antMatchers("/registracija").permitAll()
		.antMatchers("/login-user").permitAll()
		.antMatchers("/pokazi-korisnika").hasAuthority(Role.ADMIN.name())
		.antMatchers("/pregledSvihPacijenataMetoda").permitAll()
		.antMatchers("/sacuvaj").permitAll()
		.antMatchers("/error").permitAll()
		.antMatchers("/ispravka").permitAll()
		.antMatchers("/loginBezDobrodosli").permitAll()
		.antMatchers("/pocetna_stranica").permitAll()
		.antMatchers("/profilkaPregledu").permitAll()
		.antMatchers("/pregledUseraSaLogina").permitAll()
		.antMatchers("/uspesnaIzmenaInfo").permitAll()
		.antMatchers("/welcomepage").permitAll()
		.antMatchers("/izmenaPodataka").permitAll()
		.antMatchers("/profilnaBezDob").permitAll()
		.antMatchers("/vratiSeNaPocetnu").permitAll()
		.antMatchers("/profil").permitAll()
		.antMatchers("/izmenaPodatakaizBara").permitAll()
		.antMatchers("/profilkaPregledu").permitAll()
		.antMatchers("/idiNaLoginBezDobrodosli").permitAll()
		.antMatchers("/izmenaPodataka").permitAll()
		.antMatchers("/edit-user").permitAll()
		.antMatchers("/sacuvajupdateNaLogin").permitAll()
		.antMatchers("/sacuvajupdate").permitAll()
		.antMatchers( "/edit/{userId}").permitAll()
		.antMatchers("/pregledSvihPacijenataMetoda").permitAll()
		.antMatchers("/pokazikorisnikaSaLogina").permitAll()
		.antMatchers("/pokazi-korisnika2").permitAll()
		.antMatchers("/pokazi-korisnika").permitAll()
		.antMatchers("/sacuvaj").permitAll()
		.antMatchers("/logout").permitAll()
		.antMatchers("/prikazOsnovnihInfo").permitAll()
		.antMatchers("/listaSvihKlinika").permitAll()
		.antMatchers("/preglediIoperacijePrikaz").permitAll()
		.antMatchers("/prikaziListuPregleda").permitAll()
		.antMatchers("/prikaziListuOperacija").permitAll()
		.antMatchers("/naLogin").permitAll()
		.antMatchers("/korakUnazadNaLogin").permitAll()
		.antMatchers("/kartonZ").permitAll()
		
		
		
		.anyRequest()
		.authenticated();
		http.csrf().disable();
		
		http.sessionManagement()
				.maximumSessions(1)
				.maxSessionsPreventsLogin(true)
				.expiredUrl("/login?error=You are already logged in from somewhere");
	}

	@Bean
	public ServletListenerRegistrationBean<HttpSessionEventPublisher> httpSessionEventPublisher() {
		return new ServletListenerRegistrationBean<HttpSessionEventPublisher>(new HttpSessionEventPublisher());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}

}
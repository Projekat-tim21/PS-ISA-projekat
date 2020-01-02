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
			.antMatchers("/", "/sacuvaj").authenticated()
			.antMatchers("/pokazikorisnikaSaLogina/**").hasAuthority(Role.PACIJENT.name())
			//.antMatchers("/removeAll/**", "/addNewUser/**", "/save/**", "/register/**").hasAuthority(Role.PACIJENT.name())
			.anyRequest().permitAll()
		//	.and()
				//.formLogin().loginPage("/login")
				//.defaultSuccessUrl("/")
				//.usernameParameter("username")
				//.passwordParameter("password")
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
		.antMatchers("/oceniKlinikuPregled").permitAll()
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
		.antMatchers("/zahteviRegistrovanje").permitAll()
		.antMatchers("/lekovi").permitAll()
		.antMatchers("/klinike").permitAll()
		.antMatchers("/adminiKlinike").permitAll()
		.antMatchers("/dijagnoze").permitAll()
		.antMatchers("/editpassword").permitAll()
		.antMatchers("/firstLogin/*").permitAll()
		.antMatchers("/addNewLek").permitAll()
		.antMatchers("/noviLek").permitAll()
		.antMatchers("/delete/*").permitAll()
		.antMatchers("/saveLek").permitAll()
		.antMatchers("/update").permitAll()
		.antMatchers("/addNewDijagnoza").permitAll()
		.antMatchers("/novaDijagnoza").permitAll()
		.antMatchers("/deleteDijagnoza/*").permitAll()
		.antMatchers("/saveDijagnoza").permitAll()
		.antMatchers("/pregledSvihAdmina").permitAll()
		.antMatchers("/addNewAdminKC").permitAll()
		.antMatchers("/noviAdminKC").permitAll()
		.antMatchers("/disable/*").permitAll()
		.antMatchers("/disable2/*").permitAll()
		.antMatchers("/disable3/*").permitAll()
		.antMatchers("/enable/*").permitAll()
		.antMatchers("/enable2/*").permitAll()
		.antMatchers("/enable3/*").permitAll()
		.antMatchers("/sviIzBaze").permitAll()
		.antMatchers("/oceniKlinikuOperacija").permitAll()
		.antMatchers("/preglediIoperacijePrikaz").permitAll()
		.antMatchers("/prikaziListuPregleda").permitAll()
		.antMatchers("/prikaziListuOperacija").permitAll()
		.antMatchers("/naLogin").permitAll()
		.antMatchers("/korakUnazadNaLogin").permitAll()
		.antMatchers("/kartonZ").permitAll()	
		.antMatchers("/admin").permitAll()	
		.antMatchers("/sacuvajNovaLozinka").permitAll()
		.antMatchers("/radniKalendar").permitAll()
		.antMatchers("/kartonZ").permitAll()
		.antMatchers("/zakazivanjePregledaOdobreno").permitAll()
		.antMatchers("/prikaziListuLekara").permitAll()
		.antMatchers("/AdminPraviPreglede").permitAll()
		.antMatchers("/kreirajPregledZaLekara").permitAll()
		.antMatchers("/vratiSe").permitAll()
		.antMatchers("/sacuvajTermine2").permitAll()
		.antMatchers("/test").permitAll()
		.antMatchers("/listaSvihTermina").permitAll()
		.antMatchers("/listaSvihTerminaPacijent").permitAll()
		.antMatchers("/pregledSvihAdminaKlinike").permitAll()
		.antMatchers("/addNewAdminKlinike").permitAll()
		.antMatchers("/noviAdminKlinike").permitAll()
		.antMatchers("/addNewKlinika").permitAll()
		.antMatchers("/novaKlinika").permitAll()
		.antMatchers("/medSestraPoc").permitAll()
		.antMatchers("/sviSestraPacijenti").permitAll()
		.antMatchers("/vidijos/*").permitAll()
		.antMatchers("/razlogOdbijanja/*").permitAll()
		.antMatchers("/ocenaLekaraPregled/*/*/*").permitAll()
		.antMatchers("/ocenaKlinikeOperacija/*/*/*").permitAll()
		.antMatchers("/ocenaLekaraOperacije/*/*/*").permitAll()
		.antMatchers("/ocenaKlinikePregled/*/*/*").permitAll()
		.antMatchers("/zakaziPregledKojiJeDef").permitAll()
		.antMatchers("/pretragaSale").permitAll()
		.antMatchers("/lekarStranica").permitAll()
		.antMatchers("/prikazKalendaraSala").permitAll()
		.antMatchers("/zakazivanjePregledaIzaListeLekara").permitAll()
		.antMatchers("/radniKalendar").permitAll()
		.antMatchers("/pretragaSale").permitAll()
		.antMatchers("/lekarStranica").permitAll()
		.antMatchers("/prikazKalendaraSala").permitAll()
		.antMatchers("/getCalendar").permitAll()
		.antMatchers("/zakazivanjePregledaIzaListeLekara").permitAll()
		.antMatchers("/zapocniOperacijeP").permitAll()
		.antMatchers("/listaSvihDefinisanihPregledaZaLekara").permitAll()
		.antMatchers("/uspesnoZakazanPregled").permitAll()
		.antMatchers("/vratiSeNaLoginBezDobrodosli2").permitAll()
		.antMatchers("/saljemoZahtevZaPregledom").permitAll()
		.antMatchers("/oceniLekaraPregled").permitAll()
		.antMatchers("/listaZakazanihPregleda").permitAll()
		.antMatchers("/kartonZ").permitAll()	
		.antMatchers("/admin").permitAll()	
		.antMatchers("/sacuvajNovaLozinka").permitAll()
		.antMatchers("/posaljiZahtevZaPregledom").permitAll()
		.antMatchers("/zahteviZaPregledom").permitAll()
		.antMatchers("/rezervacija").permitAll()
		.antMatchers("/profilPacijenta").permitAll()
	    .antMatchers("/zKartonLekar").permitAll()
	    .antMatchers("/naPocetnu").permitAll()
	    .antMatchers("/razlogOdbijanjaPregleda").permitAll()
	    .antMatchers("/zapocniPregled").permitAll()
	    .antMatchers("/naPregled").permitAll()
	    .antMatchers("/naPregledSala").permitAll()
	    .antMatchers("/zakaziPregledNovi").permitAll()
	    .antMatchers("/razlogOdbijanjaPregleda/*").permitAll()
	    .antMatchers("/getCalendar/*").permitAll()
	    .antMatchers("/radniKalendar/*").permitAll()
	    .antMatchers("/zapocniOperacijeP").permitAll()
	    .antMatchers("/odobreniZahteviKodPacijenta").permitAll()
	    .antMatchers("/idiNaLoginPoslePotvrde").permitAll()
	    .antMatchers("/oceniLekaraOperacija").permitAll()
	    .antMatchers("/lekariUKlinici").permitAll()
	    .antMatchers("/terminiUKlinici").permitAll()
	    .antMatchers("/korakUnazadNaListuKlinika").permitAll()
	    .antMatchers("/pregled").permitAll()
	    .antMatchers("/korakUnazadNaLisuLekara").permitAll()

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
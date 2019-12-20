package rs.ac.uns.ftn.informatika.jpa.service;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.sun.xml.fastinfoset.sax.Properties;

import rs.ac.uns.ftn.informatika.jpa.model.Korisnik;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	/*
	 * Koriscenje klase za ocitavanje vrednosti iz application.properties fajla
	 */
	@Autowired
	private Environment env;

	/*
	 * Anotacija za oznacavanje asinhronog zadatka
	 * Vise informacija na: https://docs.spring.io/spring/docs/current/spring-framework-reference/integration.html#scheduling
	 */
	
	public void sendNotificaitionSync(Korisnik user) throws MailException, InterruptedException {

		//Simulacija duze aktivnosti da bi se uocila razlika
		//Thread.sleep(10000);
		System.out.println("Slanje emaila...");

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Uspesno ste izmenili svoje informacije");
		mail.setText("Pozdrav " + user.getIme() + ",\n\nUspesno ste izmenili svoje informacije.");
		javaMailSender.send(mail);

		System.out.println("Email poslat!");
	}

	public void sendNotificaitionZaRegistraciju(Korisnik k) throws MailException, InterruptedException {

		System.out.println("Slanje emaila na register...");

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(k.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Uspesno ste se registrovali");
		mail.setText("Pozdrav " + k.getIme() + ",\n\nUspesno ste se registrovali.");
		javaMailSender.send(mail);

		System.out.println("Email poslat!");
	}
	
	
	
	public void sendNotificaitionZaZakazanePreglede(Korisnik k) throws MailException, InterruptedException {

		System.out.println("Slanje emaila za zakazane preglede...");

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(k.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Uspesno ste zakazali pregled");
		mail.setText("Pozdrav " + k.getIme() + ",\n\nUspesno ste zakzali pregled.");
		javaMailSender.send(mail);

		System.out.println("Email poslat!");
	}
	
	
	
	
	public void sendNotificaitionZaAdminaKC(Korisnik k) throws MailException, InterruptedException {

		System.out.println("Slanje emaila za admina kc");

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(k.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Administrator KC");
		mail.setText("Pozdrav " + k.getIme() + ",\n\nPostavljeni ste za administratora klinickog centra.");
		javaMailSender.send(mail);

		System.out.println("Email poslat!");
	}
	
	
	
	public void sendNotificaitionOdobrenTermin(Korisnik k ) throws MailException, InterruptedException {

		
		System.out.println("Slanje email potvrda zahteva za pregledom");
		//String link = "<a href=\"/logout\">Odjavi se</a>";
		//String confirmationUrl = "/registrationConfirm?token=" + k.getId();

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(k.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Administrator KC");
		mail.setText("Pozdrav " + k.getIme() + ",\n\nVas zahtev za pregledom je potvrdjen");
		//mail.setText(link);
		javaMailSender.send(mail);

		System.out.println("Email poslat!");
	}
	
	public void slanjePorukeAdminuOZahtevuZaPregledom(Korisnik k) throws MailException, InterruptedException {

		System.out.println("Slanje adminu zahteva za pregledom");

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(k.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Klinicki centar");
		mail.setText("Pozdrav " + ",\n\nNa mail Vam je prosledjen zahtev za pregledom od strane pacijenta");
		javaMailSender.send(mail);

		System.out.println("Email poslat!");
	}
	
	
	public void sendNotificaitionOdobrenaRegistracija(Korisnik k) throws MailException, InterruptedException {

		System.out.println("Slanje email potvrde registracije");

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(k.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Administrator KC");
		mail.setText("Pozdrav " + k.getIme() + ",\n\nVasa registracija je potvrdjena");
		javaMailSender.send(mail);

		System.out.println("Email poslat!");
	}
	
	public void sendNotificaitionOdbijenaRegistracija(Korisnik k) throws MailException, InterruptedException {

		System.out.println("Slanje email potvrde registracije");

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(k.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Administrator KC");
		mail.setText("Pozdrav " + k.getIme() + ",\n\nVasa registracija je odbijena");
		javaMailSender.send(mail);

		System.out.println("Email poslat!");
	}

	public void sendNotificaitionZaAdminaKlinike(Korisnik k) {
		// TODO Auto-generated method stub
		System.out.println("Slanje emaila za admina kc");

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(k.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Administrator Klinike");
		mail.setText("Pozdrav " + k.getIme() + ",\n\nPostavljeni ste za administratora klinike.");
		javaMailSender.send(mail);

		System.out.println("Email poslat!");
		
	}

	public void sendNotificaitionRazlogOdbijanja(Korisnik k, String s) {
		// TODO Auto-generated method stub
		System.out.println("Slanje email odbijanje registacije" + k.getIme() + s);

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(k.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Odbijanje registracije");
		mail.setText("Pozdrav " + k.getIme() + "  "+ s);
		javaMailSender.send(mail);

		System.out.println("Email poslat!");
		
	}

	public void sendNotificaitionRazlogOdbijanjaTermina(Korisnik k, String s) {
		// TODO Auto-generated method stub
		System.out.println("Slanje email odbijanje termina" + k.getIme() + s);

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(k.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Odbijanje zahteva za pregled");
		mail.setText("Pozdrav " + k.getIme() + "  " + "Vas zahtev za pregledom je odbijen zbog: "     + s);
		javaMailSender.send(mail);

		System.out.println("Email poslat!");
		
	}
	
}

package rs.ac.uns.ftn.informatika.jpa;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import rs.ac.uns.ftn.informatika.jpa.model.Korisnik;
import rs.ac.uns.ftn.informatika.jpa.model.Role;
import rs.ac.uns.ftn.informatika.jpa.service.KorisnikService;

@Component
public class InitialSetup {
/*
	@Autowired
    private KorisnikService userService;

    @Value("${admin.first.name}")
    private String firstName;

    @Value("${admin.last.name}")
    private String lastName;

    @Value("${admin.email.address}")
    private String emailAddress;

    @Value("${admin.password}")
    private String password;
    
    @Value("${admin.username}")
    private String username;


    @PostConstruct
    public void initIt() throws Exception {

        Korisnik dbUser = userService.findByUsername(username);

        if (dbUser == null) {
            Korisnik user = new Korisnik();
            user.setIme(firstName); 
            user.setPrezime(lastName);
            user.setEmail(emailAddress);
            user.setPassword(password);
            user.setIsActive(Boolean.TRUE);
            user.setRoleName(Role.ADMIN.name());
            userService.saveMogKorisnika(user);
        }
       // loadUsers();
    }*/
}

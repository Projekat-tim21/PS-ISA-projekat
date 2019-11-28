package rs.ac.uns.ftn.informatika.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.Korisnik;
import rs.ac.uns.ftn.informatika.jpa.model.KorisnikAdapter;
import rs.ac.uns.ftn.informatika.jpa.repository.KorisnikRepository;


@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
	
	private final KorisnikRepository userRepository;

	@Autowired
	public CustomUserDetailsService(KorisnikRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Korisnik user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(String.format("User with %s doesn't exist!", username));
		}
		return new KorisnikAdapter(user);
	}

	public Korisnik saveUser(Korisnik user) {
		return userRepository.save(user);
	}
}

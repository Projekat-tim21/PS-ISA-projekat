package rs.ac.uns.ftn.informatika.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.informatika.jpa.model.Korisnik;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {


	public Korisnik findByUsernameAndPassword(String username, String password);

	public Korisnik findByUsername(String username);

	public Korisnik findOneById(Long id);

	
	
	

}

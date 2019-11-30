package rs.ac.uns.ftn.informatika.jpa.repository;

import java.util.List;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.informatika.jpa.model.Korisnik;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {


	public Korisnik findByUsernameAndPassword(String username, String password);

	public Korisnik findByUsername(String username);

	public Korisnik findOneById(Long id);


	public List<Korisnik> findByRoleName(String roleName);

	public Optional<Korisnik> findById(Long id);

	//public Korisnik findById(Long id);

	
	//public Korisnik findAllData(Long id, String username, String ime, String prezime, String jedBrOsig, String email, String adresa, String grad, String drzava, String telefon, String password);

	
	
	

}

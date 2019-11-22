package rs.ac.uns.ftn.informatika.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import rs.ac.uns.ftn.informatika.jpa.model.Korisnik;

public interface KorisnikRepository extends CrudRepository<Korisnik, Integer> {

	public Korisnik findByUsernameAndPassword(String username, String password);

	public Korisnik findByUsername(String username);

}

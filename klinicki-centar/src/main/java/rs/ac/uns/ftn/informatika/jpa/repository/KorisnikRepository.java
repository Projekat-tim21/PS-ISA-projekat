package rs.ac.uns.ftn.informatika.jpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rs.ac.uns.ftn.informatika.jpa.model.Korisnik;
import rs.ac.uns.ftn.informatika.jpa.model.LekarIPregledi;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {


	public Korisnik findByUsernameAndPassword(String username, String password);

	public Korisnik findByUsername(String username);

	public Korisnik findOneById(Long id);


	public List<Korisnik> findByRoleName(String roleName);

	public Optional<Korisnik> findById(Long id);
	
	@Query("SELECT t FROM Korisnik t WHERE " +
            "LOWER(t.ime) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR " +
            "LOWER(t.prezime) LIKE LOWER(CONCAT('%',:searchTerm, '%'))")
    Page<Korisnik> searchByTerm(@Param("searchTerm") String searchTerm, Pageable pageable);

	

	 //Page<Korisnik> listUsers(Pageable pageable);

	//public Korisnik findById(Long id);

	
	//public Korisnik findAllData(Long id, String username, String ime, String prezime, String jedBrOsig, String email, String adresa, String grad, String drzava, String telefon, String password);

	
	
	

}

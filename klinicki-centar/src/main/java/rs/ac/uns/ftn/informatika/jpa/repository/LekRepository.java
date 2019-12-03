package rs.ac.uns.ftn.informatika.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.informatika.jpa.model.Lek;

public interface LekRepository extends JpaRepository<Lek, Long> {

	public Lek findBySifra(String sifra);
	public Lek findByNaziv(String naziv);
	public Lek findOneById(Long id);
}

package rs.ac.uns.ftn.informatika.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.informatika.jpa.model.Sala;


public interface SalaRepository extends JpaRepository<Sala, Long> {
	
	public Sala findOneById(Long id);
	public List<Sala> findByRezervisana(boolean s);
	public List<Sala> findByDatum(String datum);
	public List<Sala> findByNaziv(String naziv);

}

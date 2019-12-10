package rs.ac.uns.ftn.informatika.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.informatika.jpa.model.Korisnik;
import rs.ac.uns.ftn.informatika.jpa.model.TerminiSaId;

public interface TerminSaIdRepository extends JpaRepository<TerminiSaId, Long> {

	
	public List<TerminiSaId> findByLekarId(Long lekarId);
	
}

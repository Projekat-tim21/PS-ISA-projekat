package rs.ac.uns.ftn.informatika.jpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.informatika.jpa.model.Korisnik;
import rs.ac.uns.ftn.informatika.jpa.model.Operacija;
import rs.ac.uns.ftn.informatika.jpa.model.TerminiSaId;

public interface TerminSaIdRepository extends JpaRepository<TerminiSaId, Long> {

	
	public List<TerminiSaId> findByLekarId(Long lekarId);

	public List<TerminiSaId> findByZakazan(boolean b);

	public TerminiSaId findByTermin(String termin);

	public List<TerminiSaId> findByOdobrenpregled(boolean odobren);
	public List<TerminiSaId> findByKorisnikId(Long id);
	
}

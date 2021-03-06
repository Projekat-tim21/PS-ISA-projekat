package rs.ac.uns.ftn.informatika.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.informatika.jpa.dto.DijagnozaDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Dijagnoza;

public interface DijagnozaRepository extends JpaRepository<Dijagnoza,Long>{

	public Dijagnoza findBySifra(String sifra);
	public Dijagnoza findByNaziv(String naziv);
	public Dijagnoza findOneById(Long id);
	//public Dijagnoza save(DijagnozaDTO dijagnoza);
}

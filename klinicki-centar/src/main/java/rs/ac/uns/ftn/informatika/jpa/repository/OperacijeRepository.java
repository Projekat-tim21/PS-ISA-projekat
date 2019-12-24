package rs.ac.uns.ftn.informatika.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.informatika.jpa.model.Operacija;

public interface OperacijeRepository extends JpaRepository<Operacija, Long>{

	List<Operacija> findByObavljenaoperacija(boolean b);

	public Operacija findOneById(Long id);

}

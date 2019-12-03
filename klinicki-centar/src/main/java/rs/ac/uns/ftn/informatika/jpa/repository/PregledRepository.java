package rs.ac.uns.ftn.informatika.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.uns.ftn.informatika.jpa.model.Pregled;
import rs.ac.uns.ftn.informatika.jpa.model.Klinika;

public interface PregledRepository extends JpaRepository<Pregled, Long> {

	public Pregled findOneById(Long id);
	//public Pregled findByDate(String date);



}
package rs.ac.uns.ftn.informatika.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.informatika.jpa.model.Pregled;

public interface PregledRepository extends JpaRepository<Pregled, Long> {

	public Pregled findOneById(Long id);
	public Boolean findByZakazan(Boolean zakazan);
	public Pregled findByDatum(String datum);
	public Pregled findByVreme(String vreme);
	public List<Pregled> findByObavljenpregled(boolean obavljen);

}
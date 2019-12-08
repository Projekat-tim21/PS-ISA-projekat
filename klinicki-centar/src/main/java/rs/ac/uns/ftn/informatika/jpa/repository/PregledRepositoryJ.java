package rs.ac.uns.ftn.informatika.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.informatika.jpa.model.PregledJ;

public interface PregledRepositoryJ extends JpaRepository<PregledJ, Long> {

	public PregledJ findOneById(Long id);
	//public Pregled findByDate(String date);
	public Boolean findByZakazan(Boolean zakazan);
	public PregledJ findByDatum(String datum);
	public PregledJ findByVreme(String vreme);
	//public List<Pregled> findByZakazan();

//	public Pregled findByVremeDatum(String vreme, String datum);

}
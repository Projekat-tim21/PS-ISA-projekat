package rs.ac.uns.ftn.informatika.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.informatika.jpa.model.InformacijeOpregledu;

public interface InforimacijeOpregleduRepository extends JpaRepository<InformacijeOpregledu, Long>{
	
	public InformacijeOpregledu findByLekarId(Long id);
	public InformacijeOpregledu findByPacijentId(Long id);
	public InformacijeOpregledu findByPregledId(Long id);
	public InformacijeOpregledu findByTip(Long id);
	public InformacijeOpregledu findByPregledIdAndTip(Long id,Long idx);

}

package rs.ac.uns.ftn.informatika.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import rs.ac.uns.ftn.informatika.jpa.model.ZaposleniUKlinikama;

public interface ZaposleniUKlinikamaRepository extends JpaRepository<ZaposleniUKlinikama, Long>{

	public List<ZaposleniUKlinikama> findByIdklinike(long idKlinike);

}

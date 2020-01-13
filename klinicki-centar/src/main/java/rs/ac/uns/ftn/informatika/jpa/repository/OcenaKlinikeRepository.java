package rs.ac.uns.ftn.informatika.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.informatika.jpa.model.OcenaKlinike;

public interface OcenaKlinikeRepository extends JpaRepository<OcenaKlinike, Long> {

	public List<OcenaKlinike> findAllById(Long id);

}

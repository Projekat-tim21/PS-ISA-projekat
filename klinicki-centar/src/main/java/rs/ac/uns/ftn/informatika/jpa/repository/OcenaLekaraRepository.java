package rs.ac.uns.ftn.informatika.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.informatika.jpa.model.OcenaLekara;

public interface OcenaLekaraRepository extends JpaRepository<OcenaLekara, Long> {

	public List<OcenaLekara> findAllById(Long id);

	


}

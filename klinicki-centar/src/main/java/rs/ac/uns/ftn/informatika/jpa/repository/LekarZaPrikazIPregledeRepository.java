package rs.ac.uns.ftn.informatika.jpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.informatika.jpa.model.LekarZaPrikazIPreglede;


public interface LekarZaPrikazIPregledeRepository extends JpaRepository<LekarZaPrikazIPreglede, Long>{

	public Optional<LekarZaPrikazIPreglede> findById(Long id);
	public LekarZaPrikazIPreglede findByLekarveza(Long id);
	
	
}

package rs.ac.uns.ftn.informatika.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.informatika.jpa.model.Recept;

public interface ReceptRepository extends JpaRepository<Recept, Long> {
	
	public Recept findByPregledId(Long id);
	public Recept findByPacijentId(Long id);
	public Recept findByOveren(Long id);

}

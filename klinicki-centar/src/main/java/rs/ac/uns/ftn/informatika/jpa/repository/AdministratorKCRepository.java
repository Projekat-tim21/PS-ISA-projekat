package rs.ac.uns.ftn.informatika.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.informatika.jpa.model.AdministratorKC;
import rs.ac.uns.ftn.informatika.jpa.model.Dijagnoza;
import rs.ac.uns.ftn.informatika.jpa.model.Klinika;
import rs.ac.uns.ftn.informatika.jpa.model.Lek;

public interface AdministratorKCRepository extends JpaRepository<AdministratorKC,Long>{

	public AdministratorKC findByUsernameAndPassword(String username,String password);
	public AdministratorKC findByUsername(String username);
	



}

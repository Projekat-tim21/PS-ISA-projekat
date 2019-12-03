package rs.ac.uns.ftn.informatika.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.informatika.jpa.model.Administrator;
import rs.ac.uns.ftn.informatika.jpa.model.Dijagnoza;
import rs.ac.uns.ftn.informatika.jpa.model.Klinika;
import rs.ac.uns.ftn.informatika.jpa.model.Lek;

public interface AdministratirRepository extends JpaRepository<Administrator,Long>{

	public Administrator findByUsernameAndPassword(String username,String password);
	public Administrator findByUsername(String username);
	



}

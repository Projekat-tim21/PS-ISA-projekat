package rs.ac.uns.ftn.informatika.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.informatika.jpa.model.Admin;
import rs.ac.uns.ftn.informatika.jpa.model.Pregled;

public interface AdminRepository extends JpaRepository<Admin, Long> {

	//public Admin findAll(String username);
	public Admin findByUsername(String username);
	public Admin findOneById(Long id);
	public Admin findByEmail(String email);
//	public Admin save(Pregled pregled);
//	public Admin create(Pregled pregled);
	
}

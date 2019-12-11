package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.AdminDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Admin;
import rs.ac.uns.ftn.informatika.jpa.model.Pregled;
import rs.ac.uns.ftn.informatika.jpa.repository.AdminRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.PregledRepository;

@Service
@Transactional
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepo;
	
	AdminDTO adminD;
	
	//@Autowired
	//private PregledRepository pregledRepo;
	
	public AdminService(AdminRepository adminRepo) {
		this.adminRepo = adminRepo;
	}
	
	public List<Admin> findAllAdmins(){
		List<Admin> allAdmins = new ArrayList<Admin>();
		for(Admin admin : adminRepo.findAll()) {
			allAdmins.add(admin);
		}
		return allAdmins;
	}
	
	/*public Pregled getOdobren(Long id) {
		return pregledRepo.findOneById(id);
	}
	
	public Pregled setOdobren(Long id) {
		Pregled pr = pregledRepo.findOneById(id);
		return pregledRepo.save(pr);
	}*/
	
	/*public Admin findAdmin(String username) {
		
		return adminRepo.findByUsername(username);
	}*/

	public Admin findById(Long id) {
		
		return adminRepo.findOneById(id);
	}
	
	public Admin findAdminByEmail(String email) {
		
		return adminRepo.findByEmail(email);
		
	}
	
	public Admin findByUsername(String username) {
		
		return adminRepo.findByUsername(username);
	}

/*	public Admin save(Pregled pregled) {
		// TODO Auto-generated method stub
		return adminRepo.save(pregled);
	}

	public Admin create(Pregled pregled) {
		// TODO Auto-generated method stub
		return adminRepo.create(pregled);
	}
	*/
	
}

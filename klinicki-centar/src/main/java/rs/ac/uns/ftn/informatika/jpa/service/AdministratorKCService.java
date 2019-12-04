package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.List;

import rs.ac.uns.ftn.informatika.jpa.model.AdministratorKC;

public interface AdministratorKCService {
	
	public AdministratorKC findOne(Long id);
	
	public List<AdministratorKC> findAll();
	
	public AdministratorKC save(AdministratorKC admin);
	
	public List<AdministratorKC> save(List<AdministratorKC> admins);
	
	public AdministratorKC delete(Long id);
	
	public void delete(List<Long> ids);
	
	//public AdministratorKC createAdminKC(AdministratorKCDTO )

}

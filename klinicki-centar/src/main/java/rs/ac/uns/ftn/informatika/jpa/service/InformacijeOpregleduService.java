package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.InformacijeOpregledu;
import rs.ac.uns.ftn.informatika.jpa.model.Korisnik;
import rs.ac.uns.ftn.informatika.jpa.repository.InforimacijeOpregleduRepository;

@Service
@Transactional
public class InformacijeOpregleduService {

	private final InforimacijeOpregleduRepository infoRepo;

	public InformacijeOpregleduService(InforimacijeOpregleduRepository info) {
		super();
		this.infoRepo = info;
	}
	
	public void saveInformacije(InformacijeOpregledu info) {
		infoRepo.save(info);
	}
	
	public List<InformacijeOpregledu> pokaziZaOveru(){
		
		List<InformacijeOpregledu> overi=new ArrayList<InformacijeOpregledu>();
		for(InformacijeOpregledu infp : infoRepo.findAll()) {
			if(infp.getOveren()==false) {
				overi.add(infp);
			}
		}
		return overi;
		
	}

	public InformacijeOpregledu findOne(Long id) {
		// TODO Auto-generated method stub
		return infoRepo.findById(id).orElseGet(null);
	}

	public void saveRecept(InformacijeOpregledu i) {
		// TODO Auto-generated method stub
		infoRepo.save(i);
	}

	public List<InformacijeOpregledu> izvestajiDatogPacijenta(Long pacijentId) {
		List<InformacijeOpregledu> pacijentovi=new ArrayList<InformacijeOpregledu>();
		for(InformacijeOpregledu infp : infoRepo.findAll()) {
			if(infp.getPacijentId()==pacijentId) {
				pacijentovi.add(infp);
			}
		}
		return pacijentovi;
	}
	}

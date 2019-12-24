package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.LekarZaPrikazIPreglede;
import rs.ac.uns.ftn.informatika.jpa.model.OcenaLekara;
import rs.ac.uns.ftn.informatika.jpa.model.TerminiSaId;
import rs.ac.uns.ftn.informatika.jpa.repository.LekarZaPrikazIPregledeRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.OcenaLekaraRepository;

@Service
@Transactional
public class OcenaLekaraServis {

	
	private final OcenaLekaraRepository olRepo;
		

		
		public OcenaLekaraServis(OcenaLekaraRepository olRepo) {
			this.olRepo=olRepo;
		}
		
		
		
		public void saveOcenaLekara(OcenaLekara ocenalekara) {
			olRepo.save(ocenalekara);
		}
		
		public OcenaLekara findOne(Long id) {
			return olRepo.findById(id).orElseGet(null);
		}


		public void setOcenaLekaraUNjegovojKlasi(Long lekarid, double ocenapregleda) {
			// TODO Auto-generated method stub
			
			
		}
	
	
	
}
